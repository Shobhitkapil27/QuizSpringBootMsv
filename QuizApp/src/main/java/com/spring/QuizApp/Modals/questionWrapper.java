package com.spring.QuizApp.Modals;

import lombok.Data;

@Data
public class questionWrapper {

    private int serial_number;
    private String question;
    private String option_a, option_b, option_c, option_d;

    public questionWrapper(int serial_number, String question, String option_a, String option_b, String option_c,String option_d) {
        this.serial_number = serial_number;
        this.option_d = option_d;
        this.question = question;
        this.option_a = option_a;
        this.option_b = option_b;
        this.option_c = option_c;
    }
}
