package com.miaoqi.struts2.demo2;

import com.miaoqi.struts2.domain.User;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 数据封装方式二: 属性驱动, 页面中提供表达式的方式
 * @author miaoqi
 *
 */
public class UserAction2 extends ActionSupport {

    // 提供一个对象
    private User user;
    // 提供user的set和get方法: 一定要提供get方法

    @Override
    public String execute() throws Exception {
        System.out.println(user);
        return NONE;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
