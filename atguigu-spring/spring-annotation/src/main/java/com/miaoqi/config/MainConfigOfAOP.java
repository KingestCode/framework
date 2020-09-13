package com.miaoqi.config;

import com.miaoqi.aop.LogAspects;
import com.miaoqi.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP: 面向切面编程
 *      原理是动态代理
 *
 * 1. 导入AOP模块, SpringAOP, (spring-aspects)
 * 2. 定义一个业务逻辑类(MathCalculator): 在业务逻辑运行的时候进行日志打印(方法之前, 方法之后, 方法出现异常)
 * 3. 定义一个日志切面类(LogAspects): 切面类里面的方法需要动态感知MathCalculator.div运行到哪里然后执行
 *       通知方法:
 *          前置通知(@Before): logStart: 在目标方法(div)运行之前运行
 *          后置通知(@After): logEnd: 在目标方法(div)运行之后运行(无论方法正常结束还是异常结束)
 *          返回通知(@AfterReturning): logReturn: 在目标方法(div)正常返回之后运行
 *          异常通知(@AfterThrowing): logException: 在目标方法(div)出现异常以后运行
 *          环绕通知(@Around): 动态代理: 手动推进目标方法运行(joinPoint.proceed)
 * 4. 给切面类的目标方法标注何时何地运行
 * 5. 将切面类和业务逻辑类(目标方法所在类)都加入容器中
 * 6. 告诉Spring哪个类是切面类(给切面类上加一个注解@Aspect)
 * 7. 开启注解版AOP
 *
 * @author miaoqi
 * @date 2018/8/15
 */
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {

    // 业务逻辑类加入到容器中
    @Bean
    public MathCalculator mathCalculator() {
        return new MathCalculator();
    }

    // 切面类加入到容器中
    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }
}
