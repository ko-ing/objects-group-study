package com.koing.two.discountPolicy;

import com.koing.two.Money;
import com.koing.two.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
