package com.rj.testInte;

/**
 * @author ruanjin
 * @since 2019/5/21 11:41
 */
public class IntegerDemo {

    public static void main(String[] args) {

        Integer a1 = 127;
        Integer a2 = 127;
        System.out.println(a1 == a2);   //true

        Integer a3 = 128;
        Integer a4 = 128;
        System.out.println(a3 == a4);   //false

        Integer a5 = -129;
        Integer a6 = -129;
        System.out.println(a5 == a6);   //false

        Integer a7 = -128;
        Integer a8 = -128;
        System.out.println(a7 == a8);   //true
    }
}
