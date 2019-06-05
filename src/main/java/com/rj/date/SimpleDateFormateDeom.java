package com.rj.date;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ruanjin
 * @since 2019/5/30 10:25
 */
public class SimpleDateFormateDeom {

    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd'T'00:00:00.000'Z'").format(new Date()));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd'T'23:59:059.999'Z'").format(new Date()));

        System.out.println("=================================================new DateTime(new Date()).withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0).toDate();");
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new DateTime(new Date()).withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0).toDate()));

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new DateTime(new Date()).withMillisOfSecond(0).toDate()));
    }
}
