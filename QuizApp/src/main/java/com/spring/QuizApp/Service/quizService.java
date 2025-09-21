package com.spring.QuizApp.Service;

import com.spring.QuizApp.DAO.QuestionDao;
import com.spring.QuizApp.DAO.quizDao;
import com.spring.QuizApp.Modals.Question;
import com.spring.QuizApp.Modals.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class quizService {

    @Autowired
    quizDao QuizDao;

    @Autowired
    QuestionDao QuestionDao;

    public ResponseEntity<String> createQuiz(String name, String category, int numQ) {
        List<Question> questions = QuestionDao.findRandom(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setName(name);
        quiz.setQuiz_questions(questions);
        QuizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
}
