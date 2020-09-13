package com.miaoqi.bean;

import org.springframework.beans.factory.FactoryBean;

// 创建一个Spring提供的工厂Bean, 用于创建其他Bean
public class ColorFactoryBean implements FactoryBean<Color> {
    // 返回一个Color对象, 这个对象会添加到容器中
    @Override
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean...");
        return new Color();
    }

    // bean类型
    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    // 是否单例
    @Override
    public boolean isSingleton() {
        return true;
    }
}
