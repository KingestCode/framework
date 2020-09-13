package com.miaoqi.struts2.ognl;

import org.junit.Test;

import com.miaoqi.struts2.domain.User;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

public class OgnlDemo1 {

    // OGNL调用对象的方法
    @Test
    public void demo1() throws OgnlException {
        // 获得context
        OgnlContext context = new OgnlContext();
        // 获得根对象
        Object root = context.getRoot();
        // 执行表达式
        Object value = Ognl.getValue("'helloworld'.length()", context, root);
        System.out.println(value);
    }

    // 调用对象的静态方法
    @Test
    public void demo2() throws OgnlException {
        // 获得context
        OgnlContext context = new OgnlContext();
        // 获得根对象
        Object root = context.getRoot();
        // 执行表达式: @类名@方法名
        Object value = Ognl.getValue("@java.lang.Math@random()", context, root);
        System.out.println(value);
    }

    // 访问Root中的数据, 不需要加#
    @Test
    public void demo3() throws OgnlException {
        // 获得context
        OgnlContext context = new OgnlContext();
        // 执行表达式
        User user = new User("aaa", "123");
        context.setRoot(user);
        Object root = context.getRoot();
        // 获得根对象
        Object username = Ognl.getValue("username", context, root);
        Object password = Ognl.getValue("password", context, root);
        System.out.println(username + ":" + password);
    }

    // 访问context中的数据, 需要加#
    @Test
    public void demo4() throws OgnlException {
        // 获得context
        OgnlContext context = new OgnlContext();
        // 获得根对象
        Object root = context.getRoot();
        // 向context中存入数据
        context.put("name", "苗骐");
        // 执行表达式
        Object name = Ognl.getValue("#name", context, root);
        System.out.println(name);
    }

}
