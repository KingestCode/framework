package com.miaoqi.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

// 默认加在IOC容器中的组件, 容器启动会调用无参构造器创建对象, 在进行初始化赋值操作
@Component
public class Boss {

    private Car car;

    // 构造器要用的参数, 也是从容器中获取
    public Boss(@Autowired Car car) {
        this.car = car;
        System.out.println("这是Boss的有参构造器...");
    }

    public Car getCar() {
        return car;
    }

    // @Autowired
    // 标注在方法上时, Spring容器创建对象时, 就会调用方法, 完成赋值
    // 方法使用的参数, 自定义类型的值会从IOC容器中获取
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
