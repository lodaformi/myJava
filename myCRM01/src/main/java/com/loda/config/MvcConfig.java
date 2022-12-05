package com.loda.config;

import com.loda.exceptions.NoLoginException;
import com.loda.interceptors.NoLoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author loda
 * @Date 2022/11/22 16:30
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    @Bean
    public NoLoginInterceptor noLoginInterceptor() {
        return new NoLoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(noLoginInterceptor()).
                //拦截所有
                addPathPatterns("/**").
                //放行特定资源和动作
                excludePathPatterns("/index", //登陆页面
                        "/user/login",  //登陆动作
                        "/css/**",      //静态资源
                        "/images/**",
                        "/js/**",
                        "/lib/**");
    }
}
