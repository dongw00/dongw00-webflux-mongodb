package com.dongw00.api.webfluxmongo.controller;

import com.dongw00.api.webfluxmongo.domain.Attempt;
import com.dongw00.api.webfluxmongo.service.QuizService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/attempts")
@RequiredArgsConstructor
public class AttemptController {

    private final QuizService quizService;

    @RequiredArgsConstructor
    @NoArgsConstructor(force = true)
    @Getter
    static final class ResultResponse {

        private final boolean correct;
    }

    @PostMapping
    public ResponseEntity<Attempt> postResult(@RequestBody Attempt attempt) {
        boolean isCorrect = quizService.checkAttempt(attempt);
        Attempt attemptCopy = new Attempt(attempt.getUser(), attempt.getQuiz(),
            attempt.getResultAttempt(), isCorrect);
        return ResponseEntity.ok(attemptCopy);
    }

    @GetMapping
    public ResponseEntity<Flux<Attempt>> getStatics(@RequestParam("alias") String alias) {
        return ResponseEntity.ok(quizService.getStatsForUser(alias));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<Attempt>> getResultById(final @PathVariable("id") long id) {
        return ResponseEntity.ok(quizService.getResultById(id));
    }
}
