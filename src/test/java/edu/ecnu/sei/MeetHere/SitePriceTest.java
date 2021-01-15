package edu.ecnu.sei.MeetHere;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SitePriceTest {

    @ParameterizedTest(name = "[{index}]: The price of {0} is {1} ")
    @CsvSource({
            "gymb1,25.00",
            "gymb2,25.00",
            "gymbad1,30.00",
            "gymbad2,30.00",
            "libroom1,5.00",
            "libroom2,5.00",
            "meetingroom1,1000.00",
            "meetingroom2,500.00",
    })
    void shouldGetSitePrice(Site site, BigDecimal expectedPrice) {
           assertEquals(expectedPrice,SitePrice.getSitePrice(site));
    }
}

