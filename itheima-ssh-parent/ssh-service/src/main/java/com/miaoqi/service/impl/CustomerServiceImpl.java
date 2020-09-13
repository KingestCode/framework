package com.miaoqi.service.impl;

import com.miaoqi.dao.CustomerDao;
import com.miaoqi.domain.Customer;
import com.miaoqi.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public Customer findOne(Integer custId) {
        return customerDao.findOne(custId);
    }

}
