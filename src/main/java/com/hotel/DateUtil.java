package com.hotel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static Date getUTCTime(){
        Calendar cal = Calendar.getInstance();
        //获得时区和 GMT-0 的时间差,偏移量
        int offset = cal.get(Calendar.ZONE_OFFSET);
        //获得夏令时  时差
        int dstoff = cal.get(Calendar.DST_OFFSET);
        cal.add(Calendar.MILLISECOND, - (offset + dstoff));
        return cal.getTime();
    }
}
