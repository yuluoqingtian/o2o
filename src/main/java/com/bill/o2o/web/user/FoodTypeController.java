package com.bill.o2o.web.user;


import com.bill.o2o.entity.FoodType;
import com.bill.o2o.service.FoodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "")
public class FoodTypeController {

    @Autowired
    private FoodTypeService foodTypeService;

    @RequestMapping(value = "/index_category", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> ListFoodType() {

        Map<String,Object> resultMap = new HashMap<>();

        try {
            List<FoodType> foodTypeList = foodTypeService.getFoodTypeList();
            resultMap.put("code","0");
            resultMap.put("data",foodTypeList);

        } catch (Exception e) {
            resultMap.put("code","1");
            resultMap.put("message","查询失败");
            resultMap.put("error",e.getMessage());

        }
        return resultMap;
    }


}
