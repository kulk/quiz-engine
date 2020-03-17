package com.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewQuizController {


    @GetMapping("/create-quiz")
    public String newQuizHandler(){
        return "create-quiz";
    }
}
