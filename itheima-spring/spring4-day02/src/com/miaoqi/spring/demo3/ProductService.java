package com.miaoqi.spring.demo3;

import javax.annotation.Resource;

public class ProductService {

    @Resource(name = "productDao")
    private ProductDao productDao;
    @Resource(name = "orderDao")
    private OrderDao orderDao;

    public void save() {
        System.out.println("ProductService的save方法执行了...");
        productDao.save();
        orderDao.save();
    }

    //    public ProductDao getProductDao() {
    //        return productDao;
    //    }
    //
    //    public void setProductDao(ProductDao productDao) {
    //        this.productDao = productDao;
    //    }
    //
    //    public OrderDao getOrderDao() {
    //        return orderDao;
    //    }
    //
    //    public void setOrderDao(OrderDao orderDao) {
    //        this.orderDao = orderDao;
    //    }

}
