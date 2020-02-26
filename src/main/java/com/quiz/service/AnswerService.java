package com.quiz.service;

import com.quiz.DAO.AnswerDao;
import com.quiz.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    @Autowired
    private AnswerDao answerDao;

    public AnswerService() {
    }

    public  void save(Answer answer){
        answerDao.save(answer);
    }



}
