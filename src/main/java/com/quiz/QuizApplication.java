package com.quiz;

import com.quiz.controller.TestData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuizApplication.class, args);
    }


    /*@Override
    public void run(String... String)throws Exception{
        System.out.println("Running!");
        TestData testData = new TestData();
        testData.loadTestData();
    }*/

}
