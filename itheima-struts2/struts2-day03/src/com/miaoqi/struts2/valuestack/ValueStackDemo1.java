package com.miaoqi.struts2.valuestack;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 演示ValueStack的内部结构
 * @author miaoqi
 *
 */
public class ValueStackDemo1 extends ActionSupport {

    @Override
    public String execute() throws Exception {
        // 获得值栈
        ValueStack valueStack = ActionContext.getContext().getValueStack();
        return SUCCESS;
    }

}
