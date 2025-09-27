package com.spring.QuizApp.Service;

import com.spring.QuizApp.DAO.QuestionDao;
import com.spring.QuizApp.DAO.quizDao;
import com.spring.QuizApp.Modals.Question;
import com.spring.QuizApp.Modals.Quiz;
import com.spring.QuizApp.Modals.questionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<List<questionWrapper>> getQuizQuestions(int id) {
        Optional<Quiz> quiz=QuizDao.findById(id);
        List<Question> quiestions=quiz.get().getQuiz_questions();
        List<questionWrapper> questionForUser=new ArrayList<>();

        int questionNumber=1;//We will not reflect the DB serial number
        for(Question question:quiestions){
            questionWrapper qw=new questionWrapper(questionNumber, question.getQuestion(), question.getOption_a(), question.getOption_b(), question.getOption_c(), question.getOption_d());
            questionForUser.add(qw);
            questionNumber++;
        }
        return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(int id, List<Response> resp){
        Quiz quiz=QuizDao.findById(id).get();
        List<Question> questions=quiz.getQuiz_questions();

        int i=0;
        int result=0;

        for(Response resp1:resp){
            if(resp1.getResponse().equals(questions.get(i).getCorrect_answer())){
                result++;
            }
            i++;
        }
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
