package com.dongw00.api.webfluxmongo.service;

import com.dongw00.api.webfluxmongo.domain.Attempt;
import com.dongw00.api.webfluxmongo.domain.Quiz;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface QuizService {

    Mono<Quiz> createQuiz();

    boolean checkAttempt(Attempt attempt);

    Flux<Attempt> getStatsForUser(String alias);

    Mono<Attempt> getResultById(long id);
}
