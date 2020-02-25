package com.quiz.controller;

import com.quiz.model.Answer;
import com.quiz.model.Question;
import com.quiz.model.Quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestData {

    ArrayList<String> cars = new ArrayList<String>();


    public void loadTestData(){
        ArrayList<String> quizzes = new ArrayList<>();
        quizzes.add("../quiz-engine/src/main/resources/static/testdata/quiz1.txt");
        quizzes.add("../quiz-engine/src/main/resources/static/testdata/quiz2.txt");
        quizzes.add("../quiz-engine/src/main/resources/static/testdata/quiz3.txt");

        for(String quiz: quizzes) {
            try {
                Scanner input = new Scanner(new File(quiz));
                createQuiz(input);
            } catch (FileNotFoundException nietGevonden) {
                System.out.println("Het bestand is niet gevonden.");
            }
        }
    }

    private Quiz createQuiz(Scanner input){
        ArrayList<Question> questions = new ArrayList<>();
        String title;
        Quiz quiz = new Quiz();
        while (input.hasNextLine()) {
            String rowsFromFile = input.nextLine();
            quiz.addQuestion(createQuestion(rowsFromFile.split(";")));

            }
        return quiz;
        }

    private Question createQuestion(String[] rowArray){
        Question question = new Question();
        question.setQuestion(rowArray[1]);
        question.setCorrectAnswer(new Answer(rowArray[2]));
        return question;
    }
    private List<Answer> createAnswers(String[] rowArray){
        List<Answer> answers = new ArrayList<>();
        for (int i = 2; i < rowArray.length ; i++) {
            answers.add(new Answer(rowArray[i]));
        }
        return answers;
    }

}

