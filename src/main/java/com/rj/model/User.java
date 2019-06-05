package com.rj.model;

import lombok.Data;

/**
 * @author yiqun
 * @since 2019/4/24 14:22
 */
@Data
public class User {

    private Long id;

    private String username;

    private String phone;

    private String email;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
