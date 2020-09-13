package com.miaoqi.springmvc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception e) {
        ModelAndView mv = new ModelAndView();
        if (e instanceof MyException) {
            MyException my = (MyException) e;
            mv.addObject("errMsg", my.getMessage());
        } else {
            mv.addObject("errMsg", "系统异常");
        }
        mv.setViewName("error");
        return mv;
    }

}
