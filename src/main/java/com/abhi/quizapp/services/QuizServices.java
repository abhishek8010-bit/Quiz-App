package com.abhi.quizapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.abhi.quizapp.model.Question;
import com.abhi.quizapp.model.Quiz;
import com.abhi.quizapp.repository.QuestionRepository;
import com.abhi.quizapp.repository.QuizRepository;

@Service
public class QuizServices {
	
	@Autowired
	public QuizRepository quizRepository;
	@Autowired
	public QuestionRepository questionRepository;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		
		List<Question> questions = questionRepository.findRandomQuestionsByCategory(category, numQ);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizRepository.save(quiz);
		
		return new ResponseEntity<>("Success" , HttpStatus.CREATED);
		
	}

}
