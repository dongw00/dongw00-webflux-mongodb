package com.dongw00.api.webfluxmongo.quiz.service;

import com.dongw00.api.webfluxmongo.quiz.domain.Quiz;
import reactor.core.publisher.Mono;

public interface QuizService {
    Mono<Quiz> createQuiz();
}
