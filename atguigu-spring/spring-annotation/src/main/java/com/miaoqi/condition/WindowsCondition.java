package com.miaoqi.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

// 判断系统是不是mac
public class WindowsCondition implements Condition {
    /**
     * ConditionContext: 判断条件能使用的上下文
     * AnnotatedTypeMetadata: 注释信息
     */
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 是否mac系统
        // 1. 获取到IOC容器使用的bean工厂
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        // 2. 获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        // 3. 获取环境信息
        Environment environment = context.getEnvironment();
        // 4. 获取bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();

        if (environment.getProperty("os.name").contains("Windows")) {
            return true;
        }
        return false;
    }
}
