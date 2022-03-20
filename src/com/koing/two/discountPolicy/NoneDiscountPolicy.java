package com.koing.two.discountPolicy;

import com.koing.two.Money;
import com.koing.two.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
