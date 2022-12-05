package com.loda.controller;

import com.loda.base.BaseController;
import com.loda.base.ResultInfo;
import com.loda.dao.ModuleMapper;
import com.loda.entity.po.Module;
import com.loda.entity.vo.TreeModel;
import com.loda.service.ModuleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Author loda
 * @Date 2022/11/28 21:03
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Controller
@RequestMapping("module")
public class ModuleController extends BaseController {
    @Resource
    private ModuleService moduleService;

    /**
     * 查询所有的资源列表
     * @return
     */
    @RequestMapping("queryAllModules")
    @ResponseBody
    public List<TreeModel> queryAllModules(Integer roleId) {
        return moduleService.queryAllModules(roleId);
    }

    @RequestMapping("toAddGrantPage")
    public String toAddGrantPage(Integer roleId, HttpServletRequest request) {
        //将需要授权的角色ID设置到请求域中
        request.setAttribute("roleId", roleId);
        return "role/grant";
    }

    /**
     * 显示所有的资源（菜单）
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> queryModuleList() {
        return moduleService.queryModuleList();
    }

    /**
     * 进入资源页面
     * @return
     */
    @RequestMapping("index")
    public String index() {
        return "module/module";
    }

    /**
     * 添加资源
     * @param module
     * @return
     */
    @PostMapping("add")
    @ResponseBody
    public ResultInfo addModule(Module module) {
        moduleService.addModule(module);
        return success("添加资源成功！");
    }

    /**
     * 更新资源
     * @param module
     * @return
     */
    @PostMapping("update")
    @ResponseBody
    public ResultInfo updateModule(Module module) {
        moduleService.updateModule(module);
        return success("更新资源成功！");
    }

    /**
     * 删除资源
     * @param mId
     * @return
     */
    @PostMapping("delete")
    @ResponseBody
    public ResultInfo deleteModule(Integer mId) {
        moduleService.deleteModule(mId);
        return success("删除资源成功！");
    }

    /**
     * 打开添加资源的页面
     * @param grade
     * @param parentId
     * @param request
     * @return
     */
    @RequestMapping("toAddModulePage")
    public String toAddModulePage(Integer grade, Integer parentId, HttpServletRequest request) {
        request.setAttribute("grade", grade);
        request.setAttribute("parentId", parentId);
        return "module/add";
    }

    /**
     * 打开修改资源的页面
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("toUpdateModulePage")
    public String toUpdateModulePage(Integer id, HttpServletRequest request) {
        if (id != null) {
            Module module = moduleService.selectByPrimaryKey(id);
            request.setAttribute("module", module);
        }
        return "module/update";
    }
}
