package edu.ecnu.sei.MeetHere;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UpcomingReservationNotifierTest {
    @Test
    void checkEmailContent() {
        MeetCalendar meet = new MeetCalendar();
        meet.addReservation("sun","gymb1","2019-09-20 18:00");

        SmtpMessageSender sender = mock(SmtpMessageSender.class);
        when(sender.sendNotification("预约提醒",
                "2019-09-20 18:00您预约了体育馆1号篮球场地","user@foo.com"))
                .thenReturn("提醒邮件发送成功");

        UpcomingReservationNotifier notifier = new UpcomingReservationNotifier(meet,sender);
        notifier.run();

        ArgumentCaptor<String> titleString = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> bodyString = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> emailString = ArgumentCaptor.forClass(String.class);

        verify(sender).sendNotification(titleString.capture(),bodyString.capture(),emailString.capture());

        assertEquals("预约提醒", titleString.getValue());
        assertEquals("2019-09-20 18:00您预约了体育馆1号篮球场地",bodyString.getValue());
        assertEquals("user@foo.com",emailString.getValue());

        verify(sender).sendNotification(anyString(),anyString(),anyString());
        verify(sender,times(1))
                .sendNotification(anyString(),anyString(),anyString());


      }

    @DisplayName("没有Stub的Mock对象，返回值为null")
    @Test
    void mockSmtpMessageSenderWithoutStub(){
        MeetCalendar meet = new MeetCalendar();
        meet.addReservation("sun","gymb1","2019-09-20 18:00");
        SmtpMessageSender sender = mock(SmtpMessageSender.class);
        System.out.println(sender.sendNotification("预约提醒",
                "2019-09-20 18:00您预约了体育馆1号篮球场地","user@foo.com"));
    }
}

