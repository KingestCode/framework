package com.miaoqi.struts2.demo3;

import java.util.List;

import com.miaoqi.struts2.domain.Product;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 复杂类型的数据封装: 封装到List集合中
 * @author miaoqi
 *
 */
public class ProductAction1 extends ActionSupport {

    private List<Product> products;

    @Override
    public String execute() throws Exception {
        for (Product product : products) {
            System.out.println(product);
        }
        return NONE;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
