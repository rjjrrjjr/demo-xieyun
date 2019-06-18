package com.rj.gson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ruanjin
 * @since 2019/6/17 10:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private String name;

    private Integer age;
}
