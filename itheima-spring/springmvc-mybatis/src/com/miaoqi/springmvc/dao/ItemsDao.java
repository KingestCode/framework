package com.miaoqi.springmvc.dao;

import java.util.List;

import com.miaoqi.springmvc.po.Items;

public interface ItemsDao {

    public List<Items> findItemsAll();

    public Items findItemsById(Integer id);

}
