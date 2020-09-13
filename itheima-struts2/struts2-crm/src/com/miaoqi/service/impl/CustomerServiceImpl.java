package com.miaoqi.service.impl;

import java.util.List;

import com.miaoqi.dao.CustomerDao;
import com.miaoqi.dao.impl.CustomerDaoImpl;
import com.miaoqi.domain.Customer;
import com.miaoqi.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {


    @Override
    public List<Customer> find() {
        // 调用Dao
        CustomerDao customerDao = new CustomerDaoImpl();
        return customerDao.find();
    }

    // 业务层保存客户
    @Override
    public void save(Customer customer) {
        // 调用Dao
        CustomerDao customerDao = new CustomerDaoImpl();
        customerDao.save(customer);
    }

}
