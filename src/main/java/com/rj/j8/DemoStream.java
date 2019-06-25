package com.rj.j8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

/**
 * @author ruanjin
 * @since 2019/6/20 11:59
 */
public class DemoStream {

    public static void main(String[] args) {
        Integer sum = Arrays.asList(1, 2, 4, 5).stream().collect(Collectors.summingInt(Integer::intValue));
        System.out.println(sum);
        IntSummaryStatistics summaryStatistics = Arrays.asList(1, 2, 4, 5).stream().collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println(summaryStatistics);
        String result = Arrays.asList("a", "b", "c").stream().collect(Collectors.joining());
        System.out.println(result);
        System.out.println(String.join("-------", new String[]{"1", "2", "3"}));
        System.out.println(Arrays.asList("a", "b", "c").stream().collect(Collectors.joining("========")));
        System.out.println(Arrays.asList("a", "b", "c").stream().collect(Collectors.joining("========", "prex---", "---suffix")));
    }
}
