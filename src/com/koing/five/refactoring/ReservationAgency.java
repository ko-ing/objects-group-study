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
        boolean discountable = checkDiscountable(screening);
        Money fee = calculateFee(screening, discountable, audienceCount);
        return createReservation(screening, customer, fee, audienceCount);
    }

    private boolean checkDiscountable(Screening screening) {
        return screening.getMovie().getDiscountConditions().stream().anyMatch(condition -> isDiscountable(condition, screening));
    }

    private boolean isDiscountable(DiscountCondition condition, Screening screening) {
        if (condition.getType() == DiscountConditionType.PERIOD) {
            return isSatisfiedByPeriod(condition, screening);
        }

        return isSatisfiedBySequence(condition, screening);
    }

    private boolean isSatisfiedByPeriod(DiscountCondition condition, Screening screening) {
        return screening.getWhenScreened().getDayOfWeek().equals(screening.getWhenScreened().getDayOfWeek()) &&
            condition.getstartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
            condition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
    }

    private boolean isSatisfiedBySequence(DiscountCondition condition, Screening screening) {
        return condition.getSequence() == screening.getSequence();
    }

    private Money calculateFee(Screening screening, boolean discountable, int audienceCount) {
        if (discountable) {
            return screening.getMovie().getFee()
                .minus(calculateDiscountFee(movie))
                .times(audienceCount);
        } else {
            return screening.getMovie().getFee().times(audienceCount);
        }
    }

    private Money calculateDiscountFee(Movie movie) {
        return switch (movie.getMovieType()) {
            case AMOUNT_DISCOUNT -> calculateAmountDiscountedFee(movie);
            case PERCENT_DISCOUNT -> calculateNoneDiscountedFee(movie);
            case NONE_DISCOUNT -> calculateNoneDiscountedFee(movie);
        };

        throw new IllegalArgumentException();
    }

    private Money calculateAmountDiscountedFee(Movie movie) {
        return movie.getDiscountAmount();
    }

    private Money calculatePercentDiscountedFee(Movie movie) {
        return moive.getFee().times(movie.getDiscountPercent());
    }

    private Money calculateNoneDiscountedFee(Movie movie) {
        return Money.ZERO;
    }

    private Reservation createReservation(Screening screening, Customer customer, Money fee, int audienceCount) {
        return new Reservation(customer, screening, fee, audienceCount);
    }
}
