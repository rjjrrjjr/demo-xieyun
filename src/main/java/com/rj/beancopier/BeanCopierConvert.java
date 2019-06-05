package com.rj.beancopier;


import com.rj.convert.BeanCopier;

/**
 * @author ruanjin
 * @since 2019/5/17 17:13
 */
public class BeanCopierConvert {

    public static void main(String[] args) {
        Usertwo rj = new Usertwo().builder().name("rj").age(19).sex(1).build();

        System.out.println(rj);

        UserOne userOne = BeanCopier.transform(rj, UserOne.class);

        System.out.println(userOne);

        Usertwo usertwo = BeanCopier.transform(userOne, Usertwo.class);

        System.out.println(usertwo);

    }
}
