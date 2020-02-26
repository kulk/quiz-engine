package com.quiz.controller;

import com.quiz.DAO.QuestionDao;
import com.quiz.model.Question;
import com.quiz.model.Quiz;
import com.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class TestData {

    @Autowired
    private QuizService quizService;

    @Autowired
    private QuestionDao questionDao;

    ArrayList<String> cars = new ArrayList<>();

    public void loadTestData(){
        ArrayList<String> quizzes = new ArrayList<>();
        quizzes.add("../quiz-engine/src/main/resources/static/testdata/quiz1.txt");
        quizzes.add("../quiz-engine/src/main/resources/static/testdata/quiz2.txt");
        quizzes.add("../quiz-engine/src/main/resources/static/testdata/quiz3.txt");
        for(String quiz: quizzes) {
            try {
                Scanner input = new Scanner(new File(quiz));
                quizService.save(createQuiz(input));
            } catch (FileNotFoundException nietGevonden) {
                System.out.println("Het bestand is niet gevonden.");
            }
        }
    }

    private Quiz createQuiz(Scanner input){
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

    private Question createQuestion(String[] rowArray){
        List<String> incorrectAnswers = getIncorrectAnswers(rowArray);
        Question question = new Question();
        question.setQuestion(rowArray[1]);
        question.setCorrectAnswer(rowArray[2]);
        for(String answer: incorrectAnswers){
            question.addIncorrectAnswers(answer);
        }
        questionDao.save(question);
        return question;

    }
    private List<String> getIncorrectAnswers(String[] rowArray){
        List<String> answers = new ArrayList<>();
        for (int i = 2; i < rowArray.length ; i++) {
            answers.add(rowArray[i]);
        }
        return answers;
    }

}

