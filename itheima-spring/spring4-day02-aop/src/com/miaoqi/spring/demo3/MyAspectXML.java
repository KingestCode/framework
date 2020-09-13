package com.miaoqi.spring.demo3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切面类
 * @author miaoqi
 *
 */
public class MyAspectXML {

    /**
     * 前置通知
     * @param joinPoint
     */
    public void checkPri(JoinPoint joinPoint) {
        System.out.println("权限校验=================" + joinPoint);
    }

    /**
     * 后置通知
     */
    public void writeLog(Object result) {
        System.out.println("日志记录=================" + result);
    }

    /**
     * 环绕通知(性能监控)
     * @throws Throwable
     */
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前通知=================");
        Object object = joinPoint.proceed();
        System.out.println("环绕后通知=================");
        return object;
    }

    /**
     * 异常抛出
     */
    public void afterThrowing(Throwable ex) {
        System.out.println("异常抛出通知=================" + ex);
    }

    /**
     * 最终通知(相当于finally代码块中的内容)
     */
    public void after() {
        System.out.println("最终通知");
    }

}
