package com.loda.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.loda.base.BaseService;
import com.loda.dao.CusDevPlanMapper;
import com.loda.dao.SaleChanceMapper;
import com.loda.entity.po.CusDevPlan;
import com.loda.query.CusDevPlanQuery;
import com.loda.utils.AssertUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author loda
 * @Date 2022/11/25 15:31
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Service
public class CusDevPlanService extends BaseService<CusDevPlan, Integer> {
    @Resource
    private CusDevPlanMapper cusDevPlanMapper;

    @Resource
    private SaleChanceMapper saleChanceMapper;

    /**
     *  多条件查询 cusDevPlan
     *  返回的数据格式必须满足LayUi中数据表格的要求
     * @return
     */
    public Map<String, Object> selectCusDevPlanByParams(CusDevPlanQuery cusDevPlanQuery) {
        Map<String, Object> map = new HashMap<>();
        //开启分页
        PageHelper.startPage(cusDevPlanQuery.getPage(), cusDevPlanQuery.getLimit());
        //得到对应分页对象
        PageInfo<CusDevPlan> pageInfo = new PageInfo<>(cusDevPlanMapper.selectByParams(cusDevPlanQuery));

        //设置map对象
        map.put("code", 0);
        map.put("msg", "success");
        map.put("count", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return map;
    }

    /**
     * 添加客户开发计划项数据
     * 1：参数校验
     *      营销机会ID      非空，数据存在
     *      计划项内容       非空
     *      计划时间         非空
     * 2.设置参数的默认值
     *      是否有效        默认有效
     *      创建时间        系统当前时间
     *      修改时间        系统当前时间
     * 3.执行添加操作，判断受影响的行数
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void  addCusDevPlan(CusDevPlan cusDevPlan) {
        //1：参数校验
        checkCusDevPlanParams(cusDevPlan);
//        Integer id = cusDevPlan.getSaleChanceId();
//        AssertUtil.isTrue(id == null || saleChanceMapper.selectByPrimaryKey(id)==null, "条目不存在！");
//        AssertUtil.isTrue(StringUtils.isBlank(cusDevPlan.getPlanItem()), "计划项内容不能为空！");
//        AssertUtil.isTrue(cusDevPlan.getPlanDate() == null, "计划时间不能为空！");
        //2.设置参数的默认值
        cusDevPlan.setIsValid(1);
        cusDevPlan.setCreateDate(new Date());
        cusDevPlan.setUpdateDate(new Date());
        //3.执行添加操作，判断受影响的行数
        AssertUtil.isTrue(cusDevPlanMapper.insertSelective(cusDevPlan) != 1, "计划项数据添加失败！");
    }


    /**
     * 更新客户开发计划项数据
     * 1：参数校验
     *      计划项ID       非空，数据存在
     *      营销机会ID      非空，数据存在
     *      计划项内容       非空
     *      计划时间         非空
     * 2.设置参数的默认值
     *      修改时间        系统当前时间
     * 3.执行更新操作，判断受影响的行数
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void  updateCusDevPlan(CusDevPlan cusDevPlan) {
        //1：参数校验
        AssertUtil.isTrue(cusDevPlan.getId() == null ||
                cusDevPlanMapper.selectByPrimaryKey(cusDevPlan.getId())== null,
                "数据异常，请重试！");
        checkCusDevPlanParams(cusDevPlan);

        //2.设置参数的默认值
        cusDevPlan.setUpdateDate(new Date());
        //3.执行添加操作，判断受影响的行数
        AssertUtil.isTrue(cusDevPlanMapper.updateByPrimaryKeySelective(cusDevPlan) != 1, "计划项数据更新失败！");
    }

    private void checkCusDevPlanParams(CusDevPlan cusDevPlan) {
        Integer id = cusDevPlan.getSaleChanceId();
        AssertUtil.isTrue(id == null || saleChanceMapper.selectByPrimaryKey(id)==null, "条目不存在！");
        AssertUtil.isTrue(StringUtils.isBlank(cusDevPlan.getPlanItem()), "计划项内容不能为空！");
        AssertUtil.isTrue(cusDevPlan.getPlanDate() == null, "计划时间不能为空！");
    }

    /**
     * 删除计划项
     * @param id
     */
    public void deleteCusDevPlan(Integer id) {
        //判断ID是否为空，且数据存在
        AssertUtil.isTrue(id == null, "待删除记录不存在");
        //通过ID查询计划项对象
        CusDevPlan cusDevPlan = cusDevPlanMapper.selectByPrimaryKey(id);
        //设置记录无效（假删除）
        cusDevPlan.setIsValid(0);
        cusDevPlan.setUpdateDate(new Date());
        //执行更新操作
        AssertUtil.isTrue(cusDevPlanMapper.updateByPrimaryKeySelective(cusDevPlan)!=1,"计划项数据删除失败");
    }
}
