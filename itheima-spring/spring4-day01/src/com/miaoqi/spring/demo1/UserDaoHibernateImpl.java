package com.miaoqi.spring.demo1;

public class UserDaoHibernateImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("UserDaoHibernateImpl执行了...");
    }

}
