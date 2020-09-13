package com.miaoqi.springmvc.service;

import java.util.List;

import com.miaoqi.springmvc.po.Items;

public interface ItemsService {
    public List<Items> findItemsAll() throws Exception;

    public Items findItemsById(Integer id) throws Exception;
}
