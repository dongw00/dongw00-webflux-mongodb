package com.dongw00.api.webfluxmongo.domain;

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
    private final String id;
    private final String alias;
    private final String name;
    private final String email;
}
