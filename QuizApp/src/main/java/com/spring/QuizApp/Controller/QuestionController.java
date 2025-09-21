package com.spring.QuizApp.Controller;

import com.spring.QuizApp.Modals.Question;
import com.spring.QuizApp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/getQuestions")
    public ResponseEntity<List<Question>> getQuestions(){
        System.out.println("Getting questions");
        return questionService.getAllQuestions();
    }

    @GetMapping("/getQuestion/{category}")
    public List<Question> getQuestionByCategory(@PathVariable String category){
        System.out.println("Getting questions by category");
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("addQuestion")
    public String addQuestion(@RequestBody Question question){
        questionService.addQuestion(question);
        return "Success";
    }
}
