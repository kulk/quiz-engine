package com.quiz.service;

import com.google.gson.Gson;
import com.quiz.DAO.QuizDao;
import com.quiz.model.Answer;
import com.quiz.model.Question;
import com.quiz.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class QuizService {

    private QuizDao quizDao;

    private Gson gson = new Gson();

    @Autowired
    public QuizService(QuizDao quizDao) {
        this.quizDao = quizDao;
    }

    public void save(Quiz quiz) {
        quizDao.save(quiz);
    }

    public List<Quiz> findAll() {
        return quizDao.findAll();
    }

    public Quiz findQuizById(int quizId) {
        return quizDao.findQuizByQuizId(quizId);
    }

    public Quiz createClientQuiz(int quizId) {
        Quiz quiz = findQuizById(quizId);
        List<Question> questions = quiz.getQuestions();
        for (Question question : questions) {
            question.addIncorrectAnswers(question.getCorrectAnswer());
            question.setCorrectAnswer(new Answer(""));
            List<Answer> answers = question.getIncorrectAnswers();
            Collections.shuffle(answers);
            question.setIncorrectAnswers(answers);
        }
        quiz.setQuestions(questions);
        return quiz;
    }

    public ArrayList<String> checkQuizResult(String chosenAnswersString, String quizId) {
        // Todo: Continue here
        ArrayList<ArrayList<Double>> result = gson.fromJson(chosenAnswersString, ArrayList.class);
        ArrayList<ArrayList<Integer>> castedResult = castDoubleListToInt(result);

        System.out.println("Antwoorden" + chosenAnswersString); // Remove
        ArrayList<Integer> test = castedResult.get(0); // Remove
        System.out.println(test.get(0)); // Remove

        ArrayList<String> returnResult = new ArrayList<>(); // Why this return type?
        return returnResult;
    }

    private ArrayList<ArrayList<Integer>> castDoubleListToInt(ArrayList<ArrayList<Double>> doubleList) {
        ArrayList<ArrayList<Integer>> intList = new ArrayList<>();
        for (ArrayList<Double> doubles : doubleList) {
            ArrayList<Integer> innerList = castInnerList(doubles);
            intList.add(innerList);
        }
        return intList;
    }

    private ArrayList<Integer> castInnerList(ArrayList<Double> innerList) {
        // Help method for castDoubleListToInt
        ArrayList<Integer> intList = new ArrayList<>();
        for (Double doubles : innerList) {
            intList.add(doubles.intValue());
        }
        return intList;
    }

}
