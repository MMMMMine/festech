package com.festech.webapi.base.utils;

import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * Created by frank on 2017/9/4.
 */
public class DateUtil {

    public static int getCountDownSecond(Date startTime, int seconds) {

        int second = new Period(DateTime.now(), new DateTime(startTime).
                plusSeconds(seconds), PeriodType.seconds()).getSeconds();

        return second > 0 ? second : 0;
    }

    public static int getBewteenSeconds(Date time1, Date time2) {

        int sencond = Seconds.secondsBetween(new DateTime(time1), new DateTime(time2)).getSeconds();

        return sencond;

    }

    public static String getPushTime(Date startTime) {

        int secondsBetween = Seconds.secondsBetween(new DateTime(startTime), DateTime.now()).getSeconds();
        int minutesBetween = Minutes.minutesBetween(new DateTime(startTime), DateTime.now()).getMinutes();
        int hoursBetween = Hours.hoursBetween(new DateTime(startTime), DateTime.now()).getHours();

        if (secondsBetween < 60) {

            return "刚刚";

        } else if (minutesBetween < 60) {

            return minutesBetween + "分钟前";

        } else if (hoursBetween < 24) {

            return hoursBetween + "小时前";
        }

        return new DateTime(startTime).toString("yyyy-MM-dd HH:mm");

    }

    public static Date parseTime(String time, String format) {

        DateTimeFormatter dateFormat = DateTimeFormat.forPattern(format);


        return DateTime.parse(time, dateFormat).toDate();
    }

    public static DateTime parseDateTime(String time, String format) {

        DateTimeFormatter dateFormat = DateTimeFormat.forPattern(format);


        return DateTime.parse(time, dateFormat);

    }


    public static void main(String[] args) {
//
        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

        DateTime a = DateUtil.parseDateTime("2017-01-31 12:31:24","yyyy-MM-dd HH:mm:ss");

        a = a.plusMonths(1);

        System.out.println(a.toString("yyyy-MM-dd HH:mm:ss"));


//        Date startTime = DateTime.parse("2017-01-31 12:31:24", format).toDate();




//
//        System.out.println(getPushTime(startTime));

//        System.out.println(getCountDownSecond(DateTime.parse("2017-09-12 17:13:24", format).toDate(), 3600));

//        DateTime minStartTime;
//
//        DateTime now = new DateTime(startTime);
//
//        DateTime minDateTime = new DateTime().withMillisOfDay(0);
//
//        int hourOfDay = now.getHourOfDay();
//
//        int minuteOfHour = now.getMinuteOfHour();
//
//        int secondOfMinute = now.getSecondOfMinute();
//
//
//        if (hourOfDay < 6) {
//
//            minStartTime = minDateTime.plus(8);
//
//        } else if (hourOfDay >= 22 - Integer.valueOf("8")) {
//
//            minStartTime = minDateTime.plusDays(1).plusHours(8);
//
//        } else {
//
//            if (minuteOfHour <= 30) {
//
//                minStartTime = now.minusMinutes(minuteOfHour).minusSeconds(secondOfMinute).plusHours(2);
//
//            } else {
//
//                minStartTime = now.plusMinutes(60 - minuteOfHour).minusSeconds(secondOfMinute).plusHours(2);
//
//            }
//
//        }

//        System.out.println(minStartTime.toString("yyyy-MM-dd HH:mm:ss"));

    }

}
