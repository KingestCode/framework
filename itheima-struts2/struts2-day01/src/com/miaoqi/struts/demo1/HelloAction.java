package com.miaoqi.struts.demo1;

/**
 * Struts2的入门的Action类
 * @author miaoqi
 *
 */

/**
 *
 * 常量加载顺序
 * default.properties   org.apache.struts2
 * struts-default.xml   jar包下
 * struts-plugin.xml
 * struts.xml           自己写的配置文件
 * struts.properties
 * web.xml
 *
 */
public class HelloAction {

    /**
     * 提供一个方法:
     *  方法签名是固定的, 公有的返回值是String类型方法名execute, 方法中不能传递参数
     */
    public String execute() {
        System.out.println("HelloAction执行了...");
        return "success";
    }

}
