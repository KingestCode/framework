package com.miaoqi.struts2.valuestack;

import com.miaoqi.struts2.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取值栈的数据
 * @author miaoqi
 *
 */
public class ValueStackDemo5 extends ActionSupport {

    @Override
    public String execute() throws Exception {
        // 向值栈中保存一个对象:
        User user = new User("aaa", "123");
        ActionContext.getContext().getValueStack().push(user);
        // 向值栈中保存一个集合:
        List<User> list = new ArrayList<>();
        list.add(new User("bbb", "123"));
        list.add(new User("ccc", "123"));
        list.add(new User("ddd", "123"));
        ActionContext.getContext().getValueStack().set("list", list);

        // 向context中存入数据:
        ServletActionContext.getRequest().setAttribute("name", "rmiaoqi");
        ServletActionContext.getRequest().getSession().setAttribute("name", "smiaoqi");
        ServletActionContext.getServletContext().setAttribute("name", "amiaoqi");
        return SUCCESS;
    }

}
