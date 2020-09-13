package com.miaoqi.ssh.dao.impl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.miaoqi.ssh.dao.CustomerDao;
import com.miaoqi.ssh.domain.Customer;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {

    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    @Override
    public void save(Customer customer) {
        System.out.println("CustomerDao的save方法执行了...");
        this.hibernateTemplate.save(customer);
    }

}
