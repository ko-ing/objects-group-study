package com.koing.five;

import java.time.Duration;
import java.util.List;

public class Movie {
    private List<PeriodCondition> periodConditions;
    private List<SequenceCondition> sequenceConditions;

    private boolean isDiscountable(Screening screening) {
        return checkPeriodConditions(screening) || checkSequenceConditions(screening);
    }

    private boolean checkPeriodConditions(Screening screening) {
        return periodConditions.stream()
            .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    private boolean checkSequenceConditions(Screening screening) {
        return sequenceConditions.stream()
            .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }
}
