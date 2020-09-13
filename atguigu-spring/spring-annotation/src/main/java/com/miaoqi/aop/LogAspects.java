package com.miaoqi.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

// 告诉Spring当前类是一个切面类
@Aspect
public class LogAspects {

    // 抽取公共切入点表达式
    // 1. 本类引用 pointcut()
    // 2. 其他切面引用 com.miaoqi.aop.LogAspects.pointcut()
    @Pointcut("execution(public int com.miaoqi.aop.MathCalculator.*(..))")
    public void pointCut() {
    }

    // @Before在目标方法之前切入, 切入点表达式(指定在哪个方法切入)
    // @Before("public int com.miaoqi.aop.MathCalculator.*(..)")
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("前置通知, " + joinPoint.getSignature().getName() + "开始...参数列表是: {" + Arrays.asList(args) + "}");
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println("后置通知, " + joinPoint.getSignature().getName() + "结束...");
    }

    // 指定result接收返回值
    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(Object result) {
        System.out.println("正常返回通知, 除法正常返回...运行结果: {" + result + "}");
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(Exception exception) {
        System.out.println("异常返回通知, 除法异常返回...异常信息: {" + exception + "}");
    }
}
