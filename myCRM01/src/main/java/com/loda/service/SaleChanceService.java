package com.loda.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.loda.base.BaseService;
import com.loda.dao.SaleChanceMapper;
import com.loda.entity.po.SaleChance;
import com.loda.enums.DevResult;
import com.loda.enums.StateStatus;
import com.loda.query.SaleChanceQuery;
import com.loda.utils.AssertUtil;
import com.loda.utils.PhoneUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author loda
 * @Date 2022/11/22 17:18
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Service
public class SaleChanceService extends BaseService<SaleChance, Integer> {
    @Resource
    private SaleChanceMapper saleChanceMapper;

    /**
     *  多条件查询 SaleChance
     *  返回的数据格式必须满足LayUi中数据表格的要求
     * @return
     */
    public Map<String, Object> selectSaleChanceByParams(SaleChanceQuery saleChanceQuery) {

        Map<String, Object> map = new HashMap<>();
        //开启分页
        PageHelper.startPage(saleChanceQuery.getPage(), saleChanceQuery.getLimit());
        //得到对应分页对象
        PageInfo<SaleChance> pageInfo = new PageInfo<>(saleChanceMapper.selectByParams(saleChanceQuery));

        //设置map对象
        map.put("code", 0);
        map.put("msg", "success");
        map.put("count", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return map;
    }

    /**
     * 1.参数校验
     *      customerName客户名 非空
     *      linkMan联系人  非空
     *      linkPhone联系号码  非空、11位手机号格式正确
     * 2. 设置相关参数默认值
     *      createMan创建人    当前登录用户名，controller中已经设置
     *      assignMan指派人
     *          如果未设置指派人（默认）
     *              state分配状态（0=未分配，1=已分配）
     *                  0=未分配
     *               assignTime指派时间
     *                  null
     *              devResult开发状态（0=未开发 1=开发中 2=开发成功 3=开发失败）
     *                  0=未开发
     *          如果设置了指派人
     *              state分配状态（0=未分配，1=已分配）
     *                  1=已分配
     *              assignTime指派时间
     *                  系统当前时间
     *              devResult开发状态（0=未开发 1=开发中 2=开发成功 3=开发失败）
     *                  1=开发中
     *       isValid是否有效  默认有效(1-有效  0-无效)
     *          设置为有效 1-有效
     *       createDate：创建时间
     *          默认系统当前时间
     *       updateDate:
     *          默认系统当前时间
     * 3.执行添加 判断添加结果
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void addSaleChance(SaleChance saleChance){
        //参数校验
        argsCheck(saleChance.getCustomerName(), saleChance.getLinkMan(), saleChance.getLinkPhone());

        //设置参数
        if (StringUtils.isBlank(saleChance.getAssignMan())) {
            saleChance.setState(StateStatus.UNSTATE.getType());
            saleChance.setAssignTime(null);
            saleChance.setDevResult(DevResult.UNDEV.getStatus());
        }else {
            saleChance.setState(StateStatus.STATED.getType());
            saleChance.setAssignTime(new Date());
            saleChance.setDevResult(DevResult.DEVING.getStatus());
        }

        saleChance.setIsValid(1);
        saleChance.setCreateDate(new Date());
        saleChance.setUpdateDate(new Date());
//        3.执行添加 判断添加结果
        AssertUtil.isTrue(saleChanceMapper.insertSelective(saleChance)<1, "营销机会添加失败");
    }

    /**
     * 更新营销机会
     * 1：参数校验
     *      营销机会ID  非空，数据库中对应的记录存在
     *      customerName客户名称    非空
     *      linkMan联系人  非空
     *      linkPhone联系号码  非空、11位手机号格式正确
     * 2：设置相关参数的默认值
     *      updateDate更新时间      设置为系统当前时间
     *      assignMan指派人
     *          原始数据未设置
     *              修改后未设置
     *                  不需要操作
     *              修改后已设置
     *                  assignTime指派时间  设置为系统当前时间
     *                  分配状态    1=已分配
     *                  开发状态    1=开发中
     *          原始数据已设置
     *              修改后未设置
     *                  assignTime指派时间  设置为null
     *                  分配状态    0=已分配
     *                  开发状态    0=开发中
     *              修改后已设置
     *                  判断修改前后是否是同一个指派人
     *                      如果是同一个指派人，需更新saleChance对象中的assignTime为原始时间
     *                      如果不是，则需要更新assignTime指派时间  设置为系统当前时间
     * 3：执行更新操作，判断受影响的行数
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateSaleChance(SaleChance saleChance) {
        //参数校验
        Integer id =  saleChance.getId();
        AssertUtil.isTrue(id == null, "待更新条目不存在");
        SaleChance tmp = saleChanceMapper.selectByPrimaryKey(id);
        AssertUtil.isTrue(tmp == null, "待更新条目不存在");
        argsCheck(saleChance.getCustomerName(), saleChance.getLinkMan(), saleChance.getLinkPhone());
        //设置参数
        saleChance.setUpdateDate(new Date());
        //设置指派人
        //如果原始数据指派人未设置
        if (StringUtils.isBlank(tmp.getAssignMan())){
            //修改后已设置
            //ssignTime指派时间  设置为系统当前时间 分配状态    1=已分配  开发状态    1=开发中
            if (!StringUtils.isBlank(saleChance.getAssignMan())) {
                saleChance.setAssignTime(new Date());
                saleChance.setState(StateStatus.STATED.getType());
                saleChance.setDevResult(DevResult.DEVING.getStatus());
            }
            //修改后未设置不用处理
        }else {//如果原始数据指派人已设置
            //修改后未设置 assignTime指派时间  设置为null 分配状态    0=已分配  开发状态    0=开发中
            if (StringUtils.isBlank(saleChance.getAssignMan())) {
                saleChance.setAssignTime(null);
                saleChance.setState(StateStatus.UNSTATE.getType());
                saleChance.setDevResult(DevResult.UNDEV.getStatus());
            }else { //修改后已设置
                //判断修改前后是否是同一个指派人
                //如果不是同一个指派人，则需要更新assignTime指派时间  设置为系统当前时间
                if (!tmp.getAssignMan().equals(saleChance.getAssignMan())) {
                    saleChance.setAssignTime(new Date());
                } else {//如果是同一个指派人，需更新saleChance对象中的assignTime为原始时间
                    saleChance.setAssignTime(tmp.getAssignTime());
                }
            }
        }
        //3：执行更新操作，判断受影响的行数
        AssertUtil.isTrue(saleChanceMapper.updateByPrimaryKeySelective(saleChance)!=1, "营销机会更新失败！");
    }

    //参数校验
    private void argsCheck(String customerName, String linkMan, String linkPhone) {
        //参数校验
        AssertUtil.isTrue(StringUtils.isBlank(customerName), "客户名不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(linkMan), "联系人不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(linkPhone), "手机号码不能为空");
        AssertUtil.isTrue(!PhoneUtil.isMobile(linkPhone), "手机号码格式不正确");
    }

    //删除记录

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteSaleChance(Integer[] ids)  {
        AssertUtil.isTrue(ids == null || ids.length < 1, "请选择要删除的条目！");
        AssertUtil.isTrue(saleChanceMapper.deleteBatch(ids) != ids.length, "删除条目失败！");
    }
}
