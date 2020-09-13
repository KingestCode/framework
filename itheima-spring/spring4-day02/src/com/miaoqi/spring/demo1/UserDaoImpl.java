package com.miaoqi.spring.demo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

//@Component(value = "userDao") // 相当于<bean id="userDao" class="com.miaoqi.spring.demo1.UserDaoImpl">
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Value("miaoqi")
    private String name;

    @Override
    public void save() {
        System.out.println("DAO中保存用户的方法执行了...");
    }

    public String getName() {
        return name;
    }

    //    @Value("苗骐")
    //    public void setName(String name) {
    //        this.name = name;
    //    }

}
