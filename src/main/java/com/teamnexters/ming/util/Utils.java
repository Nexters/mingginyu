package com.teamnexters.ming.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by molmo on 2016-07-30.
 */
public class Utils {
    public static class Pair{
        private String key = null;
        private String value = null;
        public Pair(){

        }
        public Pair(String key, String value){
            this.key = key;
            this.value = value;
        }
        public String getKey(){
            return this.key;
        }
        public String getValue(){
            return this.value;
        }
        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class HttpObject {
        private String _method = null;
        private String _urlString = null;
        private List<Pair> _headers = new ArrayList<>();
        private List<Pair> _params = new ArrayList<>();

        public String getMethod() { return _method; }
        public String getUrlString() { return _urlString; }
        public List<Pair> getHeaders() { return _headers; }
        public List<Pair> getParams() { return _params; }

        public void setMethod(String method) { _method = method; }
        public void setUrlString(String urlString) { _urlString = urlString; }
        public void setHeaders(List<Pair> headers) { _headers = headers; }
        public void addHeader(Pair header) { _headers.add(header); }
        public void addHeaders(List<Pair> headers) {
            for(Pair header : headers) {
                _headers.add(header);
            }
        }
        public void setParam(List<Pair> params) { _params = params; }
        public void addParam(Pair param) { _params.add(param); }
        public void addParams(List<Pair> params) {
            for(Pair param : params) {
                _headers.add(param);
            }
        }
    }
}
