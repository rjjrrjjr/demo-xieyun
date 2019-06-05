package com.rj.beancopier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ruanjin
 * @since 2019/5/17 17:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usertwo {

    private String name;

    private Integer age;

    private Integer sex;
}
