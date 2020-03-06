package com.quiz.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Quiz {
    @Id
    @GeneratedValue
    private int quizId;

    @Column(name="name", unique = true)
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Question> questions;

    private int highScore;

    public Quiz() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuizId() {
        return quizId;
    }

    public void addQuestion(Question question){
        if(this.questions == null){
            this.questions = new ArrayList<>();
        }
        questions.add(question);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }


}
