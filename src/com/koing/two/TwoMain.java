package com.koing.two;

import com.koing.two.discountCondition.PeriodCondition;
import com.koing.two.discountCondition.SequenceCondition;
import com.koing.two.discountPolicy.AmountDiscountPolicy;

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
            ));
    }
}
