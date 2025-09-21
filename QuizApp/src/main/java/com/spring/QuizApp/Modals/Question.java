package com.spring.QuizApp.Modals;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "quiz_questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serial_number;
    private String question;
    private String option_a, option_b, option_c, option_d;
    private boolean is_active;
    private String correct_answer;
    private String category;
}
