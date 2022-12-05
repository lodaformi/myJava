package com.loda.interceptors;

import com.loda.dao.UserMapper;
import com.loda.entity.po.User;
import com.loda.exceptions.NoLoginException;
import com.loda.utils.LoginUserUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author loda
 * @Date 2022/11/22 16:13
 * @Description 非法请求拦截
 * @Version 1.0
 */
public class NoLoginInterceptor extends HandlerInterceptorAdapter {
    @Resource
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断用户是否登陆
        // 即判断是否存在相应cookie，从cookie中获取id后，还需根据id去数据库中查询，防止cookie伪造
        Integer userid = LoginUserUtil.releaseUserIdFromCookie(request, "userIdStr");
        User user = userMapper.selectByPrimaryKey(userid);
        if (userid == null || user == null) {
            throw new NoLoginException();
        }
        return true;
    }
}
