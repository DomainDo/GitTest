package edu.ecnu.sei.MeetHere;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public abstract class RewardService {
    protected long neededPoints;

    public abstract RewardInformation applyReward(
            List<UserReservation> reservations, String userName, long customerPoints);

    protected BigDecimal calculateTotal(List<UserReservation> reservations,String userName) {
        BigDecimal sum = BigDecimal.ZERO;

        if(reservations != null) {
           for(UserReservation reservation: reservations){
             if(reservation.getUserName().equals(userName))
                sum = SitePrice.getSitePrice(reservation.getSite()).add(sum);
         }
        }
        return sum;
    }

    public long getNeededPoints() {
        return neededPoints;
    }

    public void setNeededPoints(long neededPoints) {
        this.neededPoints = neededPoints;
    }
}
