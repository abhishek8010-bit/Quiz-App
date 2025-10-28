package com.abhi.quizapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.quizapp.services.QuestionServices;

@RestController 
@RequestMapping("question")
public class QuestionController {
	@Autowired
	private QuestionServices questionservices;
	
	@GetMapping("allQuestions")
	public String getAllQuestions() {
		
		return questionservices.getAllQuestions();
	}
	

}