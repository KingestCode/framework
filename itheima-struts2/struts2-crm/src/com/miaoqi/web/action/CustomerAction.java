package com.miaoqi.web.action;

import com.miaoqi.domain.Customer;
import com.miaoqi.service.CustomerService;
import com.miaoqi.service.impl.CustomerServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

/**
 * 客户管理Action
 * @author miaoqi
 *
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    private Customer customer = new Customer();

    // 查询客户列表的方法
    public String find() {
        // 调用业务层
        CustomerService customerService = new CustomerServiceImpl();
        List<Customer> list = customerService.find();
        // 页面跳转
        //        ServletActionContext.getRequest().setAttribute("list", list);

        // 将查询到的list存入到值栈中
        ActionContext.getContext().getValueStack().set("list", list);
        return "findSuccess";
    }

    // 跳转到添加页面
    public String saveUI() {
        return "saveUI";
    }

    // 保存客户的方法
    public String save() {
        // 接收数据
        // 封装数据
        // 调用业务层
        CustomerService customerService = new CustomerServiceImpl();
        customerService.save(customer);
        // 页面跳转
        return "saveSuccess";
    }

    @Override
    public Customer getModel() {
        return customer;
    }

}
