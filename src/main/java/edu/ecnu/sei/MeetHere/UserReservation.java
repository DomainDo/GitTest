package edu.ecnu.sei.MeetHere;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class UserReservation {
    private String userName;
    private LocalDateTime reservationDateTime;
    private Site site;

    public UserReservation(String userName, Site site, LocalDateTime reservationDateTime) {
        this.userName = userName;
        this.reservationDateTime = reservationDateTime;
        this.site = site;
    }

    public String getUserName() {
        return userName;
    }

    public LocalDateTime getReservationDateTime() {
        return reservationDateTime;
    }

    public Site getSite() {
        return site;
    }

}
