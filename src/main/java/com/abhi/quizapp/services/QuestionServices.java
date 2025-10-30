package com.abhi.quizapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.abhi.quizapp.model.Question;
import com.abhi.quizapp.repository.QuestionRepository;

@Service
public class QuestionServices {
	@Autowired
	private QuestionRepository questionRepository;

	public List<Question> getAllQuestions() {
		return questionRepository.findAll();
	}

	

}
