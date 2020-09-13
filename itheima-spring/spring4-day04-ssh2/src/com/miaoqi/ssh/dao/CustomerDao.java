package com.miaoqi.ssh.dao;

import java.util.List;

import com.miaoqi.ssh.domain.Customer;

public interface CustomerDao {

    public void save(Customer customer);

    void update(Customer customer);

    void delete(Customer customer);

    Customer findById(Long cust_id);

    List<Customer> findAllByHQL();

    List<Customer> findAllByQBC();

    List<Customer> findAllByNamed();

}
