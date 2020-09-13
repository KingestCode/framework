package com.miaoqi.dao;

import java.util.List;

import com.miaoqi.domain.Customer;

public interface CustomerDao {

    List<Customer> find();

    void save(Customer customer);

}
