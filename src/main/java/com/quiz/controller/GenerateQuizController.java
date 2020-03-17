package com.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GenerateQuizController {

    @GetMapping("/generate-quiz")
    public String generateQuizHandler(){
        return "generate-quiz";
    }
}
