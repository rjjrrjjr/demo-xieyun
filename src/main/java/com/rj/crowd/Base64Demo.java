package com.rj.crowd;

/**
 * @author yiqun
 * @since 2019/4/23 14:27
 */
public class Base64Demo {

    public static void main(String[] args) {
        String base64String="gitlab:123456";
        byte[] result = java.util.Base64.getEncoder().encode(base64String.getBytes());
        System.out.println(new String(result));
    }
}
