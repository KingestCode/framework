package com.miaoqi.struts2.demo2;

import com.miaoqi.struts2.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 数据封装的方式三: 模型驱动, 采用模型驱动的方式
 * @author miaoqi
 *
 */
public class UserAction3 extends ActionSupport implements ModelDriven<User> {
    // 模型驱动使用的对象: 前提必须手动提供对象的实例
    private User user = new User(); // 手动实例化

    @Override
    public String execute() throws Exception {
        System.out.println(user);
        return NONE;
    }

    @Override
    public User getModel() {
        return user;
    }

}
