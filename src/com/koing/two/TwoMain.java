package com.koing.two;

import com.koing.two.discountCondition.PeriodCondition;
import com.koing.two.discountCondition.SequenceCondition;
import com.koing.two.discountPolicy.AmountDiscountPolicy;
import com.koing.two.discountPolicy.NoneDiscountPolicy;
import com.koing.two.discountPolicy.PercentDiscountPolicy;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class TwoMain {
    public static void main(String[] args) {
        Movie avatar = new Movie("아바타",
            Duration.ofMinutes(120),
            Money.wons(1000),
            new AmountDiscountPolicy(
                Money.wons(800),
                new SequenceCondition(10),
                new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))
            )
        );

        avatar.changeDiscountPolicy(new PercentDiscountPolicy(0.1));

        Movie titanic = new Movie("타이타닉",
            Duration.ofMinutes(120),
            Money.wons(1000),
            new PercentDiscountPolicy(
                0.1,
                new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
                new SequenceCondition(2),
                new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59))
            )
        );

        Movie starWars = new Movie("스타워즈",
            Duration.ofMinutes(210),
            Money.wons(10000),
            new NoneDiscountPolicy()
        );

    }
}
