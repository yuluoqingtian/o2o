package com.bill.o2o.web.user;

import com.bill.o2o.dao.ShopDao;
import com.bill.o2o.dto.ShopReturnData;
import com.bill.o2o.entity.Shop;
import com.bill.o2o.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/shops",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> ListShopsByLocation(HttpServletRequest requestWithParameter){
        String latitude = requestWithParameter.getParameter("latitude");
        String longitude = requestWithParameter.getParameter("longitude");

        Map<String,Object> resultMap = new HashMap<>();


        try {
            List<ShopReturnData> shopReturnDataList = shopService.getShopListByLocation(latitude, longitude);
            if (shopReturnDataList.size()==0){
                resultMap.put("code","2");
                resultMap.put("message","当前地点附近没有商家");

            }else {
                resultMap.put("code","0");
                resultMap.put("data",shopReturnDataList);
            }

        }catch (Exception e){
            resultMap.put("code","1");
            resultMap.put("message","查询失败");
            resultMap.put("error",e.getMessage());
        }
        return resultMap;

    }



    @RequestMapping(value = "/search_shops",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> ListShopsByLocationAndKeyWords(HttpServletRequest requestWithParameter){
        String keyword = requestWithParameter.getParameter("keyword");

        Map<String,Object> resultMap = new HashMap<>();

        try {
            List<ShopReturnData> shopReturnDataList = shopService.getShopListByKeyword(keyword);
            if (shopReturnDataList.size()==0){
                resultMap.put("code","2");
                resultMap.put("keyword",keyword);
                resultMap.put("message","没有与"+keyword+"相关的商家哦");

            }else {
                resultMap.put("code","0");
                resultMap.put("data",shopReturnDataList);
            }
        }catch (Exception e){
            resultMap.put("code","1");
            resultMap.put("message","查询失败");
            resultMap.put("error",e.getMessage());
        }

             return resultMap;

    }
}
