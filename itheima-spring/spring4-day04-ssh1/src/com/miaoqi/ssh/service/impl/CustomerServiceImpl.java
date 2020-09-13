package com.miaoqi.ssh.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.miaoqi.ssh.dao.CustomerDao;
import com.miaoqi.ssh.domain.Customer;
import com.miaoqi.ssh.service.CustomerService;

/**
 * 客户管理业务层实现类
 * @author miaoqi
 *
 */
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    @Override
    public void save(Customer customer) {
        System.out.println("CustomerService的save方法执行了...");
        customerDao.save(customer);
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

}
