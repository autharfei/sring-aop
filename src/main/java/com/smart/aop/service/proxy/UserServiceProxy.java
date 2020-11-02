package com.smart.aop.service.proxy;

import com.smart.aop.service.UserService;

/**
 * 代理
 * 代理对象必须持有被代理对象的引用
 * 一个代理类智能带一个接口
 */
public class UserServiceProxy implements UserService {
    private UserService userService;

    public UserServiceProxy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String login() {
        open();
        String login = userService.login();
        close();
        return login;
    }

    @Override
    public String list() {
        return null;
    }

    @Override
    public String register() {
        return null;
    }

    private void open() {
        System.out.println("打开数据库");
    }

    private void close() {
        System.out.println("关闭数据库");
    }


}
