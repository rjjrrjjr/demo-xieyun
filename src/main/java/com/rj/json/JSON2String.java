package com.rj.json;

import com.alibaba.fastjson.JSON;

/**
 * @author ruanjin
 * @since 2019/6/3 16:56
 */
public class JSON2String {

    public static void main(String[] args) {
        User ruanjin = new User("ruanjin", 18);

        String s = JSON.toJSONString(ruanjin);

        System.out.println(s);
    }
}
