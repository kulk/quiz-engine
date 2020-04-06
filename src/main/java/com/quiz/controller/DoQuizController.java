package com.quiz.controller;

import com.quiz.model.Quiz;
import com.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class DoQuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/doquiz")
    public String doQuizHandler(@RequestParam(name = "id") int quizId, Model model) {
        model.addAttribute("quiz", quizService.findQuizById(quizId));
        return "do-quiz";
    }

    @CrossOrigin
    @PostMapping("/getquiz")
    public @ResponseBody
    Quiz getQuizHandler(@RequestParam(name = "quizid") int quizId) {
        return quizService.createClientQuiz(quizId);

    }

    @CrossOrigin
    @PostMapping("/result")
    //public @ResponseBody Quiz getQuizHandler(@RequestParam(name = "chosenanswers") String chosenAnswers) {
    public RedirectView getQuizHandler(@RequestParam(name = "chosenanswers") String chosenAnswers,
                                 @RequestParam(name = "quizid") String quizId) {
        System.out.println(chosenAnswers);
        System.out.println("quizid = " + quizId);
        //return "redirect:/generate-quiz";
        return new RedirectView("/");
    }



}
