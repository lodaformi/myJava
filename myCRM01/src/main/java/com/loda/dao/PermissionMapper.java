package com.loda.dao;

import com.loda.base.BaseMapper;
import com.loda.entity.po.Permission;

import java.util.List;

public interface PermissionMapper extends BaseMapper<Permission, Integer> {
    //通过角色ID查询权限记录
    Integer countPermissionByRoleId(Integer roleId);

    //通过角色ID删除权限记录
    void deletePermissionByRoleId(Integer roleId);

    //查询角色拥有的所有资源ID的集合
    List<Integer> queryRoleHasModuleIdsByRoleId(Integer roleId);

    //通过用户ID查询对应的资源列表(资源权限码
    List<String> queryUserHasRoleHasPermissionByUserId(Integer userId);

    //通过资源mId查询权限表中是否存在数据
    Integer countPermissionByModuleId(Integer mId);

    //删除指定资源mId的权限记录
    Integer deletePermissionByModuleId(Integer mId);
}