package com.miaoqi.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miaoqi.springmvc.dao.ItemsDao;
import com.miaoqi.springmvc.po.Items;
import com.miaoqi.springmvc.service.ItemsService;

@Service
@Transactional
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsDao itemsDao;

    @Override
    public List<Items> findItemsAll() throws Exception {
        //        int i = 1 / 0;
        return itemsDao.findItemsAll();
    }

    @Override
    public Items findItemsById(Integer id) throws Exception {
        return itemsDao.findItemsById(id);
    }

}
