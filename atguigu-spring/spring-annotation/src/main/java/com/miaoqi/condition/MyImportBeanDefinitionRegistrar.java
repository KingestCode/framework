package com.miaoqi.condition;

import com.miaoqi.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * AnnotationMetadata: 当前类的注解信息
     * BeanDefinitionRegistry: bean定义的注册类
     *      把所有要添加到容器中的bean, 调用
     *      BeanDefinitionRegistry.registerBeanDefinition方法手动注册
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean red = registry.containsBeanDefinition("com.miaoqi.bean.Red");
        boolean blue = registry.containsBeanDefinition("com.miaoqi.bean.Blue");
        if (red && blue) {
            // 指定bean定义信息, (Bean的类型..)
            RootBeanDefinition bean = new RootBeanDefinition(RainBow.class);
            // 注册一个Bean, 指定bean名称
            registry.registerBeanDefinition("rainBow", bean);
        }
    }
}
