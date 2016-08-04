package com.teamnexters.ming.controller.data;

import com.teamnexters.ming.entity.room;
import com.teamnexters.ming.repo.RoomRepo;
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
public class RoomController {

    @Autowired
    RoomRepo roomRepo;

    @RequestMapping("/room/save.do")
    public Map<String, Object> saveRoom(@RequestParam("datetime") String datetime
                                     , @RequestParam("mos") float mos
                                     , @RequestParam("temp") float temp) {
        Map<String, Object> mapResData = new HashMap<String, Object>();
        room r_room = new room();
        String temp_level ="";
        String mos_level = "";

        //40 ~ 35 A 34 ~ 32 C
        if(temp>=35.0)
            temp_level = "A";
        else if(temp>=32.0)
            temp_level = "B";
        else
            temp_level = "C";

        //61 A , 40 B, C
        if(mos>=61.0)
            mos_level = "A";
        else if(mos>=40.0)
            mos_level = "B";
        else
            mos_level = "C";


        r_room.setMos(mos);
        r_room.setMos_level(mos_level);
        r_room.setDatetime(datetime);
        r_room.setTemp(temp);
        r_room.setTemp_level(temp_level);

        mapResData.put("saved", roomRepo.saveAndFlush(r_room));

        return JsonUtil.putSuccessJsonContainer(mapResData);



    }
}
