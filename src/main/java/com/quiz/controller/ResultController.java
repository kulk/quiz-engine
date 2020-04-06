package com.quiz.controller;

import com.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResultController {

    @Autowired
    private QuizService quizService;

    @CrossOrigin
    @PostMapping("/result")
    public String getQuizHandler(@RequestParam(name = "chosenanswers") String chosenAnswersString,
                                 @RequestParam(name = "quizid") String quizId) {
        quizService.checkQuizResult(chosenAnswersString, quizId);
        return "generate-quiz";
    }

}
