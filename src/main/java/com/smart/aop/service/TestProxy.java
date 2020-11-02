package com.smart.aop.service;

import com.smart.aop.service.impl.UserServiceImpl;
import com.smart.aop.service.proxy.UserServiceProxy;

/**
 * 在被代理对象不改变的调用方式前对方法增强
 */
public class TestProxy {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        UserServiceProxy proxy = new UserServiceProxy(userService);
        proxy.login();
    }
}
