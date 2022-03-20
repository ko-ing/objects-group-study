package com.koing.two.discountCondition;

import com.koing.two.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
