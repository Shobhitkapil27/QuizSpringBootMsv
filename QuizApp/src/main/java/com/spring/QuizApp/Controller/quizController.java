package com.spring.QuizApp.Controller;

import com.spring.QuizApp.Service.quizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quiz")
public class quizController {

    @Autowired
    quizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String name,@RequestParam String category,@RequestParam int numQ) {
        try {
            return quizService.createQuiz(name, category, numQ);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
