package com.koing.two.discountPolicy;

import com.koing.two.Money;
import com.koing.two.Screening;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
