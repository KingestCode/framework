package com.miaoqi.web.action;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.miaoqi.domain.Customer;
import com.miaoqi.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
    // 模型驱动使用的对象
    private Customer customer = new Customer();

    @Override
    public Customer getModel() {
        return customer;
    }

    /**
     * 跳转到添加页面 
     */
    public String saveUI() {
        return "saveUI";
    }

    /**
     * 编写保存客户的方法: save
     */
    public String save() {
        // 创建一个工厂类
        ServletContext sc = ServletActionContext.getServletContext();
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(sc);
        //        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerService customerService = context.getBean(CustomerService.class);
        System.out.println("CustomerAction中的save方法执行了...");
        customerService.save(customer);
        return NONE;
    }

}
