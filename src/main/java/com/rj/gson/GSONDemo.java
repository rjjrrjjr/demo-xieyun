package com.rj.gson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.apache.commons.lang3.time.StopWatch;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ruanjin
 * @since 2019/6/17 10:21
 */
public class GSONDemo {

    private static final int count = 100000;

    public static void main(String[] args) {
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("name", "ruanjin");
        userMap.put("age", 18);
        userMap.put("sex", null);
        long timeJ, startTimeJ, timeG, startTimeG;

        //User userMap = new User("ruanjin", 18);
        System.out.println(JSON.toJSONString(userMap));
        System.out.println(new Gson().toJson(userMap));
        System.out.println("===========================================================");

        StopWatch stopWatch = new StopWatch();
        Gson gson = new Gson();
        stopWatch.start();
        for (int i = 0; i < count; i++) {
            JSON.toJSONString(userMap);
        }
        timeJ = stopWatch.getTime();
        startTimeJ = stopWatch.getStartTime();
        stopWatch.stop();
        System.out.println(String.format("JSON to str time: %d, startTime: %d", timeJ, startTimeJ));

        System.out.println("---------------------------------------------------------");

        stopWatch.reset();
        stopWatch.start();
        for (int i = 0; i < count; i++) {
            gson.toJson(userMap);
        }
        timeG = stopWatch.getTime();
        startTimeG = stopWatch.getStartTime();
        stopWatch.stop();
        System.out.println(String.format("GSON to str time: %d, startTime: %d", timeG, startTimeG));

        System.out.println("=========================================================");
        System.out.println(new Gson().fromJson("{\"name\":\"ruanjin\",\"age\":18}", User.class));
        System.out.println(JSONObject.parseObject("{\"name\":\"ruanjin\",\"age\":18}", User.class));
        System.out.println(JSON.parseObject("{\"name\":\"ruanjin\",\"age\":18}", User.class));

        stopWatch.reset();
        stopWatch.start();
        for (int i = 0; i < count; i++) {
            JSON.parseObject("{\"name\":\"ruanjin\",\"age\":18}", User.class);
        }
        timeJ = stopWatch.getTime();
        startTimeJ = stopWatch.getStartTime();
        stopWatch.stop();
        System.out.println(String.format("JSON to obj time: %d, startTime: %d", timeJ, startTimeJ));

        System.out.println("--------------------------------------------------------");

        stopWatch.reset();
        stopWatch.start();
        for (int i = 0; i < count; i++) {
            gson.fromJson("{\"name\":\"ruanjin\",\"age\":18}", User.class);
        }
        timeG = stopWatch.getTime();
        startTimeG = stopWatch.getStartTime();
        stopWatch.stop();
        System.out.println(String.format("GSON to obj time: %d, startTime: %d", timeG, startTimeG));

    }
}
