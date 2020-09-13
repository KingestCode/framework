package com.miaoqi.spring.demo2;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * Cglib动态方法
 * @author miaoqi
 *
 */
public class CglibProxy implements MethodInterceptor {

    private CustomerDao customerDao;

    public CglibProxy(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    /**
     * 使用Cglib产生代理的方法
     */
    public CustomerDao createProxy() {
        // 1. 创建Cglib核心类对象
        Enhancer enhancer = new Enhancer();
        // 2. 设置父类
        enhancer.setSuperclass(customerDao.getClass());
        // 3. 设置回调(类似于InvocationHandler对象)
        enhancer.setCallback(this);
        // 4. 创建代理对象
        return (CustomerDao) enhancer.create();
    }

    // proxy: 动态生成的代理对象(CustomerDaoProxy)
    // method: 被代理的方法(CustomerDao)
    // args: 参数
    // methodProxy: 动态生成的代理方法
    // 
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        // 判断方法是否为save
        if ("save".equals(method.getName())) {
            System.out.println("权限校验");
            return methodProxy.invokeSuper(proxy, args);
        }
        return methodProxy.invokeSuper(proxy, args);
    }

}
