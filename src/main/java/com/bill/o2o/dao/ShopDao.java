package com.bill.o2o.dao;

import com.bill.o2o.dto.ShopReturnData;
import com.bill.o2o.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopDao {
    List<ShopReturnData> queryShopByLocation(@Param("latitude")String latitude,
                                             @Param("longitude")String longitude);


    List<ShopReturnData> queryShopByLocationAndKeyWords (@Param("latitude")String latitude,
                                                         @Param("longitude")String longitude,
                                                         @Param("keyWords")String keyWords);

    List<ShopReturnData> qureyShopByKeyword(@Param("keyword")String keyword);
}
