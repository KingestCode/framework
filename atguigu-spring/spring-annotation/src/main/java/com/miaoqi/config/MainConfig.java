package com.miaoqi.config;

import com.miaoqi.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// 配置类 == 配置文件
@Configuration // 告诉Spring这是一个配置类
@ComponentScan(value = "com.miaoqi", includeFilters = {
        // @Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class}),
        // @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = BookDao.class),
        @Filter(type = FilterType.CUSTOM, classes = MyTypeFilter.class)
}, useDefaultFilters = false) // 包扫描
// @ComponentScan   value: 指定要扫描的包
// excludeFilters = Filter[] 按照指定规则排除哪些组件
// includeFilters = Filter[] 按照指定规则只包含哪些组件
// FilterType.ANNOTATION: 按照注解
// FilterType.ASSIGNABLE_TYPE: 按照给定的类型
// FilterType.ASPECTJ: 使用ASPECTJ表达式
// FilterType.REGEX: 使用正则表达式
// FilterType.CUSTOM: 使用自定义规则, 必须是TypeFilter的实现类
public class MainConfig {

    // 给容器中注册一个bean; 类型为返回值类型, id默认是方法名
    @Bean("person")
    public Person person() {
        return new Person("list", 20);
    }

}
