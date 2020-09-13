package com.miaoqi.config;

import com.miaoqi.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * bean的生命周期:
 *      bean创建---初始化---销毁的过程
 * 容器管理bean的生命周期:
 * 我们可以自定义初始化和销毁方法, 容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法
 *
 * 1. 指定init-method和destroy-method
 * 2. 实现InitializingBean接口(初始化), DisposableBean接口(销毁)
 * 3. 可以使用JSR250
 *      @PostConstructor: 在bean创建完成并且属性赋值完毕, 来执行初始化方法
 *      @PreDestroy: 在容器销毁bean之前通知我们进行清理工作
 * 4. BeanPostProcessor, bean的后置处理器, 在bean初始化前后进行一些处理工作
 *      postProcessBeforeInitialization: 初始化之前工作
 *      postProcessAfterInitialization: 初始化方法之后
 *
 */
@ComponentScan(value = "com.miaoqi.bean")
@Configuration
public class MainConfigOfLifeCycle {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }

}
