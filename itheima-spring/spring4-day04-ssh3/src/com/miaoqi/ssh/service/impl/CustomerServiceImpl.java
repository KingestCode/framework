package com.miaoqi.ssh.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miaoqi.ssh.dao.CustomerDao;
import com.miaoqi.ssh.domain.Customer;
import com.miaoqi.ssh.service.CustomerService;

@Transactional
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Resource(name = "customerDao")
    private CustomerDao customerDao;

    @Override
    public void save(Customer customer) {
        System.out.println("CustomerService的save方法执行了...");
        customerDao.save(customer);
    }

}
