package com.miaoqi.dao.impl;

import com.miaoqi.dao.CustomerDao;
import com.miaoqi.domain.Customer;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public void save(Customer customer) {
        System.out.println("CustomerDao中的save方法执行了...");
    }

}
