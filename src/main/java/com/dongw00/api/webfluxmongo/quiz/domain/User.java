package com.dongw00.api.webfluxmongo.quiz.domain;

import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "users")
@Getter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
public class User implements Serializable {

    @Id
    private final String userId;

    private final String alias;
}
