package com.pojo;

import java.io.Serializable;
import java.util.List;

public class Commodity implements Serializable {
    private Integer id;
    private String name;
    private List<CommodityOrder> commodityOrderList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CommodityOrder> getCommodityOrderList() {
        return commodityOrderList;
    }

    public void setCommodityOrderList(List<CommodityOrder> commodityOrderList) {
        this.commodityOrderList = commodityOrderList;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", commodityOrderList=" + commodityOrderList +
                '}';
    }
}
