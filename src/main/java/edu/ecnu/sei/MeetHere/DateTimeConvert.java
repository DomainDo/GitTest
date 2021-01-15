package edu.ecnu.sei.MeetHere;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeConvert {
    public static LocalDateTime convertStringToDateTime(String dateTimeString) {

        LocalDateTime localDateTime;
        LocalDate today;
        try {
            //localDateTime = LocalDateTime.parse(dateTime.toUpperCase(),DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm"));
            if (dateTimeString.startsWith("今天")) {
                String[] parts = dateTimeString.split(" ", 2);
                today = LocalDate.now();
                LocalTime time = LocalTime.parse(parts[1].toUpperCase(),
                        DateTimeFormatter.ofPattern("HH:mm"));
                localDateTime = LocalDateTime.of(today, time);
            } else {

                localDateTime = LocalDateTime.parse(dateTimeString.toUpperCase(),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            }

        } catch (Throwable t) {
            throw new RuntimeException("输入预约时间格式不正确: [" +
                    dateTimeString.toUpperCase() + "], 输入时间格式为[yyyy-MM-dd HH:mm]");
        }
        return localDateTime;
    }
}
