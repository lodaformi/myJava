package com.loda.service;

import com.loda.base.BaseService;
import com.loda.dao.PermissionMapper;
import com.loda.entity.po.Permission;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author loda
 * @Date 2022/11/29 16:32
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Service
public class PermissionService extends BaseService<Permission, Integer> {
    @Resource
    private PermissionMapper permissionMapper;

    /**
     * 通过查询用户拥有的角色，角色拥有的资源，得到用户拥有的资源列表（资源权限码）
     * @param userId
     * @return
     */
    public List<String> queryUserHasRoleHasPermissionByUserId(Integer userId) {
        return permissionMapper.queryUserHasRoleHasPermissionByUserId(userId);
    }
}
