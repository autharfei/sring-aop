package com.smart.aop.cglib;

import com.smart.aop.dynamic.TransactionDynamicProxy;
import com.smart.aop.service.ShopService;
import com.smart.aop.service.UserService;
import com.smart.aop.service.impl.ShopServiceImpl;
import com.smart.aop.service.impl.UserServiceImpl;

public class TestCglibProxt {

    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        UserServiceImpl userService = (UserServiceImpl) proxy.getProxy(UserServiceImpl.class);
        String login = userService.login();
    }
}
