package com.gavinandre.kotlininteroperatewithjava;

import com.alibaba.fastjson.JSON;

public class JSONUtils {

    static JSONUtils jsonUtils = new JSONUtils();

    public static String toJsonString(Object o) {
        return JSON.toJSONString(o);
    }

    public Object parseObject(String jsonText) throws Exception {
        throw new Exception("Test Exception");
    }

    public static void main(String[] args) {
        String url = "http://www.baidu.com";
        //Java调用Kotlin的object对象函数需要多加个INSTANCE
        String result = OkhttpUtils.INSTANCE.get(url);
        System.out.println(result);

        try {
            jsonUtils.parseObject("{}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
