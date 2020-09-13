package com.miaoqi.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.miaoqi.dao.CustomerDao;
import com.miaoqi.domain.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

    @Override
    public Customer findOne(Integer custId) {
        return this.getHibernateTemplate().get(Customer.class, custId);
    }

}
