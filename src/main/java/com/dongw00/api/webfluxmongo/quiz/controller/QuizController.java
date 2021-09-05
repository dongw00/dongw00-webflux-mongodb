package com.dongw00.api.webfluxmongo.quiz.controller;

import com.dongw00.api.webfluxmongo.quiz.domain.Quiz;
import com.dongw00.api.webfluxmongo.quiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;

    @GetMapping("/random")
    public ResponseEntity<Mono<Quiz>> getQuiz() {
        return ResponseEntity.ok(quizService.createQuiz());
    }
}
