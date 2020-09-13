package com.miaoqi.ssh.service.impl;

import java.util.List;

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

    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerDao.delete(customer);
    }

    @Override
    public Customer findById(Long cust_id) {
        return customerDao.findById(cust_id);
    }

    @Override
    public List<Customer> findAllByHQL() {
        return customerDao.findAllByHQL();
    }

    @Override
    public List<Customer> findAllByQBC() {
        return customerDao.findAllByQBC();
    }

}
