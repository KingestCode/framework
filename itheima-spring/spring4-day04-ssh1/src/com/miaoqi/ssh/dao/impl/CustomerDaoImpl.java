package com.miaoqi.ssh.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.miaoqi.ssh.dao.CustomerDao;
import com.miaoqi.ssh.domain.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

    @Override
    public void save(Customer customer) {
        System.out.println("CustomerDao执行了...");
        this.getHibernateTemplate().save(customer);
    }

}
