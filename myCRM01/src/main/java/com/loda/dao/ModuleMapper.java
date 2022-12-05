package com.loda.dao;

import com.loda.base.BaseMapper;
import com.loda.entity.po.Module;
import com.loda.entity.vo.TreeModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModuleMapper extends BaseMapper<Module, Integer> {
    //查询所有的资源列表
    public List<TreeModel> queryAllModules();

    //查询所有的资源数据
    public List<Module> queryModuleList();

    //通过层级与模块名查询资源对象
    Module queryModuleByGradeAndModuleName(@Param("grade") Integer grade, @Param("moduleName") String moduleName);

    //通过层级与url查询资源对象
    Module queryModuleByGradeAndUrl(@Param("grade") Integer grade, @Param("url") String url);

    //通过权限码查询资源对象
    Module queryModuleByOptValue(String optValue);

    //将id当做父Id查询资源记录
    Integer countModuleByParentId(Integer mId);
}