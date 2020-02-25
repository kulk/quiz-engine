package com.quiz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Answer {

    @Id
    @GeneratedValue
    private Integer answerId;

    private String answer;

    public Answer() {
    }

    public Answer(String answer) {
        this.answer = answer;
    }

    public int getAnswerId() {
        return answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
