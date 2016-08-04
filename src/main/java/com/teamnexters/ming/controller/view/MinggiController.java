package com.teamnexters.ming.controller.view;

import com.teamnexters.ming.repo.PlantRepo;
import com.teamnexters.ming.repo.RoomRepo;
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
@RequestMapping("/app")
public class MinggiController {
    @Autowired
    PlantRepo plantRepo;
    @Autowired
    RoomRepo roomRepo;
    @Autowired
    WateringRepo wateringRepo;

    @RequestMapping("/main.do")
    public Map<String, Object> getMain() {
        Map<String, Object> mapResData = new HashMap<String, Object>();
        mapResData.put("plant", plantRepo.findTopByOrderByDatetimeDesc());
        mapResData.put("room", roomRepo.findTopByOrderByDatetimeDesc());

        return JsonUtil.putSuccessJsonContainer(mapResData);
    }
}
