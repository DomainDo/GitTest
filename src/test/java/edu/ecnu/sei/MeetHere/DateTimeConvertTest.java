package edu.ecnu.sei.MeetHere;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeConvertTest {

    @Test
    @DisplayName("转换符合格式要求的日期")
    void convertNormalDateString() {
        LocalDateTime result = DateTimeConvert.convertStringToDateTime("2019-09-20 18:00");
        assertEquals(LocalDateTime.of(2019,9,20,18,00),result);
    }



    @Test
    void convertTodayDateString(){
        LocalDateTime today = LocalDateTime.of(2021,1,15,18,00);
        LocalDateTime result = DateTimeConvert.convertStringToDateTime("今天 18:00");
        assertEquals(today,result,"今天是"+today);
    }

    @Test
    @DisplayName("转换包含关键字'今天'的日期")
    void convertTodayString(){
        LocalDate today = LocalDate.of(2019,9,16);
        LocalDateTime result = DateTimeConvert.convertStringToDateTime("今天 18:00");
        assertEquals(LocalDateTime.of(2019,10,28,18,00),result,
                "测试今天日期转换失败，今天是：" + today);
    }

    @Test
    @DisplayName("转换无效格式的日期，系统抛出异常")
    void convertInvalidDateString(){
        Throwable exception = assertThrows(RuntimeException.class,()->DateTimeConvert.convertStringToDateTime("2019-9-20 18:00"));
        assertEquals("输入预约时间格式不正确: [2019-9-20 18:00], 输入时间格式为[yyyy-MM-dd HH:mm]",exception.getMessage());
    }
}