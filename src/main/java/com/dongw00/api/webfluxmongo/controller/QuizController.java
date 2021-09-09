package com.dongw00.api.webfluxmongo.controller;

import com.dongw00.api.webfluxmongo.domain.Quiz;
import com.dongw00.api.webfluxmongo.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @GetMapping("/random")
    public ResponseEntity<Mono<Quiz>> getQuiz() {
        return ResponseEntity.ok(quizService.createQuiz());
    }
}
