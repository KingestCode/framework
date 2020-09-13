package com.miaoqi.service;

import java.util.List;

import com.miaoqi.domain.Customer;

public interface CustomerService {
    public List<Customer> find();

    public void save(Customer customer);
}
