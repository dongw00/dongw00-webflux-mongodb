package com.dongw00.api.webfluxmongo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Quiz {

    private final int factorA;
    private final int factorB;
    private final int result;

    @Builder
    public Quiz(int factorA, int factorB) {
        this.factorA = factorA;
        this.factorB = factorB;
        this.result = this.factorA + this.factorB;
    }
}
