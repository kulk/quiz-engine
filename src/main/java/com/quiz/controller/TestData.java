package com.quiz.controller;

import com.quiz.model.Answer;
import com.quiz.model.Question;
import com.quiz.model.Quiz;
import com.quiz.service.AnswerService;
import com.quiz.service.QuestionService;
import com.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
public class TestData {

    @Autowired
    private QuizService quizService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    @GetMapping("test")
    public void loadTestData() {
        ArrayList<String> quizzes = new ArrayList<>();
        quizzes.add("../quiz-engine/src/main/resources/static/testdata/quiz1.txt");
        quizzes.add("../quiz-engine/src/main/resources/static/testdata/quiz2.txt");
        quizzes.add("../quiz-engine/src/main/resources/static/testdata/quiz3.txt");
        for (String quiz : quizzes) {
            try {
                Scanner input = new Scanner(new File(quiz));
                quizService.save(createQuiz(input));
            } catch (FileNotFoundException nietGevonden) {
                System.out.println("Het bestand is niet gevonden.");
            }
        }
    }

    private Quiz createQuiz(Scanner input) {
        ArrayList<Question> questions = new ArrayList<>();
        Quiz quiz = new Quiz();
        String rowsFromFile = input.nextLine();
        String[] rowArray = rowsFromFile.split(";");
        quiz.setName(rowArray[0]);
        while (input.hasNextLine()) {
            quiz.addQuestion(createQuestion(rowArray));
        }
        return quiz;
    }

    private Question createQuestion(String[] rowArray) {
        List<Answer> incorrectAnswers = getIncorrectAnswers(rowArray);
        Question question = new Question();
        question.setQuestion(rowArray[1]);
        Answer correctAnswer = getCorrectAnswer(rowArray);
        question.setCorrectAnswer(correctAnswer);
        for (Answer incorrectAnswer : incorrectAnswers) {
            question.addIncorrectAnswers(correctAnswer);
        }
        questionService.save(question);
        return question;

    }
    //Todo: Question is not stored
    //Todo: Quiz is not stored

    private Answer getCorrectAnswer(String[] rowArray) {
        Answer correctAnswer = new Answer(rowArray[2]);
        answerService.save(correctAnswer);
        return correctAnswer;

    }

    private List<Answer> getIncorrectAnswers(String[] rowArray) {
        List<Answer> incorrectAnswers = new ArrayList<>();
        for (int i = 2; i < rowArray.length; i++) {
            incorrectAnswers.add(new Answer(rowArray[i]));
        }
        return incorrectAnswers;
    }

}

