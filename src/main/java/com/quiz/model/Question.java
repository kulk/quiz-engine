package com.quiz.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue
    private int questionId;

    private String question;

    @OneToOne
    private Answer correctAnswer;

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

    public void setIncorrectAnswers(List<Answer> incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }
}
