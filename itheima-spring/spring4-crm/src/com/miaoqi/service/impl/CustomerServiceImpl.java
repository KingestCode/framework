package com.miaoqi.service.impl;

import com.miaoqi.dao.CustomerDao;
import com.miaoqi.domain.Customer;
import com.miaoqi.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    @Override
    public void save(Customer customer) {
        System.out.println("CustomerServiceImpl方法执行了...");
        customerDao.save(customer);
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

}
