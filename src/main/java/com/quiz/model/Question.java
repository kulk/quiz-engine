package com.quiz.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue
    private int questionId;

    private String question;
    @OneToOne
    private Answer correctAnswer;

    /*@Size(min = 4, max = 4)*/
    @OneToMany
    private List<Answer> incorrectAnswers;

    public Question() {
    }

    public Question(String question, Answer correctAnswer, List<Answer> incorrectAnswers) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = incorrectAnswers;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<Answer> getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void addIncorrectAnswers(Answer answer){
        if(incorrectAnswers == null){
            incorrectAnswers = new ArrayList<>();
        }
        incorrectAnswers.add(answer);
    }

    public void setIncorrectAnswers(List<Answer> incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }
}
