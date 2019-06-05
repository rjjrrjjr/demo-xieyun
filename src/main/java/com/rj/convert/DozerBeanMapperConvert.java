package com.rj.convert;

import com.rj.convert.dto.UserDto;
import com.rj.convert.vo.UserVo;
import org.dozer.DozerBeanMapper;

/**
 * @author ruanjin
 * @since 2019/4/28 16:54
 */
public class DozerBeanMapperConvert {

    public static void main(String[] args) {
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            UserDto ruanjin = new UserDto(3L, "ruanjin", 18, 2);
            UserVo userVo = dozerBeanMapper.map(ruanjin, UserVo.class);
        }
        System.out.println("===================================DozerBeanMapper cost time: " + (System.currentTimeMillis() - startTime));
    }
}
