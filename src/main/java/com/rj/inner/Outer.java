package com.rj.inner;

/**
 * @author ruanjin
 * @since 2019/5/5 17:23
 */
public class Outer {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static final class Inner{
        private Integer age;

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
