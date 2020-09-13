package com.miaoqi.springmvc.po;

import java.util.List;

public class QueryVO {

    private Items items;

    private List<Items> itemsList;

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public List<Items> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Items> itemsList) {
        this.itemsList = itemsList;
    }

}
