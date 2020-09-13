package com.miaoqi.struts2.valuestack;

import com.miaoqi.struts2.domain.User;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 操作ValueStack:
 * 方式一: 利用Action本身在值栈中的特性, 会默认将Action实例压入栈顶
 * @author miaoqi
 *
 */
public class ValueStackDemo3 extends ActionSupport {

    private User user;

    @Override
    public String execute() throws Exception {
        // 向ValueStack中存值
        user = new User("苗骐", "222");
        return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
