package com.abhi.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.quizapp.model.QuestionWrapper;
import com.abhi.quizapp.model.Responses;
import com.abhi.quizapp.services.QuizServices;





@RestController 
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	public QuizServices quizServices;
	
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
		return quizServices.createQuiz(category, numQ, title);
	}
	
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>>getQuizQuestions(@PathVariable Integer id){
		return quizServices.getQuizQuestions(id);
	}
	
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Responses> responses){
		return quizServices.calculatedResult(id, responses);
	}

}
