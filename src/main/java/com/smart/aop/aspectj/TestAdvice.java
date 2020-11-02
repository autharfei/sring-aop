package com.smart.aop.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import org.springframework.stereotype.Component;

/**
 * 定义切面
 * (定义代理类)
 */
@Component
@Aspect
public class    TestAdvice {
    /**
     * 切入点
     * value
     * 表示切入点表达式(execution)
     * 或者注解@annotation()
     * execution格式
     * 方法的可见性 * 返回类型 * 表示返回任意类型 String Void 方法的包名+类名 () .. 表示匹配任意参数
     * 通配符
     * * 匹配任意数量的字符
     * .. 可以匹配任意参数
     * 操作符
     * &&
     * ||
     * !
     */
    @Pointcut(value = "execution(public * com.smart.aop.service.UserService.register(..)) ")
    public void point() {

    }

    /**
     * 定义通知
     * 前置通知(Before)
     * 返回通知(After-returning)
     * 异常通知(after-throwing)
     * 环绕通知(Around)
     * 最终退职(After)
     */

    @Before(value = "point()")
    public void before() {
        System.out.println("前置通知");
    }

    // 不带任何返回值
    @AfterReturning(value = "point()")
    public void afterReturning() {
        System.out.println("返回通知");
    }

    //控制层  全局异常处理
    @AfterThrowing(value = "point()", throwing = "ex")
    public void afterThrowing(Exception ex) {
        System.out.println(ex.getMessage());
    }

    @Around("point()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
//        method.invoke()
        System.out.println("环绕前");
        Object proceed = pjp.proceed();
        System.out.println("环绕后");
        return proceed;
    }


    @After("point()")
    public void after() {
        System.out.println("最终通知");
    }


}
