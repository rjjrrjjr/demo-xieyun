package com.rj.convert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.cglib.core.Converter;

/**
 * 效率很高的bean拷贝工具类
 * 只会拷贝名称和类型都相同的属性
 */
public class BeanCopier {

    private static final Logger logger = LoggerFactory.getLogger(BeanCopier.class);

    private static final Map<String, net.sf.cglib.beans.BeanCopier> BEANCOPIER_MAP = new HashMap<>();

    /**
     * bean属性拷贝
     *
     * @param orig
     * @param dest
     */
    public static void copy(Object orig, Object dest) {
        copy(orig, dest, null);
    }

    /**
     * bean属性拷贝，并可以自定义converter
     *
     * @param dest
     * @param orig
     * @param converter
     */
    public static void copy(Object orig, Object dest, Converter converter) {
        String key = genKey(orig.getClass(), dest.getClass());
        boolean useConverter = converter != null;
        net.sf.cglib.beans.BeanCopier copier;
        if (!BEANCOPIER_MAP.containsKey(key)) {
            copier = net.sf.cglib.beans.BeanCopier.create(orig.getClass(), dest.getClass(), useConverter);
            BEANCOPIER_MAP.put(key, copier);
        } else {
            copier = BEANCOPIER_MAP.get(key);
        }
        copier.copy(orig, dest, converter);
    }

    private static String genKey(Class<?> origClazz, Class<?> destClazz) {
        return origClazz.getName() + destClazz.getName();
    }

    /**
     * 将from转换成指定类的实例
     *
     * @param from
     * @param toClazz
     * @return
     */
    public static <E> E transform(Object from, Class<E> toClazz) {
        return transform(from, toClazz, null);
    }

    /**
     * 将from转换成指定类的实例，可以自定义converter
     *
     * @param from
     * @param toClazz
     * @param converter
     * @return
     */
    public static <E> E transform(Object from, Class<E> toClazz, Converter converter) {
        try {
            if (from == null) {
                return null;
            }
            E to = toClazz.newInstance();
            copy(from, to, converter);
            return to;
        } catch (InstantiationException | IllegalAccessException e) {
            logger.error("transform error", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 列表的转换
     *
     * @param fromList
     * @param toClazz
     * @return
     */
    public static <E> List<E> transform(List<?> fromList, Class<E> toClazz) {
        return transform(fromList, toClazz, null);
    }

    /**
     * 列表的转换，可以自定义converter
     *
     * @param fromList
     * @param toClazz
     * @param converter
     * @return
     */
    public static <E> List<E> transform(List<?> fromList, Class<E> toClazz, Converter converter) {
        if (fromList == null) {
            return null;
        }
        List<E> toList = new ArrayList<>();
        for (Object from : fromList) {
            E to = transform(from, toClazz, converter);
            toList.add(to);
        }
        return toList;
    }

}
