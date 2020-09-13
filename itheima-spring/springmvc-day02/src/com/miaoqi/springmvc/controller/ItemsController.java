package com.miaoqi.springmvc.controller;

import com.miaoqi.springmvc.exception.MyException;
import com.miaoqi.springmvc.po.Items;
import com.miaoqi.springmvc.po.QueryVO;
import com.miaoqi.springmvc.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    /**
     * 简单数据类型传递以及默认支持的参数类型
     *
     * @author miaoqi
     * @date 2019-09-29
     *
     * @param id
     * @param request
     * @param response
     * @param session
     * @param model
     *
     * @return
     */
    @RequestMapping(value = "itemEdit.action")
    public ModelAndView itemEdit(Integer id, HttpServletRequest request, HttpServletResponse response,
            HttpSession session, Model model) throws Exception {
        Items items = itemsService.findItemsById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("item", items);
        mv.setViewName("editItem");
        return mv;
    }

    //    // 绑定pojo
    //    @RequestMapping("updateitem.action")
    //    public ModelAndView updateitem(Items items) {
    //        return null;
    //    }

    /**
     * 绑定包装pojo
     *
     * @author miaoqi
     * @date 2019-09-29
     *
     * @param vo
     *
     * @return
     */
    @RequestMapping("item/queryitem.action")
    public ModelAndView queryitem(QueryVO vo) {
        return null;
    }

    /**
     * 绑定数组
     *
     * @author miaoqi
     * @date 2019-09-29
     *
     * @param ids
     *
     * @return
     */
    @RequestMapping("deleteByArray.action")
    public ModelAndView deleteByArray(Integer[] ids) {
        return null;
    }

    /**
     * 绑定List
     *
     * @author miaoqi
     * @date 2019-09-29
     *
     * @param vo
     *
     * @return
     */
    @RequestMapping("deleteByList.action")
    public ModelAndView deleteByList(QueryVO vo) {
        return null;
    }

    // controller 返回值

    /**
     * ModelAndView 既能带数据, 又能跳转视图
     * String 跳转视图, 通过Model带数据
     * void ajax请求
     *
     * @author miaoqi
     * @date 2019-09-29
     *
     * @param model
     *
     * @return
     */
    @RequestMapping(value = {"itemList.action", "itemList1.action", "itemList2.action"})
    public String itemList(Model model) throws Exception {
        List<Items> items = itemsService.findItemsAll();
        if (items == null) {
            throw new MyException("自己的异常");
        }
        model.addAttribute("itemList", items);
        return "itemList";
    }

    // Redirect重定向
    //    @RequestMapping("updateitem.action")
    //    public String updateitem(Items items) {
    //        return "redirect:itemList.action";
    //    }

    // forward转发
    //    @RequestMapping("updateitem.action")
    //    public String updateitem(Items items) {
    //        return "forward:itemList.action";
    //    }

    /**
     * 上传图片
     *
     * @author miaoqi
     * @date 2019-09-29
     *
     * @param items
     * @param pictureFile
     *
     * @return
     */
    @RequestMapping("updateitem.action")
    public String updateitem(Items items, MultipartFile pictureFile) {
        String originalFilename = pictureFile.getOriginalFilename();
        System.out.println(originalFilename);
        return "forward:itemList.action";
    }

    /**
     * 测试返回 json
     *
     * @author miaoqi
     * @date 2019-09-29
     *
     * @param item
     *
     * @return
     */
    @RequestMapping("toJson.action")
    public @ResponseBody
    Items toJson(@RequestBody Items item) {
        return item;
    }

    /**
     * 测试拦截器
     *
     * @author miaoqi
     * @date 2019-09-29
     *
     * @param
     *
     * @return
     */
    @RequestMapping("interceptor.action")
    @ResponseBody
    public String interceptor() {
        throw new RuntimeException();
        // return "test interceptor";
    }

}
