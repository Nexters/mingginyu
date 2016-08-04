package com.teamnexters.ming.controller.data;

import com.teamnexters.ming.entity.plant;
import com.teamnexters.ming.repo.PlantRepo;
import com.teamnexters.ming.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by limjuhyun on 7/31/16.
 */
@RestController
@RequestMapping("/data")
public class PlantController {

    @Autowired
    PlantRepo plantRepo;

    @RequestMapping("/plant/save.do")
    public Map<String, Object> savePlant(@RequestParam("datetime") String datetime
                                        ,@RequestParam("mos") float mos) {
        Map<String, Object> mapResData = new HashMap<String, Object>();
        plant p_plant = new plant();

        //20%차이 있는 거는 물을 준거다
        float finalMos = 100-((mos/1024)*100);
        String level = "";

        if(finalMos >= 97.0) {
            level ="A";
        } else if(finalMos >= 90.0) {
            level = "B";
        } else if(finalMos >=  65.0) {
            level = "C";
        } else if(finalMos>= 41.0) {
            level ="D";
        } else if(finalMos>=31.0) {
            level = "E";
        } else if (finalMos>=20.0) {
            level = "F";
        } else {
            level = "G";
        }

        p_plant.setDatetime(datetime);
        p_plant.setMos(finalMos);
        p_plant.setMos_level(level);

        mapResData.put("saved", plantRepo.saveAndFlush(p_plant));
        return JsonUtil.putSuccessJsonContainer(mapResData);
    }
}
