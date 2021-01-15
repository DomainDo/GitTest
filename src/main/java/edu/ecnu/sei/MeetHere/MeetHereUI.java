package edu.ecnu.sei.MeetHere;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MeetHereUI {
    private static MeetCalendar calendar;

    public static void main(String[] args) throws Throwable {
        calendar = new MeetCalendar();
        Scanner scanner = new Scanner(System.in);
        System.out.println("********************************************");
        System.out.println("             欢 迎 使 用 MeetHere           ");
        System.out.println("********************************************");

        String lastOption = "";
        while (!lastOption.equalsIgnoreCase("x")) {
            lastOption = displayMenu(scanner);
        }
        System.out.println("\n再见...... \n");
    }

    public static String displayMenu(Scanner scanner) throws Throwable {
        System.out.println("请选择:");
        System.out.println("1. 新建预约");
        System.out.println("2. 查看预约");
        System.out.println("X. 退出系统");
        System.out.print("您的选择为: ");
        String option = scanner.next();
        switch (option) {
            case "1":
                performSiteEntry(scanner);
                return option;
            case "2":
                performAllReservations();
                return option;
            default:
                System.out.println("您的输入选项无效, 请重新输入");
                return option;
        }
    }

    private static void performSiteEntry(Scanner scanner) {
        scanner.nextLine();
        System.out.println("\n请输入预约信息: ");
        System.out.println("用户姓名: ");
        String user = scanner.nextLine();
        System.out.println("预约日期(yyyy-MM-dd HH:mm): ");
        String when = scanner.nextLine();
        System.out.println("预约地点: ");
        String site = scanner.nextLine();
        //calendar.addReservation(user, when, site);
        LocalDate today = LocalDate.now();
        LocalDate reservationDay = DateTimeConvert.convertStringToDateTime(when).toLocalDate();
        if(reservationDay.isBefore(today))
            System.out.println("预约不成功：预约日期小于当前日期!");
        else
        {
            calendar.addReservation(user, site, when);
            System.out.println("预约成功!\n");
        }
    }

    private static void performAllReservations() throws Throwable {
        System.out.println("\n\nMeetHere的预约信息如下: ");
        for (UserReservation re : calendar.getReservations()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String reTime = formatter.format(re.getReservationDateTime());
            System.out.println(String.format("%s: %s\t\t预约地点: %s", reTime, re.getUserName(), re.getSite().getName()));
        }
        System.out.println("请按任意键继续.......");
        System.in.read();
        System.out.print("\n");
    }
}
