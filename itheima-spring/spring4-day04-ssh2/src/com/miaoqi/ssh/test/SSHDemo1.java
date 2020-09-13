package com.miaoqi.ssh.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.miaoqi.ssh.domain.Customer;
import com.miaoqi.ssh.service.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SSHDemo1 {

    @Resource(name = "customerService")
    private CustomerService customerService;

    @Test
    // 修改   
    public void demo1() {
        Customer customer = customerService.findById(1L);
        customer.setCust_name("苗骐");
        customerService.update(customer);
    }

    @Test
    // 删除   
    public void demo2() {
        Customer customer = customerService.findById(1L);
        customerService.delete(customer);
    }

    @Test
    // 查询所有
    public void demo3() {
        List<Customer> list = customerService.findAllByHQL();
        System.out.println(list.size());
    }

    @Test
    // 查询所有
    public void demo4() {
        List<Customer> list = customerService.findAllByQBC();
        System.out.println(list.size());
    }

}
