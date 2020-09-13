package com.miaoqi.ssh.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.miaoqi.ssh.dao.CustomerDao;
import com.miaoqi.ssh.domain.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

    @Override
    public void save(Customer customer) {
        System.out.println("CustomerDao执行了...");
        this.getHibernateTemplate().save(customer);
    }

    @Override
    public void update(Customer customer) {
        this.getHibernateTemplate().update(customer);
    }

    @Override
    public void delete(Customer customer) {
        this.getHibernateTemplate().delete(customer);
    }

    @Override
    public Customer findById(Long cust_id) {
        return this.getHibernateTemplate().get(Customer.class, cust_id);
    }

    @Override
    public List<Customer> findAllByHQL() {
        String hql = "FROM Customer";
        List<Customer> list = (List<Customer>) this.getHibernateTemplate().find(hql);
        return list;
    }

    @Override
    public List<Customer> findAllByQBC() {
        DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
        List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria);
        return list;
    }

    @Override
    public List<Customer> findAllByNamed() {
        return (List<Customer>) this.getHibernateTemplate().findByNamedQuery("queryAll");
    }

}
