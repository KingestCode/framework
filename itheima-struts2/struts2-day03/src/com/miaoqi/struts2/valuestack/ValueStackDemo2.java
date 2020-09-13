package com.miaoqi.struts2.valuestack;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 获得ValueStack对象
 * @author miaoqi
 *
 */
public class ValueStackDemo2 extends ActionSupport {

    @Override
    public String execute() throws Exception {
        // 一种: 通过ActionContxt获得
        ValueStack valueStack1 = ActionContext.getContext().getValueStack();
        // 二种: 通过request对象获得
        //        ServletActionContext.getRequest().getAttribute("struts.valueStack");
        ValueStack valueStack2 = (ValueStack) ServletActionContext.getRequest()
                .getAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY);

        System.out.println(valueStack1 == valueStack2);
        return SUCCESS;
    }

}
