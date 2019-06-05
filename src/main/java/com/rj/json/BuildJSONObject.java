package com.rj.json;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * @author ruanjin
 * @since 2019/6/3 17:01
 */
public class BuildJSONObject {

    public static void main(String[] args) {
        Map<String, Object> map = JSON.parseObject("{\"age\":18,\"name\":\"ruanjin\"}", Map.class);

        map.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        System.out.println("========================================");

        net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject("{\"age\":18,\"name\":\"ruanjin\"}");

        System.out.println(jsonObject.get("name"));
        System.out.println(jsonObject.get("age"));
    }
}
