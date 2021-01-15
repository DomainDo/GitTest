package edu.ecnu.sei.MeetHere;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MeetCalendar {
    private List<UserReservation> reservations;

    public MeetCalendar() {
        this.reservations = new ArrayList<>();
    }

    public void addReservation(String userName, String siteKey, String dateTime) {
        Site site = Site.valueOf(siteKey.toLowerCase());
        LocalDateTime localDateTime = DateTimeConvert.convertStringToDateTime(dateTime);
        UserReservation reservation = new UserReservation(userName, site,localDateTime);
        reservations.add(reservation);
    }

    public List<UserReservation> getReservations() {
        return this.reservations;
    }
}
