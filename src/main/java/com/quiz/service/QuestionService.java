package com.quiz.service;

import com.quiz.DAO.QuestionDao;
import com.quiz.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {


    private QuestionDao questionDao;

    @Autowired
    public QuestionService(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public void save(Question question) {
        questionDao.save(question);
    }
}
