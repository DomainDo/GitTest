package edu.ecnu.sei.MeetHere;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SmtpMessageSender {

    public String sendNotification(String subject,String body,String address){
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host","localhost");
        Session session = Session.getDefaultInstance(properties,null);
        Message message = new MimeMessage(session);
        try{
            message.setFrom(new InternetAddress("notifier@meethere.com"));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(address));
            message.setSubject(subject);
            message.setContent(body,"text/html");
            Transport.send(message);
            return "提醒成功";
        }catch (Throwable t){
            t.printStackTrace();
            return "提醒失败";
        }
    }
}
