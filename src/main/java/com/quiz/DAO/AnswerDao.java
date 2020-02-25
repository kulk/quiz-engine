package com.quiz.DAO;

import com.quiz.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerDao extends JpaRepository<Answer, Integer> {
    Answer findByAnswerId(int AnswerId);

}
