package com.loda.service;

import com.loda.base.BaseService;
import com.loda.dao.ModuleMapper;
import com.loda.dao.PermissionMapper;
import com.loda.entity.po.Module;
import com.loda.entity.vo.TreeModel;
import com.loda.utils.AssertUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Author loda
 * @Date 2022/11/28 21:02
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Service
public class ModuleService extends BaseService<Module, Integer> {
    @Resource
    private ModuleMapper moduleMapper;

    @Resource
    private PermissionMapper permissionMapper;

    /**
     * 查询所有的资源列表
     * @return
     */
    public List<TreeModel> queryAllModules(Integer roleId) {
        //查询所有的资源列表
        List<TreeModel> treeModelList = moduleMapper.queryAllModules();
        //查询指定角色已经授权过的资源列表(查询角色拥有的资源ID)
        List<Integer> permissionIds = permissionMapper.queryRoleHasModuleIdsByRoleId(roleId);
        //判断角色是否拥有资源ID
        if (permissionIds != null && permissionIds.size() > 0) {
            //循环所有的资源列表，判断用户拥有的资源ID中是否有匹配的，如果有，则设置checked属性为true
            treeModelList.forEach(treeModel -> {
                //判断角色拥有的资源ID中是否有当前遍历的资源ID
                if (permissionIds.contains(treeModel.getId())) {
                    //如果包含，则说明角色授权过，设置checked为true
                    treeModel.setChecked(true);
                }
            });
        }
        return treeModelList;
    }

    /**
     * 查询资源数据
     * @return
     */
    public Map<String, Object> queryModuleList() {
        Map<String, Object> map = new HashMap<>();
        //查询资源列表
        List<Module> moduleList = moduleMapper.queryModuleList();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", moduleList.size());
        map.put("data", moduleList);

        return map;
    }

    /**
     添加资源
         1。参数校验
            层级 grade
                非空，0|1|2
            模块名称 moduleName
                非空，同一层级下模块名称唯一
            地址url
                二级菜单(grade=1)，非空且同一层级下不可重复
            父级菜单 parentId
                一级菜单(目录grade=0)  -1
                二级|三级菜单（菜单|按钮grade=1或2) 非空,父级菜单必须存在
            权限码optValue
                非空，不可重复
         2。设置参数的默认值
             是否有效isValid1
             创建时间createDate  系统当前时间
             修改时间updateDate  系统当前时间
        3。执行添加操作，判断受影响的行数
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void addModule(Module module) {
        Integer grade = module.getGrade();
        //层级 grade 非空
        AssertUtil.isTrue(grade == null ,"等级不能为空！");
        //层级 grade 必须为0|1|2
        AssertUtil.isTrue(!(grade == 0 || grade == 1 || grade == 2), "等级不符合要求！");
        //模块名称  moduleName 非空
        AssertUtil.isTrue(StringUtils.isBlank(module.getModuleName()),"模块名不能为空！");
        //模块名称  同一层级下模块名称唯一（不能存在同名的模块）
        AssertUtil.isTrue(moduleMapper.queryModuleByGradeAndModuleName(grade, module.getModuleName()) != null, "模块名已存在！");

        //地址url 二级菜单(grade=1)，非空且同一层级下不可重复
        if (grade == 1) {
            AssertUtil.isTrue(StringUtils.isBlank(module.getUrl()), "url不能为空");
            AssertUtil.isTrue(moduleMapper.queryModuleByGradeAndUrl(grade, module.getUrl()) != null, "url不能重复！");
        }
        //父级菜单 parentId
        //一级菜单(目录grade=0)  -1
        if (grade == 0) {
            module.setParentId(-1);
        }

        //二级|三级菜单（菜单|按钮grade=1或2) 非空,父级菜单必须存在
        if (grade == 1|| grade == 2) {
            AssertUtil.isTrue(module.getParentId() == null, "父级菜单必须存在！");
            AssertUtil.isTrue( moduleMapper.selectByPrimaryKey(module.getParentId()) == null,"父级菜单不正确！");
        }
        //权限码optValue
        // 非空，不可重复
        AssertUtil.isTrue(module.getOptValue() == null, "权限码不能为空");
        // 不可重复
        AssertUtil.isTrue(moduleMapper.queryModuleByOptValue(module.getOptValue()) != null, "权限码已存在！");

        //2。设置参数的默认值
        //是否有效isValid
        module.setIsValid((byte) 1);
        //创建时间createDate  系统当前时间
        module.setCreateDate(new Date());
        //修改时间updateDate  系统当前时间
        module.setUpdateDate(new Date());

        //3。执行添加操作，判断受影响的行数
        AssertUtil.isTrue(moduleMapper.insertSelective(module) != 1, "添加模块失败！");
    }

    /**
     修改资源
         1：参数校验
                id
                    非空，数据存在
                层级grade
                    非空0|1|2
                模块名称 moduleName
                    非空，同一层级下模块名称唯一(不包含当前修改记录本身)
                地址url
                    二级菜单(grade1)，非空且同一层级下不可重复（不包含当前修改记录本身)
                权限码optValue
                    非空，不可重复（不包含当前修改记录本身)
         2。设置参数的默认值
                修改时间updateDate系统当前时间
         3.执行更新操作，判断受影响的行数
     * @param module
     */
    public void updateModule(Module module) {
        //id
        Integer id = module.getId();
        AssertUtil.isTrue(id == null, "未选中修改记录！");
        AssertUtil.isTrue(moduleMapper.selectByPrimaryKey(id)==null, "待修改记录不存在！");

        //层级grade
        Integer grade = module.getGrade();
        AssertUtil.isTrue(grade == null, "等级不能为空！");
        AssertUtil.isTrue(!(grade == 0 || grade == 1| grade == 2), "等级不正确！");

        //模块名称 moduleName
        String moduleName = module.getModuleName();
        AssertUtil.isTrue(StringUtils.isBlank(moduleName), "模块名称不能为空！");
        Module temp = moduleMapper.queryModuleByGradeAndModuleName(grade, moduleName);
        if (temp != null) {
            AssertUtil.isTrue(!(module.getId().equals(temp.getId())), "模块名称已存在！");
        }

        if (grade == 1) {
            String url = module.getUrl();
            AssertUtil.isTrue(StringUtils.isBlank(url), "url不能为空！");
            temp = moduleMapper.queryModuleByGradeAndUrl(grade, url);
            if (temp != null) {
                AssertUtil.isTrue(!(module.getId().equals(temp.getId())), "url已存在！");
            }
        }

        //权限码optValue 非空，不可重复（不包含当前修改记录本身)
        String optValue = module.getOptValue();
        AssertUtil.isTrue(StringUtils.isBlank(optValue), "权限码不能为空！");
        temp = moduleMapper.queryModuleByOptValue(optValue);
        if (temp != null) {
            AssertUtil.isTrue(!(module.getId().equals(temp.getId())), "权限码已存在！");
        }

        //2。设置参数的默认值
        //   修改时间updateDate系统当前时间
        module.setUpdateDate(new Date());
        //         3.执行更新操作，判断受影响的行数
        AssertUtil.isTrue(moduleMapper.updateByPrimaryKeySelective(module)!=1, "更新资源失败！");
    }

    /**
     * 删除资源
     *  参数校验
     *      mId非空，对应模块存在
     *  如果mId下有其他模块，不能删除
     *  删除权限表中的记录
     *  更新（删除）资源表中的有效位
     *
     *  设置更新时间
     *
     *  判断更新情况
     * @param mId
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteModule(Integer mId) {
        //判断id是否为空
        AssertUtil.isTrue(mId == null, "待删除记录不存在！");

        //通过id查询资源对象
        Module module = moduleMapper.selectByPrimaryKey(mId);
        //判断资源对象是否为空
        AssertUtil.isTrue(module == null, "待删除记录不存在！");

        //如果当前资源存在子记录(将id当做父Id查询资源记录)，如果存在子记录，则不可删除
        AssertUtil.isTrue(moduleMapper.countModuleByParentId(mId) > 0, "存在子记录，不能删除！");

        //通过资源id查询权限表中是否存在数据
        Integer count = permissionMapper.countPermissionByModuleId(mId);
        //判断是否存在，存在则删除
        if (count > 0) {
            //删除指定资源ID的权限记录
            permissionMapper.deletePermissionByModuleId(mId);
        }

        //设置记录无效
        module.setIsValid((byte) 0);
        module.setUpdateDate(new Date());

        //执行更新
        AssertUtil.isTrue(moduleMapper.updateByPrimaryKeySelective(module) != 1, "删除资源失败");
    }
}
