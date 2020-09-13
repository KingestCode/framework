package com.miaoqi.spring.demo1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 切面类: 注解方式
 * @author miaoqi
 *
 */
@Aspect
public class MyAspectAnno {

    // 前置通知
    @Before(value = "execution(* com.miaoqi.spring.demo1.OrderDao.save(..))")
    public void before() {
        System.out.println("前值增强==============");
    }

    // 后置通知
    @AfterReturning(value = "execution(* com.miaoqi.spring.demo1.OrderDao.delete(..))", returning = "result")
    public void afterReturning(Object result) {
        System.out.println("后置增强==============" + result);
    }

    // 环绕通知
    @Around(value = "execution(* com.miaoqi.spring.demo1.OrderDao.update(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前增强================");
        Object object = joinPoint.proceed();
        System.out.println("环绕后增强================");
        return object;
    }

    // 异常抛出
    @AfterThrowing(value = "execution(* com.miaoqi.spring.demo1.OrderDao.find(..))", throwing = "e")
    public void afterThrowing(Throwable e) {
        System.out.println("异常抛出增强================" + e);
    }

    // 最终通知
    @After(value = "MyAspectAnno.pointCut1()")
    public void after() {
        System.out.println("最终增强================");
    }

    // 切入点注解
    @Pointcut(value = "execution(* com.miaoqi.spring.demo1.OrderDao.find(..))")
    private void pointCut1() {

    }

}
