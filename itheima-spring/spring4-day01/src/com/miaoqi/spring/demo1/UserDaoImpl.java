package com.miaoqi.spring.demo1;

/**
 * 用户管理业务层实现类
 * @author miaoqi
 *
 */
public class UserDaoImpl implements UserDao {

    private String name;

    @Override
    public void save() {
        System.out.println("UserServiceImpl执行了..." + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
