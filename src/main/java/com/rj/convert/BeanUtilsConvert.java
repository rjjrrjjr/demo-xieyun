package com.rj.convert;

import com.rj.convert.dto.UserDto;
import com.rj.convert.vo.UserVo;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * @author ruanjin
 * @since 2019/4/28 15:56
 */
public class BeanUtilsConvert {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        UserDto ruanjin = new UserDto(1L, "ruanjin", 12, 1);

        long startTime = System.currentTimeMillis();
        System.out.println("=======================================");
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userVo, ruanjin);
        System.out.println(userVo);
        System.out.println("=======================================BeanUtils cost time: " + (System.currentTimeMillis() - startTime));
    }
}
