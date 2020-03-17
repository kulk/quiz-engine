package com.quiz.controller;

import com.quiz.model.Quiz;
import com.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/")
    public String homeHandler(Model model) {
        model.addAttribute("quizzes", quizService.findAll());
        return "home";
    }

}
