package com.miaoqi.springmvc.dao;

import java.util.List;

import com.miaoqi.springmvc.po.Items;

public interface ItemsDao {

    public List<Items> findItemsAll() throws Exception;

    public Items findItemsById(Integer id) throws Exception;

}
