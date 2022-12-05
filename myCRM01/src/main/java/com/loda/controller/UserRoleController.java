package com.loda.controller;

import com.loda.base.BaseController;
import com.loda.service.UserRoleService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @Author loda
 * @Date 2022/11/28 10:22
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Controller
public class UserRoleController extends BaseController {
    @Resource
    private UserRoleService userRoleService;
}
