package com.miaoqi.spring.demo1;

public class OrderDao {

    public void save() {
        System.out.println("保存订单");
    }

    public void update() {
        System.out.println("修改订单");
    }

    public String delete() {
        System.out.println("删除订单");
        return "苗骐";
    }

    public void find() {
        System.out.println("查询订单");
        int a = 1 / 0;
    }

}
