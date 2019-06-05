package com.rj.convert;

import com.rj.convert.dto.UserDto;
import com.rj.convert.vo.UserVo;

/**
 * @author ruanjin
 * @since 2019/5/17 17:00
 */
public class BeanCopierConvert {

    public static void main(String[] args) {
        UserDto rj = new UserDto().setId(1L).setName("rj").setAge(19).setSex(1);
        System.out.println(rj);
        UserVo uv = BeanCopier.transform(rj, UserVo.class);
        System.out.println(uv);

    }
}
