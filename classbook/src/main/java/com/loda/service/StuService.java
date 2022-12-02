package com.loda.service;

import com.loda.dao.StuMapper;
import com.loda.entity.po.Stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author loda
 * @Date 2022/11/21 23:24
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Service
public class StuService {
    @Resource
    private StuMapper stuMapper;

    public Stu queryUserByUserName(String name) {
        return stuMapper.queryUserByUserName(name);
    }

    public List<String> queryUserNotCall() {
        return stuMapper.queryUserNotCall();
    }


    public Integer queryUserRound(String stuName) {
        return stuMapper.queryUserRound(stuName);
    }

    public Integer updateCall(Stu stu) {
        return stuMapper.updateCall(stu);
    }
}
