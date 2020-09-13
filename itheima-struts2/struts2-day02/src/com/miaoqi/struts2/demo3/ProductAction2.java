package com.miaoqi.struts2.demo3;

import java.util.Map;

import com.miaoqi.struts2.domain.Product;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 复杂类型的数据封装: 封装到Map集合中
 * @author miaoqi
 *
 */
public class ProductAction2 extends ActionSupport {

    private Map<String, Product> products;

    @Override
    public String execute() throws Exception {
        for (String key : products.keySet()) {
            Product val = products.get(key);
            System.out.println(key + ":" + val);
        }
        return NONE;
    }

    public Map<String, Product> getProducts() {
        return products;
    }

    public void setProducts(Map<String, Product> products) {
        this.products = products;
    }
}
