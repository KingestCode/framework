package com.miaoqi.ssh.web.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.miaoqi.ssh.domain.Customer;
import com.miaoqi.ssh.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 *
 * @author miaoqi
 *
 */
@Controller("customerAction")
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    private Customer customer = new Customer();
    @Resource(name = "customerService")
    private CustomerService customerService;

    @Override
    public Customer getModel() {
        return customer;
    }

    @Action(value = "customer_save", results = {@Result(name = "success", location = "/login.jsp")})
    public String save() {
        customerService.save(customer);
        return SUCCESS;
    }

    @Action(value = "customer_update")
    public String update() {
        return NONE;
    }

}
