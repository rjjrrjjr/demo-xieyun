package com.rj.convert.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author ruanjin
 * @since 2019/4/28 16:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserVo {

    private Integer id;

    private String name;

    private Integer age;

    private String test;

}
