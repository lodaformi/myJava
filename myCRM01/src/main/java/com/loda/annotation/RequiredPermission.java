package com.loda.annotation;

import java.lang.annotation.*;

/**
 * @Author loda
 * @Date 2022/11/29 17:59
 * @Description 定义方法需要的对应资源的权限码
 * @Version 1.0
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequiredPermission {
    //权限码
    String code() default "";
}
