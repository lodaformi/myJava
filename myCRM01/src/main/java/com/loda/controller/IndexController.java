package com.loda.controller;

import com.loda.base.BaseController;
import com.loda.entity.po.User;
import com.loda.entity.vo.UserModel;
import com.loda.service.PermissionService;
import com.loda.service.UserService;
import com.loda.utils.CookieUtil;
import com.loda.utils.LoginUserUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author loda
 * @Date 2022/11/21 10:58
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Controller
public class IndexController extends BaseController {
    @Resource
    private UserService userService;

    @Resource
    private PermissionService permissionService;
    /**
     * 系统登录页
     * @return
     */
    @RequestMapping("index")
    public String index(){
        return "index";
    }
    // 系统界面欢迎页
    @RequestMapping("welcome")
    public String welcome(){
        return "welcome";
    }
    /**
     * 后端管理主页面
     * @return
     */
    @RequestMapping("main")
    public String main(HttpServletRequest request){
        //获取cookie中的用户Id
        Integer userId = LoginUserUtil.releaseUserIdFromCookie(request, "userIdStr");
//        String userName = CookieUtil.getCookieValue(request, "userName");
        //查询用户对象
        User user = userService.selectByPrimaryKey(userId);
//        UserModel userModel = new UserModel();
//        userModel.setUserName(userName);
        //设置session作用域
        request.getSession().setAttribute("user", user);

        //通过当前登录用户ID查询当前登录用户拥有的资源列表(查询对应资源的授权码)
        List<String> permissions = permissionService.queryUserHasRoleHasPermissionByUserId(userId);
        request.getSession().setAttribute("permissions", permissions);

        return "main";
    }
}
