package edu.ecnu.sei.MeetHere;

import java.math.BigDecimal;

public class RewardInformation {
    private long pointsRedeemed;
    private BigDecimal discount;

    public RewardInformation() { }

    public RewardInformation(long pointsRedeemed, BigDecimal discount) {
        this.pointsRedeemed = pointsRedeemed;
        this.discount = discount;
    }

    public long getPointsRedeemed() {
        return pointsRedeemed;
    }

    public void setPointsRedeemed(long pointsReedemed) {
        this.pointsRedeemed = pointsReedemed;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}

