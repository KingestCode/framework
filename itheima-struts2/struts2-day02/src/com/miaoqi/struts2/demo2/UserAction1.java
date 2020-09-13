package com.miaoqi.struts2.demo2;

import java.util.Date;

import com.miaoqi.struts2.domain.User;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 数据封装方式一: 属性驱动, 提供属性的set方法的方式
 * @author miaoqi
 *
 */
public class UserAction1 extends ActionSupport {
    private String username;
    private String password;
    private Integer age;
    private Date birthday;
    private Double salary;

    @Override
    public String execute() throws Exception {
        // 接收数据
        System.out.println(username);
        System.out.println(password);
        System.out.println(age);
        System.out.println(birthday);
        System.out.println(salary);
        // 封装数据
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAge(age);
        user.setBirthday(birthday);
        user.setSalary(salary);
        return NONE;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

}
