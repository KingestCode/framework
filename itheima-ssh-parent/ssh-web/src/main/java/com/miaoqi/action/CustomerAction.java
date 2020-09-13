package com.miaoqi.action;

import org.apache.struts2.ServletActionContext;

import com.miaoqi.domain.Customer;
import com.miaoqi.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport {

    private CustomerService customerService;

    public CustomerService getCustomerService() {
        return customerService;
    }

    private Integer custId;

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String findByCustId() throws Exception {
        // 调用service层查询
        Customer customer = customerService.findOne(custId);
        ServletActionContext.getRequest().setAttribute("customer", customer);
        return SUCCESS;
    }

}
