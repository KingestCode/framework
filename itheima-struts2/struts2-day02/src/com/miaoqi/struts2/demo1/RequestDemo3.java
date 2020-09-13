package com.miaoqi.struts2.demo1;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 访问Servlet的API的方式三: 接口注入方式
 * @author miaoqi
 *
 */
public class RequestDemo3 extends ActionSupport implements ServletRequestAware, ServletContextAware {

    private HttpServletRequest request;
    private ServletContext servletContext;

    @Override
    public String execute() throws Exception {
        // 接收数据
        // 通过接口注入的方式获得request对象
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (String key : parameterMap.keySet()) {
            String[] value = parameterMap.get(key);
            System.out.println(key + ":" + Arrays.toString(value));
        }

        // 向域对象中保存数据
        request.setAttribute("reqName", "reqValue3");
        // 向session中保存数据
        request.getSession().setAttribute("sessionName", "sessionValue3");
        // 向application中保存数据
        servletContext.setAttribute("applicationName", "applicationName3");
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

}
