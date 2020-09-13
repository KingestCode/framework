package com.miaoqi.config;

import com.miaoqi.bean.Color;
import com.miaoqi.bean.ColorFactoryBean;
import com.miaoqi.bean.Person;
import com.miaoqi.bean.Red;
import com.miaoqi.condition.MacCondition;
import com.miaoqi.condition.MyImportBeanDefinitionRegistrar;
import com.miaoqi.condition.MyImportSelector;
import com.miaoqi.condition.WindowsCondition;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.*;

@Configuration
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfigOfIOC {

    @Bean
    public FactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }

    /**
     * 默认是单实例的
     *
     * ConfigurableBeanFactory#SCOPE_PROTOTYPE
     * ConfigurableBeanFactory#SCOPE_SINGLETON
     * org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
     * org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
     *
     * prototype: 多实例, ioc容器启动并不会去调用方法创建对象, 每次获取的时候才会调用方法创建对象
     * singleton: 单实例(默认值), ioc容器启动会调用方法创建对象放到ioc容器中
     *              以后每次请求就是直接从容器中获取
     * request: 同一次请求
     * session: 同一个session创建一个实例
     *
     *
     * 懒加载:
     *      单实例bean, 默认在容器启动的时候创建对象
     *      懒加载: 容器启动时不创建对象, 第一次使用(获取)Bean创建对象, 并初始化
     *
     *
     */
    // @Scope("prototype")
    @Lazy
    @Bean("person")
    public Person person() {
        System.out.println("给容器中添加Person...");
        return new Person("李四", 25);
    }

    /**
     * @Conditional({Condition}) 按照一定条件进行判断, 满足条件给容器中注册bean
     *
     * 如果操作系统是Windows, 给容器中注册("bill")
     *
     * 如果是mac, 给容器中注册("jobs")
     */
    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person01() {
        return new Person("Bill Gates", 62);
    }

    @Conditional({MacCondition.class})
    @Bean("jobs")
    public Person person02() {
        return new Person("linus", 48);
    }


}
