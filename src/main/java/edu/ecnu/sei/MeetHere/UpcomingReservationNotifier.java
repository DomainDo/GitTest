package edu.ecnu.sei.MeetHere;

import java.time.format.DateTimeFormatter;

public class UpcomingReservationNotifier {
    private MeetCalendar calendar;
    SmtpMessageSender notifier;

    public UpcomingReservationNotifier(MeetCalendar calendar,SmtpMessageSender notifier) {
        this.calendar = calendar;
        this.notifier = notifier;
    }

    public void run(){
          for(UserReservation reservation:calendar.getReservations()){
            String email = "user@foo.com";
            //System.out.println(buildmail(reservation));
            notifier.sendNotification("预约提醒",buildmail(reservation),email);
        }
    }

    private String buildmail(UserReservation reservation){
        return reservation.getReservationDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) +
                "您预约了" + reservation.getSite().getName();
    }
}
