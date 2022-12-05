package com.loda.controller;

import com.loda.base.BaseController;
import com.loda.base.ResultInfo;
import com.loda.entity.po.CusDevPlan;
import com.loda.entity.po.SaleChance;
import com.loda.enums.StateStatus;
import com.loda.query.CusDevPlanQuery;
import com.loda.query.SaleChanceQuery;
import com.loda.service.CusDevPlanService;
import com.loda.service.SaleChanceService;
import com.loda.utils.LoginUserUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author loda
 * @Date 2022/11/24 20:46
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Controller
@RequestMapping("cus_dev_plan")
public class CusDevPlanController extends BaseController{
    @Resource
    private CusDevPlanService cusDevPlanService;

    @Resource
    private SaleChanceService saleChanceService;
    /**
     * 客户开发计划页面
     * @return
     */
    @RequestMapping("index")
    public String index() {
        return "cusDevPlan/cus_dev_plan";
    }

    /**
     * 打开计划项开发与详情页面
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("toCusDevPlanPage")
    public String toCusDevPlanPage(Integer id, HttpServletRequest request) {
        //通过id查询营销机会对象
        SaleChance saleChance = saleChanceService.selectByPrimaryKey(id);
        //将对象设置到请求域中
        request.setAttribute("saleChance", saleChance);
        return "cusDevPlan/cus_dev_plan_data";
    }

    /**
     * 多条件查询 客户开发计划
     * @param cusDevPlanQuery
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> selectCusDevPlanByParams(CusDevPlanQuery cusDevPlanQuery) {

        return cusDevPlanService.selectCusDevPlanByParams(cusDevPlanQuery);
    }

    /**
     * 添加计划项
     * @param cusDevPlan
     * @return
     */
    @PostMapping("add")
    @ResponseBody
    public ResultInfo addCusDevPlan(CusDevPlan cusDevPlan) {
        cusDevPlanService.addCusDevPlan(cusDevPlan);
        return success("计划项添加成功！");
    }

    /**
     * 更新计划项
     * @param cusDevPlan
     * @return
     */
    @PostMapping("update")
    @ResponseBody
    public ResultInfo updateCusDevPlan(CusDevPlan cusDevPlan) {
        cusDevPlanService.updateCusDevPlan(cusDevPlan);
        return success("计划更新成功！");
    }

    @RequestMapping("toAddOrUpdateCusDevPlanPage")
    public String toAddOrUpdateCusDevPlanPage(Integer sId, HttpServletRequest request, Integer id) {
        //将营销机会ID设置到请求域中，给计划项页面获取
        request.setAttribute("sId", sId);
        //通过计划项ID查询记录
        CusDevPlan cusDevPlan = cusDevPlanService.selectByPrimaryKey(id);
        //将计划项数据设置到请求域中
        request.setAttribute("cusDevPlan", cusDevPlan);
        return "cusDevPlan/add_update";
    }

    @PostMapping("delete")
    @ResponseBody
    public ResultInfo deleteCusDevPlan(Integer id){
        cusDevPlanService.deleteCusDevPlan(id);
        return success("计划项删除成功");
    }
}
