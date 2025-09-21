package com.spring.QuizApp.DAO;

import com.spring.QuizApp.Modals.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM quiz_questions WHERE category = :category ORDER BY RANDOM() LIMIT :numQ;",nativeQuery = true)
    List<Question> findRandom(String category, int numQ);
}
