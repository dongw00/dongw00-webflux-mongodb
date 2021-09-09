package com.dongw00.api.webfluxmongo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.dongw00.api.webfluxmongo.controller.AttemptController.ResultResponse;
import com.dongw00.api.webfluxmongo.domain.Attempt;
import com.dongw00.api.webfluxmongo.domain.Quiz;
import com.dongw00.api.webfluxmongo.domain.User;
import com.dongw00.api.webfluxmongo.service.QuizService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(AttemptController.class)
class AttemptControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    QuizService quizService;

    private JacksonTester<Attempt> jsonResult;
    private JacksonTester<ResultResponse> jsonResponse;

    @BeforeEach
    void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    void postResult() throws Exception {
        genericParameterizedTest(true);
    }

    private void genericParameterizedTest(final boolean correct) throws Exception {
        given(quizService.checkAttempt(any(Attempt.class))).willReturn(correct);
        User user = new User("john", "j", "john", "john@naver.com");
        Quiz quiz = new Quiz(50, 70);

        Attempt attempt = new Attempt(user, quiz, 3500, correct);
        // assertThat(attempt.getUser().getAlias(), is(equalTo("j")));

        MockHttpServletResponse response = mvc.perform(post("/attempts")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonResult.write(attempt).getJson())).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString())
            .isEqualTo(jsonResult
                .write(new Attempt(
                    attempt.getUser(),
                    attempt.getQuiz(),
                    attempt.getResultAttempt(),
                    correct)).getJson());
    }

    @Test
    void getStatics() {
    }

    @Test
    void getResultById() {
    }
}