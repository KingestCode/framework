package com.miaoqi.springmvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * preHandle按拦截器定义顺序调用
 *
 * postHandler按拦截器定义逆序调用
 *
 * afterCompletion按拦截器定义逆序调用
 *
 *
 *
 * postHandler在拦截器链内所有拦截器返回成功并且目标方法没有抛出异常才调用, 在视图渲染之前
 *
 * afterCompletion只要preHandle返回true就调用, 在渲染视图之后
 *
 * pre1 -> pre2 -> targetHandler -> (exception -> exceptionHandler -> after2 -> after1) (post2 -> post1 -> after2 -> after1)
 *
 * filter -> targetHandler -> (exception -> exceptionHandler ->) filter
 *
 * @author miaoqi
 * @date 2019/9/29
 */
public class MyInterceptor1 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
        System.out.println("请求前拦截1");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        System.out.println("请求后拦截1");
    }

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        System.out.println("渲染视图后拦截1");
    }
}
