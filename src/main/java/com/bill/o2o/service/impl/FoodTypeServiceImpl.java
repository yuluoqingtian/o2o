package com.bill.o2o.service.impl;

import com.bill.o2o.dao.FoodTypeDao;
import com.bill.o2o.entity.FoodType;
import com.bill.o2o.service.FoodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodTypeServiceImpl implements FoodTypeService {
    @Autowired
    private FoodTypeDao foodTypeDao;


    @Override
    public List<FoodType> getFoodTypeList() {
        return foodTypeDao.queryFoodType();
    }
}
