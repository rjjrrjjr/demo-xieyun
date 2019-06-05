package com.rj.map;

import com.alibaba.otter.canal.protocol.CanalEntry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ruanjin
 * @since 2019/4/25 15:56
 */
public class TestMap {

    public static void main(String[] args) {
        Map<Integer, String> tt = new HashMap<>();

        tt.put(1, "we");
        tt.put(3, "we");
        tt.put(2, "we");

        tt.remove(null);
        System.out.println("===========end");
        System.out.println(CanalEntry.EventType.INSERT.getNumber());
        System.out.println(CanalEntry.EventType.UPDATE.getNumber());
        System.out.println(CanalEntry.EventType.DELETE.getNumber());
    }
}
