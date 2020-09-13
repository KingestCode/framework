package com.miaoqi.spring.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    // 注入Dao, 默认按照类型注入, 如果类型有多个, 按照属性名去注入, 如果制定了Qulifier则按照Qulifier查找
    @Autowired
    private UserDao userDao;

    @Override
    public void save() {
        System.out.println("userService的save方法执行了...");
        userDao.save();
    }
}
