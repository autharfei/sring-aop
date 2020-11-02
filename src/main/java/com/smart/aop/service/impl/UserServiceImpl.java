package com.smart.aop.service.impl;

import com.smart.aop.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 被代理
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public String login() {
        System.out.println("2.去数据库查询用户表");
        return "核心方法";
    }

    @Override
    public String list() {
        return null;
    }

    @Override
    public String register() {
        System.out.println("核心方法");
        // 不能处理异常
//        int i = 1 / 0;
        return "register";
    }
}
