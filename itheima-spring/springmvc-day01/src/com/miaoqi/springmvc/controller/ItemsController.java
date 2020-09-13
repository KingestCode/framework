package com.miaoqi.springmvc.controller;

import com.miaoqi.springmvc.po.Items;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ItemsController {

    @RequestMapping(value = "itemList.action")
    public ModelAndView itemsList() {
        // 准备数据, 静态数据
        // 准备数据_静态数据
        List<Items> itemList = new ArrayList<>();

        //商品列表
        Items items_1 = new Items();
        items_1.setName("联想笔记本_3");
        items_1.setPrice(6000f);
        items_1.setDetail("ThinkPad T430 联想笔记本电脑！");

        Items items_2 = new Items();
        items_2.setName("苹果手机");
        items_2.setPrice(5000f);
        items_2.setDetail("iphone6苹果手机！");

        itemList.add(items_1);
        itemList.add(items_2);

        // 返回数据
        ModelAndView mv = new ModelAndView();
        // 带数据
        mv.addObject("itemList", itemList);
        // 跳转到jsp页面
        mv.setViewName("itemList");
        return mv;
    }

}
