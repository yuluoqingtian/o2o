package com.bill.o2o.service.impl;

import com.bill.o2o.dao.ShopDao;
import com.bill.o2o.dto.ShopReturnData;
import com.bill.o2o.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao shopDao;

    @Override
    public List<ShopReturnData> getShopListByLocation(String latitude, String longitude) {
        return shopDao.queryShopByLocation(latitude,longitude);
    }

    @Override
    public List<ShopReturnData> getShopListByLocationAndKeyWords(String latitude, String longitude, String keyWords) {
        return shopDao.queryShopByLocationAndKeyWords(latitude,longitude,keyWords);
    }

    @Override
    public List<ShopReturnData> getShopListByKeyword(String keyword) {
        return shopDao.qureyShopByKeyword(keyword);
    }
}
