package com.smart.aop.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 对象中的方法
 * 事务代理类
 */
public class TransactionDynamicProxy implements InvocationHandler {
    // 被代理对象
    private Object target;

    /**
     * 获取被代理的对象
     * @param object
     * @return
     */
    public Object newInstance(Object object) {
        this.target = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(), this);
    }

    /**
     * Method
     * invoke()
     *
     * @param proxy  代理对象
     * @param method 核心方法
     * @param args   方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("1.开启事务");
        Object invoke = null;
        try {
            if (true){
                invoke = method.invoke(target, args);
            }
            System.out.println("提交事务!!!");
        } catch (Exception exception) {
            System.out.println("3.回滚事务!!!");
        }finally {

        }
        return invoke;
    }
}
