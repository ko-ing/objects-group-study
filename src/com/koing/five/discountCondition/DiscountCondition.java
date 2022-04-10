package com.koing.five.discountCondition;

import com.koing.five.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
