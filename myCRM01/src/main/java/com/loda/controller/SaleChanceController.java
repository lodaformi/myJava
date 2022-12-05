package com.loda.controller;

import com.loda.annotation.RequiredPermission;
import com.loda.base.BaseController;
import com.loda.base.ResultInfo;
import com.loda.entity.po.SaleChance;
import com.loda.enums.StateStatus;
import com.loda.query.SaleChanceQuery;
import com.loda.service.SaleChanceService;
import com.loda.service.UserService;
import com.loda.utils.CookieUtil;
import com.loda.utils.LoginUserUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Author loda
 * @Date 2022/11/22 17:16
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Controller
@RequestMapping("sale_chance")
public class SaleChanceController extends BaseController {
    @Resource
    private SaleChanceService saleChanceService;

    /**
     * 多条件查询
     * code 101001
     *  如果flag的值不为空，且值为1，则表示当前查询的是客户开发计划；否则查询营销机会
     * @param saleChanceQuery
     * @param flag
     * @param request
     * @return
     */
//    @RequiredPermission(code = "101001")
    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> selectSaleChanceByParams(SaleChanceQuery saleChanceQuery, Integer flag, HttpServletRequest request) {
        //查询客户开发计划
        if (flag != null && flag == 1) {
            //设置分配状态
            saleChanceQuery.setState(StateStatus.STATED.getType());
            //设置指派人（当前登录用户的ID）
            //从cookie中获取当前登录用户的ID
            Integer idStr = LoginUserUtil.releaseUserIdFromCookie(request, "userIdStr");
            saleChanceQuery.setAssignMan(idStr);
        }
        return saleChanceService.selectSaleChanceByParams(saleChanceQuery);
    }

    /**
     * 进入营销机会管理页面
     * code 1010
     * @return
     */
    @RequiredPermission(code = "1010")
    @RequestMapping("index")
    public String index() {
        return "saleChance/sale_chance";
    }

    /**
     * 添加营销机会
     * code 101002
     * @param request
     * @param saleChance
     * @return
     */
    @RequiredPermission(code = "101002")
    @PostMapping("add")
    @ResponseBody
    public ResultInfo addSaleChance(HttpServletRequest request, SaleChance saleChance){
        //获取当前登录用户的用户名
        String userName = CookieUtil.getCookieValue(request, "userName");
        //设置到对象中
        saleChance.setCreateMan(userName);
        //调用service方法
        saleChanceService.addSaleChance(saleChance);
        //如果上面方法调用正常返回，表示数据添加成功
        return success("营销机会添加成功");
    }

    /**
     * 更新营销机会
     * code 101004
     * @param saleChance
     * @return
     */
    @RequiredPermission(code = "101004")
    @PostMapping("update")
    @ResponseBody
    public ResultInfo updateSaleChance(SaleChance saleChance){
        //调用service方法
        saleChanceService.updateSaleChance(saleChance);
        //如果上面方法调用正常返回，表示数据添加成功
        return success("营销机会更新成功");
    }

    /**
     * 进入添加/修改营销机会数据页面
     * @return
     */
    @RequestMapping("toSaleChancePage")
    public String toSaleChancePage(Integer saleChanceId, HttpServletRequest request){
        if (saleChanceId != null) {
            SaleChance saleChance = saleChanceService.selectByPrimaryKey(saleChanceId);
            request.setAttribute("saleChance", saleChance);
        }
        return "saleChance/add_update";
    }

    /**
     * 删除营销机会
     * code 101003
     * @param ids
     * @return
     */
    @RequiredPermission(code = "101003")
    @PostMapping("delete")
    @ResponseBody
    public ResultInfo deleteSaleChance(Integer[] ids) {
        saleChanceService.deleteSaleChance(ids);
        return success("营销机会删除成功！");
    }
}
