package com.bill.o2o.web.user;
import com.bill.o2o.dto.SimplePositionReturnData;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;


@Controller
@RequestMapping(value="")
public class LocationController {
    private static final String key = "OVTHl44HQB0SY770j8FoRkjFxbldNwPO";

    /**
     * 根据经纬度获得位置信息
     * @param requestWithParameter 携带经纬度的参数
     * @return {
    "code": "0",
    "data": {
    "address": "昌平区平西府站派出所东北366米",
    "city": "北京市",
    "geohash": "40.10038006084622,116.36866999999993",
    "longitude": "116.36866999999993",
    "latitude": "40.10038006084622",
    "name": "昌平区平西府站派出所东北366米",
    "cityCode": "131"
    }
    }
     */
    @RequestMapping(value = "/position",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> getLocationByLatAndLong(HttpServletRequest requestWithParameter){
        String geoHash = requestWithParameter.getParameter("geohash");
        String latitude = geoHash.split(",")[0];  //经度
        String longitude = geoHash.split(",")[1];    //纬度
        final Map<String,Object> resultMap = new HashMap<>();
        SimplePositionReturnData data = new SimplePositionReturnData();
        String url = "http://api.map.baidu.com/geocoder/v2/?"
                +"location="+latitude+","+longitude+"&"
                +"output=json"+"&"
                +"ak="+key;
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .build();
        final Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            if(response.body()!=null) {
                String jsonString = Objects.requireNonNull(response.body()).string();
                JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
                resultMap.put("code","0");
                data.setLongitude(jsonObject.get("result").getAsJsonObject().get("location").getAsJsonObject().get("lng").getAsString());
                data.setLatitude(jsonObject.get("result").getAsJsonObject().get("location").getAsJsonObject().get("lat").getAsString());
                String name = jsonObject.get("result").getAsJsonObject().get("addressComponent").getAsJsonObject().get("district").getAsString()+
                        jsonObject.get("result").getAsJsonObject().get("sematic_description").getAsString();
                data.setGeohash(data.getLatitude()+","+data.getLongitude());
                data.setName(name);
                data.setCity(jsonObject.get("result").getAsJsonObject().get("addressComponent").getAsJsonObject().get("province").getAsString());
                data.setAddress(data.getName());
                data.setCityCode(jsonObject.get("result").getAsJsonObject().get("cityCode").getAsString());
                resultMap.put("data",data);
            }else {
                resultMap.put("code","1");
                resultMap.put("error","请求定位信息失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return resultMap;

    }

}

