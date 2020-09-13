package com.miaoqi.spring.demo2;

public class CustomerDaoImpl implements CustomerDao {

    public void setUp() {
        System.out.println("CustomerDaoImpl初始化了...");
    }

    @Override
    public void save() {
        System.out.println("CustomerDaoImpl的save方法执行了...");
    }

    public void destory() {
        System.out.println("CustomerDaoImpl被销毁了...");
    }

}
