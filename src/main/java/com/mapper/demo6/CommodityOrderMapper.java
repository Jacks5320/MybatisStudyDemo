package com.mapper.demo6;

import com.pojo.Commodity;
import com.pojo.CommodityOrder;

import java.util.List;

public interface CommodityOrderMapper {
    List<CommodityOrder> findAll();
}
