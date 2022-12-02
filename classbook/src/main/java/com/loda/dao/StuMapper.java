package com.loda.dao;

import com.loda.entity.po.Stu;

import java.util.List;

/**
 * @Author loda
 * @Date 2022/11/21 23:17
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public interface StuMapper {
    public Stu queryUserByUserName(String stuName);
    
    List<String> queryUserNotCall();

    Integer queryUserRound(String stuName);

    Integer updateCall(Stu stu);

}
