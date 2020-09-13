package com.miaoqi.struts2.demo1;

import java.util.Arrays;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 访问Servlet的API方式一: 完全解耦合方式
 * @author miaoqi
 *
 */
public class RequestDemo1 extends ActionSupport {

    @Override
    public String execute() throws Exception {
        // 一. 接收参数:
        // 利用Struts2中的对象ActionContext
        ActionContext context = ActionContext.getContext();
        // 调用ActionContext中的方法
        // 类似于Map<String, String[]> = request.getParameterMap
        Map<String, Object> parameters = context.getParameters();
        for (String key : parameters.keySet()) {
            String[] values = (String[]) parameters.get(key);
            System.out.println(key + ":" + Arrays.toString(values));
        }

        // 二. 向域对象中存入数据
        context.put("reqName", "reqValue1"); // 相当于request.setAttribute();
        context.getSession().put("sessionName", "sessionValue1"); // 相当于session.setAttribute();
        context.getApplication().put("applicationName", "applicationValue1"); // 相当于servletContext.setAttribute();
        return SUCCESS;
    }
}
