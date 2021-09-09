package com.dongw00.api.webfluxmongo.domain;

import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@RequiredArgsConstructor
@Document(collation = "attempts")
@EqualsAndHashCode
@ToString
public class Attempt implements Serializable {

    @Id
    private long id;

    private final User user;
    private final Quiz quiz;
    private final int resultAttempt;
    private final boolean correct;
}
