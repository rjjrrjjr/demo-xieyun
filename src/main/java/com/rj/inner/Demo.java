package com.rj.inner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ruanjin
 * @since 2019/5/5 17:25
 */
public class Demo {

    public static void main(String[] args) {
        Outer.Inner inner = new Outer.Inner();
        inner.setAge(11);
        List<Integer> collect = Arrays.asList(inner).stream().map(Outer.Inner::getAge).collect(Collectors.toList());
        collect.forEach(System.out::print);
    }
}
