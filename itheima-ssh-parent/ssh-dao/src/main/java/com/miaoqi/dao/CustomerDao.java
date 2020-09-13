package com.miaoqi.dao;

import com.miaoqi.domain.Customer;

public interface CustomerDao {

    Customer findOne(Integer custId);

}
