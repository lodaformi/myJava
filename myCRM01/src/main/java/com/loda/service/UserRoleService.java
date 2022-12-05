package com.loda.service;

import com.loda.base.BaseService;
import com.loda.dao.UserRoleMapper;
import com.loda.entity.po.UserRole;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author loda
 * @Date 2022/11/28 10:21
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Service
public class UserRoleService extends BaseService<UserRole, Integer> {
    @Resource
    private UserRoleMapper userRoleMapper;
}
