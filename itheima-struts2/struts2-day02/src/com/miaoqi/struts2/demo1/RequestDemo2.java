package com.miaoqi.struts2.demo1;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

/**
 * 访问Servlet的API的方式二: 使用原生的方式
 * @author miaoqi
 *
 */
public class RequestDemo2 extends ActionSupport {

    @Override
    public String execute() throws Exception {
        // 接收数据
        // 直接获得request对象, 通过ServletActionContext
        HttpServletRequest request = ServletActionContext.getRequest();
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (String key : parameterMap.keySet()) {
            String[] value = parameterMap.get(key);
            System.out.println(key + ":" + Arrays.toString(value));
        }

        // 向域对象中保存数据
        request.setAttribute("reqName", "reqValue2");
        // 向session中保存数据
        request.getSession().setAttribute("sessionName", "sessionValue2");
        // 向application中保存数据
        request.getServletContext().setAttribute("applicationName", "applicationName2");
        return SUCCESS;
    }

}
