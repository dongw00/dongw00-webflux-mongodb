package com.dongw00.api.webfluxmongo.repository;

import com.dongw00.api.webfluxmongo.domain.User;
import java.awt.print.Pageable;
import java.util.Optional;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {

    Optional<User> findByAlias(String alias);

    Flux<User> findAll();

    Mono<User> findById();

    @Query("{'alias': {$regex: ?0}}")
    Flux<User> findRegexByAlias(String alias);

    @Query("{'alias': {$regex: ?0}}")
    Flux<User> findByAliasWithPage(String alias, Pageable page);
}
