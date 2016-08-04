package com.teamnexters.ming.controller.data;

import com.teamnexters.ming.repo.WateringRepo;
import com.teamnexters.ming.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by limjuhyun on 7/31/16.
 */
@RestController
@RequestMapping("/data")
public class WateringController {
    @Autowired
    WateringRepo wateringRepo;

    @RequestMapping
    public Map<String, Object> getWatering() {
        Map<String, Object> mapResData = new HashMap<String, Object>();
        mapResData.put("list", wateringRepo.findAll());
        return JsonUtil.putSuccessJsonContainer(mapResData);
    }
}
