package com.rj.convert;

import com.rj.convert.dto.UserDto;
import com.rj.convert.vo.UserVo;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * @author ruanjin
 * @since 2019/4/28 15:56
 */
public class PropertyUtilsConvert {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        UserDto userDto = new UserDto(2L, "12", 11, 3);
        UserVo userVo = new UserVo();
        PropertyUtils.copyProperties(userVo, userDto);
        System.out.println(userDto);
        System.out.println(userVo);
    }
}
