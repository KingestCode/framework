package com.miaoqi.ssh.web.action;

import com.miaoqi.ssh.domain.Customer;
import com.miaoqi.ssh.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    private Customer customer = new Customer();

    public String save() {
        System.out.println("Action的save方法执行了...");
        customerService.save(customer);
        return NONE;
    }

    @Override
    public Customer getModel() {
        return customer;
    }

    private CustomerService customerService;

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

}
