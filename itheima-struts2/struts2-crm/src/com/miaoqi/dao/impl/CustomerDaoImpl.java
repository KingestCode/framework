package com.miaoqi.dao.impl;

import com.miaoqi.dao.CustomerDao;
import com.miaoqi.domain.Customer;
import com.miaoqi.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public List<Customer> find() {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        List<Customer> list = session.createQuery("FROM Customer").list();
        transaction.commit();
        return list;
    }

    // 保存客户的方法
    @Override
    public void save(Customer customer) {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(customer);

        transaction.commit();
    }

}
