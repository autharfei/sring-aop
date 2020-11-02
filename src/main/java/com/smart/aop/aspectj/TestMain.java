package com.smart.aop.aspectj;

import com.smart.aop.service.UserService;
import com.smart.aop.service.impl.UserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ioc
 * aop
 * 事务
 */
public class TestMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String register = userService.register();
        System.out.println(register);
        // 1 环绕前
        // 2 前置通知
        // 3 核心方法
        // 4 返回通知  4 异常通知
        // 5 最终通知
        // 6 环绕后
    }
}
