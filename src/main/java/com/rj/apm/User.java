package com.rj.apm;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;

/**
 * @author ruanjin
 * @since 2019/5/16 14:57
 */
@Data
@Accessors(chain = true)
public class User {

    private String userName;

    private String password;

    public static void main(String[] args) {
        User kevin = new User().setUserName("Kevin").setPassword("123456");

        HashMap<String, Object> kevinMap = new HashMap<>();
        kevinMap.put("userName", "Kevin");
        kevinMap.put("password", "123456");

        System.out.println(net.sf.json.JSONObject.fromObject(kevin));

        System.out.println(net.sf.json.JSONObject.fromObject(kevinMap));
    }
}
