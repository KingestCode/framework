package com.miaoqi.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.miaoqi.springmvc.po.Items;
import com.miaoqi.springmvc.po.QueryVO;
import com.miaoqi.springmvc.service.ItemsService;

@Controller
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @RequestMapping(value = "itemList.action")
    public ModelAndView itemList() {
        List<Items> items = itemsService.findItemsAll();
        ModelAndView mv = new ModelAndView("itemList");
        mv.addObject("itemList", items);
        return mv;
    }

    // 简单数据类型传递以及默认支持的参数类型
    @RequestMapping(value = "itemEdit.action")
    public ModelAndView itemEdit(Integer id, HttpServletRequest request, HttpServletResponse response,
            HttpSession session, Model model) {
        Items items = itemsService.findItemsById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("item", items);
        mv.setViewName("editItem");
        return mv;
    }

    // 绑定pojo
    @RequestMapping("updateitem.action")
    public ModelAndView updateitem(Items items) {
        return null;
    }

    // 绑定包装pojo
    @RequestMapping("item/queryitem.action")
    public ModelAndView queryitem(QueryVO vo) {
        return null;
    }
}
