package com.spring.QuizApp.DAO;

import com.spring.QuizApp.Modals.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface quizDao extends JpaRepository<Quiz, Integer> {
}
