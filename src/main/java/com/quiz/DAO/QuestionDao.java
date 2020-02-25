package com.quiz.DAO;

import com.quiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionDao extends JpaRepository<Question, Integer> {
}
