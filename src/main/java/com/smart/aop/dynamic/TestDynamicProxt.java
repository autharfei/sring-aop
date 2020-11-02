package com.smart.aop.dynamic;

import com.smart.aop.service.ShopService;
import com.smart.aop.service.UserService;
import com.smart.aop.service.impl.ShopServiceImpl;
import com.smart.aop.service.impl.UserServiceImpl;


public class TestDynamicProxt {

    public static void main(String[] args) {
        //事务代理类
        TransactionDynamicProxy proxy = new TransactionDynamicProxy();
        UserService userService = (UserService) proxy.newInstance(new UserServiceImpl());
        userService.login();
        ShopService shopService = (ShopService) proxy.newInstance(new ShopServiceImpl());
        shopService.add();
    }
}
