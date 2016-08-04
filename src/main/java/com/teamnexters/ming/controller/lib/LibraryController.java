package com.teamnexters.ming.controller.lib;

import com.teamnexters.ming.common.Const;
import com.teamnexters.ming.lib.Libraries;
import com.teamnexters.ming.util.HttpUtil;
import com.teamnexters.ming.util.Utils.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by molmo on 2016-07-30.
 */
@RestController
@RequestMapping("/lib")
public class LibraryController {
    @RequestMapping("/simsimi/{text}")
    public String index(@PathVariable String text) {
        Calendar oCalendar = Calendar.getInstance();
        String preTimeStamp = oCalendar.get(Calendar.HOUR_OF_DAY) + ":" + oCalendar.get(Calendar.MINUTE) + ":" + oCalendar.get(Calendar.SECOND);
        String response = Libraries.getSimsimi(text);
        oCalendar = Calendar.getInstance();
        String afterTimeStamp = oCalendar.get(Calendar.HOUR_OF_DAY) + ":" + oCalendar.get(Calendar.MINUTE) + ":" + oCalendar.get(Calendar.SECOND);
        return response;
    }

}
