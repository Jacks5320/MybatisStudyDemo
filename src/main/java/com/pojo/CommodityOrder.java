package com.pojo;

import java.util.List;

public class CommodityOrder {
    private Integer id;
    private String name;
    private List<Commodity> commodityList;

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

    public List<Commodity> getCommodityList() {
        return commodityList;
    }

    public void setCommodityList(List<Commodity> commodityList) {
        this.commodityList = commodityList;
    }

    @Override
    public String toString() {
        return "CommodityOrder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", commodityList=" + commodityList +
                '}';
    }
}
