package com.loda;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author loda
 * @Date 2022/11/21 23:10
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.loda.dao")
public class Starter {
    public static void main(String[] args) {

        SpringApplication.run(Starter.class);
    }
}
