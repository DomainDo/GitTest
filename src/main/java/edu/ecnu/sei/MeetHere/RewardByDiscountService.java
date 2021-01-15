package edu.ecnu.sei.MeetHere;

import java.math.BigDecimal;
import java.util.List;

public class RewardByDiscountService extends RewardService {
    private BigDecimal percentage;

    @Override
    public RewardInformation applyReward(
            List<UserReservation> reservations, String userName, long customerPoints) {
        RewardInformation rewardInformation = new RewardInformation();

        if(customerPoints >= neededPoints) {
            BigDecimal reTotal = calculateTotal(reservations,userName);
            BigDecimal discount = reTotal.multiply(percentage);
            rewardInformation = new RewardInformation(neededPoints, discount);
        }

        return rewardInformation;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        if(percentage.compareTo(BigDecimal.ZERO) > 1) {
            this.percentage = percentage;
        } else {
            throw new IllegalArgumentException("折扣率应该大于0");
        }
    }
}
