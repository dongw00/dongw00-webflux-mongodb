package com.dongw00.api.webfluxmongo.service;

import com.dongw00.api.webfluxmongo.domain.Attempt;
import com.dongw00.api.webfluxmongo.domain.Quiz;
import com.dongw00.api.webfluxmongo.domain.User;
import com.dongw00.api.webfluxmongo.repository.AttemptRepository;
import com.dongw00.api.webfluxmongo.repository.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final GeneratorService generatorService;
    private final UserRepository userRepository;
    private final AttemptRepository attemptRepository;

    @Override
    public Mono<Quiz> createQuiz() {
        int factorA = generatorService.randomFactor();
        int factorB = generatorService.randomFactor();

        Quiz quiz = new Quiz(factorA, factorB);
        return Mono.just(quiz);
    }

    @Override
    public boolean checkAttempt(Attempt attempt) {
        Optional<User> user = userRepository.findByAlias(attempt.getUser().getAlias());

        Assert.isTrue(!attempt.isCorrect(), "Unable to send in graded state");

        boolean isCorrect =
            attempt.getResultAttempt() == attempt.getQuiz().getFactorA() * attempt.getQuiz()
                .getFactorB();

        Attempt checkAttempt = new Attempt(attempt.getUser(), attempt.getQuiz(),
            attempt.getResultAttempt(), isCorrect);

        attemptRepository.save(checkAttempt);
        return isCorrect;
    }

    @Override
    public Flux<Attempt> getStatsForUser(String alias) {
        return attemptRepository.findTop5ByUserAliasOrderByIdDesc(alias);
    }

    @Override
    public Mono<Attempt> getResultById(long id) {
        return null;
    }
}
