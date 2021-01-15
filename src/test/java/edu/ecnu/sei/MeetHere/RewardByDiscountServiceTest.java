package edu.ecnu.sei.MeetHere;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.*;
import static org.junit.jupiter.api.Assertions.*;

class RewardByDiscountServiceTest {

    @Test
    void shouldCalculateTotal() {
        UserReservation r1 = new UserReservation("hysun",Site.gymb1,
                DateTimeConvert.convertStringToDateTime("2019-10-30 20:00"));
        UserReservation r2 = new UserReservation("hysun",Site.gymb2,
                DateTimeConvert.convertStringToDateTime("2019-11-13 13:00"));
        UserReservation r3 = new UserReservation("sqchen",Site.gymbad1,
                DateTimeConvert.convertStringToDateTime("2019-10-29 08:00"));
        UserReservation r4 = new UserReservation("Oliver",Site.meetingroom1,
                DateTimeConvert.convertStringToDateTime("2019-11-01 09:00"));
        List<UserReservation> reservations = asList(r1,r2,r3,r4);
        RewardByDiscountService discountService = new RewardByDiscountService();
        BigDecimal totalPrice = discountService.calculateTotal(reservations,"hysun");
        assertEquals(new BigDecimal("50.00"),totalPrice);
    }

}