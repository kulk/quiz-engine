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

    public void save(Quiz quiz){
        quizDao.save(quiz);
    }

    public List<Quiz> findAll(){
        return quizDao.findAll();
    }

    public Quiz findQuizById(int quizId){
        return quizDao.findQuizByQuizId(quizId);
    }

    public Quiz createClientQuiz(int quizId){
        Quiz quiz = findQuizById(quizId);
        List<Question> questions = quiz.getQuestions();
        for(Question question : questions){
            question.addIncorrectAnswers(question.getCorrectAnswer());
            question.setCorrectAnswer(new Answer(""));
            List<Answer> answers = question.getIncorrectAnswers();
            Collections.shuffle(answers);
            question.setIncorrectAnswers(answers);
        }
        quiz.setQuestions(questions);
        return quiz;
    }

    public ArrayList<String> checkQuizResult(String chosenAnswersString, String quizId){
        // Todo: Continue here
        System.out.println("Antwoorden" + chosenAnswersString);
        ArrayList<ArrayList<Integer>> result = gson.fromJson(chosenAnswersString, ArrayList.class);
        ArrayList<Integer> test = result.get(0);
        System.out.println(test.get(0));

        ArrayList<String> returnResult = new ArrayList<>(); // Why this return type?
        return returnResult;
    }

}
