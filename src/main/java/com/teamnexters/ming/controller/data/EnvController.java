package com.teamnexters.ming.controller.data;

import com.teamnexters.ming.entity.env;
import com.teamnexters.ming.repo.EnvRepo;
import com.teamnexters.ming.repo.WateringRepo;
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
public class EnvController {
    @Autowired
    EnvRepo envRepo;

    @RequestMapping("/closer.do")
    public Map<String, Object> saveCloaser(@RequestParam("value") String value) {
        Map<String, Object> mapResData = new HashMap<String, Object>();
        env env_closer = envRepo.findByEnvkey("closer");
        env_closer.setEnvvalue(value);
        mapResData.put("update", envRepo.saveAndFlush(env_closer));
        return JsonUtil.putSuccessJsonContainer(mapResData);
    }
    @RequestMapping("/closer/get.do")
    public Map<String, Object> getCloser() {
        Map<String, Object> mapResData = new HashMap<String, Object>();
        env env_closer = envRepo.findByEnvkey("closer");
        mapResData.put("closer", env_closer);
        return JsonUtil.putSuccessJsonContainer(mapResData);
    }
}
