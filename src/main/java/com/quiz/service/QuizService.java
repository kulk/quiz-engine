package com.quiz.service;

import com.quiz.DAO.QuizDao;
import com.quiz.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {


    private QuizDao quizDao;

    @Autowired
    public QuizService(QuizDao quizDao) {
        this.quizDao = quizDao;
    }

    public void save(Quiz quiz){
        quizDao.save(quiz);
    }
}
