package com.smart.aop.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 生成.class
 */
public class CglibProxy implements MethodInterceptor {


    /**
     * 获取被代理的对象
     *
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */

    // 代码生成器
    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class<?> cls) {
        enhancer.setSuperclass(cls);
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("打开事务");
        //执行核心方法
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("提交事务!!!");
        return o1;
    }
}
