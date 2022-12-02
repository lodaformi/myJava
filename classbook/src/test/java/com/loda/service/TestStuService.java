package com.loda.service;

import com.loda.Starter;
import com.loda.service.StuService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author loda
 * @Date 2022/11/21 23:26
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Starter.class})
public class TestStuService {
    @Autowired
    private StuService stuService;

    @Before
    public void before() {
        System.out.println("before...");
    }

    @After
    public void after() {
        System.out.println("after...");
    }

    @Test
    public void test() {
        System.out.println(stuService.queryUserByUserName("来宪龙"));
    }

    @Test
    public void test02() {
        List<String> list = stuService.queryUserNotCall();
        System.out.println(list);
        System.out.println(list.size());
    }
}
