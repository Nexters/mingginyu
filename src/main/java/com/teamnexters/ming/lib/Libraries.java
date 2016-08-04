package com.teamnexters.ming.lib;

import com.teamnexters.ming.common.Const;
import com.teamnexters.ming.util.HttpUtil;
import com.teamnexters.ming.util.Utils;

/**
 * Created by molmo on 2016-07-30.
 */
public class Libraries {
    private static String response = null;
    public static String getSimsimi(String text) {
        Const.Simsimi library = new Const.Simsimi();
        Utils.HttpObject httpObject = new Utils.HttpObject();
        httpObject.setUrlString(library.getUrl());
        httpObject.setMethod("GET");
        httpObject.addParam(new Utils.Pair("key", library.getKey()));
        httpObject.addParam(new Utils.Pair("lc", "ko"));
        httpObject.addParam(new Utils.Pair("text", text));
        response = HttpUtil.getResponseFromHttpUrlConnection(httpObject);
        return response;
    }
    public static String getWhois(String ip) {
        Const.Whois library = new Const.Whois();
        Utils.HttpObject httpObject = new Utils.HttpObject();
        httpObject.setUrlString(library.getUrl());
        httpObject.setMethod("GET");
        httpObject.addParam(new Utils.Pair("query", ip));
        httpObject.addParam(new Utils.Pair("key", library.getKey()));
        httpObject.addParam(new Utils.Pair("answer", "json"));
        response = HttpUtil.getResponseFromHttpUrlConnection(httpObject);
        return response;
    }

}
