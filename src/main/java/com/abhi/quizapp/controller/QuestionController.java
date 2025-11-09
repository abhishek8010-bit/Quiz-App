package com.abhi.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.quizapp.model.Question;
import com.abhi.quizapp.services.QuestionServices;

@RestController 
@RequestMapping("question")
public class QuestionController {
	@Autowired
	private QuestionServices questionServices;
	
	@GetMapping("allQuestions")
	public List<Question> getAllQuestions() {
		
		return questionServices.getAllQuestions();
	}
	
	@GetMapping("category/{category}")
	public List<Question>getQuestionByCategory(@PathVariable String category){
		return questionServices.getQuestionByCategory(category);
	}
}
	

