package com.koing.five.refactoring;

import com.koing.five.Customer;
import com.koing.five.Money;
import com.koing.five.Reservation;
import com.koing.five.Screening;
import com.koing.five.discountCondition.DiscountCondition;
import com.koing.five.discountCondition.DiscountConditionType;
import com.koing.five.movie.Movie;

public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Movie movie = screening.getMovie();

        boolean discountable = false;

        for(DiscountCondition condition: movie.getDiscountConditions()) {
            if (condition.getType() == DiscountConditionType.PERIOD) {
                discountable = screening.getWhenScreened().getDayOfWeek().equals(screening.getWhenScreened().getDayOfWeek()) &&
                    condition.getstartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
                    condition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
            } else {
                discountable = condition.getSequence() == screening.getSequence();
            }

            if (discountable) {
                break;
            }
        }

        Money fee;
        if (discountable) {
            Money discountAmount = Money.ZERO;
            switch (movie.getMovieType()) {
                case AMOUNT_DISCOUNT -> discountAmount = movie.getDiscountAmount();
                case PERCENT_DISCOUNT -> discountAmount = moive.getFee().times(movie.getDiscountPercent());
                case NONE_DISCOUNT -> discountAmount = money.ZERO;
            }

            fee = movie.getFee().minus(discountAmount).times(audienceCount);
        } else {
            fee = movie.getFee().times(audienceCount);
        }

        return new Reservation(customer, screening, fee, audienceCount);
    }

}
