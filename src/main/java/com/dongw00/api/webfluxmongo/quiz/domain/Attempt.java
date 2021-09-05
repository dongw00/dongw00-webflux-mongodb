package com.dongw00.api.webfluxmongo.quiz.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Document(collation = "attempts")
public class Attempt {

    @Id
    private Long id;

    private final User user;
    private final Quiz quiz;
    private final int resultAttempt;
    private final boolean correct;
}
