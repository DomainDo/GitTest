package edu.ecnu.sei.MeetHere;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class SitePrice {

    public static BigDecimal getSitePrice(Site site) {

        switch (site) {
            case gymb1:
            case gymb2:
                return new BigDecimal("25.00");
            case gymbad1:
            case gymbad2:
                return new BigDecimal("30.00");
            case libroom1:
            case libroom2:
                return new BigDecimal("5.00");
            case meetingroom1:
                return new BigDecimal("1000.00");
            case meetingroom2:
                return new BigDecimal("500.00");
            default:
                System.out.println("资源不存在，请核实");
                return BigDecimal.ZERO;
        }
   }
}
