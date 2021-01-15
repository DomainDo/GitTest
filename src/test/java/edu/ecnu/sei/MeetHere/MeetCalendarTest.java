package edu.ecnu.sei.MeetHere;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MeetCalendarTest {

    private MeetCalendar meet;

    @BeforeEach
    void init() {
        meet = new MeetCalendar();
    }

    @Test
    void AddAnReservation() {
        meet.addReservation("Sun", "gymb1", "2020-09-20 18:00");
        List<UserReservation> reservations = meet.getReservations();
        assertNotNull(reservations);
        UserReservation inputReservation = reservations.get(0);
        assertAll(
                () -> assertEquals("Sun", inputReservation.getUserName()),
                () -> assertEquals(Site.gymb1, inputReservation.getSite()),
                () -> assertEquals("2020-09-20 18:00",
                        inputReservation.getReservationDateTime().format(
                                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))));
    }

    @Test
    void AddAnTodayReservation() {
        meet.addReservation("Sun", "gymb1", "今天 18:00");
        List<UserReservation> reservations = meet.getReservations();
        assertNotNull(reservations);
        UserReservation inputReservation = reservations.get(0);
        assertEquals("Sun", inputReservation.getUserName());
        assertEquals(Site.gymb1, inputReservation.getSite());
        assertEquals("2019-10-28 18:00",
                inputReservation.getReservationDateTime().format(
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
    }

    @Test
    void AddMoreReservation() {
        meet.addReservation("Sun", "gymb1", "今天 18:00");
        meet.addReservation("chen", "gymb2", "2019-10-01 09:00");
        List<UserReservation> reservations = meet.getReservations();
        assertNotNull(reservations);
        assertEquals(2, reservations.size());
    }
}