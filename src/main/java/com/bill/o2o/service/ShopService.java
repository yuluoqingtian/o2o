package com.bill.o2o.service;

import com.bill.o2o.dto.ShopReturnData;

import java.util.List;

public interface ShopService {
    List<ShopReturnData> getShopListByLocation(String latitude,String longitude);
    List<ShopReturnData> getShopListByLocationAndKeyWords(String latitude,String longitude,String keyWords);
    List<ShopReturnData> getShopListByKeyword(String keyword);
}
