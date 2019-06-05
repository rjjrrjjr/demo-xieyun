package com.rj.json;

import com.alibaba.fastjson.JSON;

/**
 * @author ruanjin
 * @since 2019/6/3 16:56
 */
public class JSON2Object {

    public static void main(String[] args) {
        User user = JSON.parseObject("{\"age\":18,\"name\":\"ruanjin\"}", User.class);

        System.out.println(user);
    }
}
