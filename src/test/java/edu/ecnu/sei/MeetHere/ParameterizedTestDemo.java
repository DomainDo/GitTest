package edu.ecnu.sei.MeetHere;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.apache.commons.lang.StringUtils;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterizedTestDemo {

    @ParameterizedTest
    @ValueSource(strings = {"software testing","Junit5","Have fun!"})
    void lowerCase(String candidate) {
        assertTrue(StringUtils.isAllLowerCase(candidate));
    }

    @ParameterizedTest
    void testMethodWithoutArgumentSource(int candidate) {
        assertEquals(9,candidate);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @MethodSource("range")
    void testMethodWithoutMultipleArgumentSource(int candidate) {
        assertNotEquals(9,candidate);
    }

    static IntStream range(){
        return IntStream.range(0,20).skip(15);
    }

    @ParameterizedTest
    @ValueSource(shorts = {-32768, 2, 32767})
    void value_source_short(short candidate) {
        assertTrue(candidate >= Short.MIN_VALUE
                && candidate <= Short.MAX_VALUE);
    }

    @ParameterizedTest
    @ValueSource(bytes = {-128, 100, 127})
    void value_source_byte(byte candidate) {
        assertTrue(candidate >= Byte.MIN_VALUE
                && candidate <= Byte.MAX_VALUE);
    }

    @ParameterizedTest
    @ValueSource(ints = {-2147483648, 100, -2147483647})
    void value_source_int(int candidate) {
        assertTrue(candidate >= Integer.MIN_VALUE
                && candidate <= Integer.MAX_VALUE);
    }

    @ParameterizedTest
    @ValueSource(longs = {-9223372036854775808L, 4L, 9223372036854775807L})
    void value_source_long(long candidate) {
        assertTrue(candidate >= Long.MIN_VALUE
                && candidate <= Long.MAX_VALUE);
    }

    //一般使用BigDecimal
    @ParameterizedTest
    @ValueSource(floats = {1.4E-45F, 2.00002F, 3.4028235E38F})
    void value_source_float(float candidate) {
        assertTrue(candidate >= Float.MIN_VALUE
                && candidate <= Float.MAX_VALUE);
        assertTrue(Float.compare(candidate, Float.MIN_VALUE) >= 0
                && Float.compare(candidate, Float.MAX_VALUE) <= 0);
    }

    @ParameterizedTest
    @ValueSource(doubles = {4.9E-324, 2.20000D, 1.7976931348623157E308})
    void value_source_double(double candidate) {
        assertTrue(candidate >= Double.MIN_VALUE
                && candidate <= Double.MAX_VALUE);
        assertTrue(Double.compare(candidate, Double.MIN_VALUE) >= 0
                && Double.compare(candidate, Double.MAX_VALUE) <= 0);
    }

    @ParameterizedTest
    @ValueSource(chars = {'\u0000', '\u0141', '\uFFFF'})
    void value_source_char(char candidate) {
        assertTrue(candidate >= Character.MIN_VALUE
                && candidate <= Character.MAX_VALUE);
    }


    @ParameterizedTest
    @ValueSource(booleans = {true, false, true, true})
    void value_source_boolean(boolean candidate) {
        assertTrue(candidate);
    }

    @ParameterizedTest
    @ValueSource(strings = {"software testing", "hysun"})
    void value_source_String(String candidate) {
        assertTrue(StringUtils.isAllLowerCase(candidate));
    }

    @ParameterizedTest
    @ValueSource(classes = {Integer.class, String.class})
    void testWithValueSource2(Object arg1) {
        assertEquals(String.class, arg1);
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class)
    void testWithEnumSource(TimeUnit timeUnit) {
        assertNotNull(timeUnit);
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class,names = {"DAYS","HOURS"},mode = EnumSource.Mode.EXCLUDE)
    void testWithEnumSourceAtt(TimeUnit timeUnit) {
        assertNotNull(timeUnit);
    }
}


