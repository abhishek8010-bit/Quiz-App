package com.abhi.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("add")
	public Question addQuestion(@RequestBody Question question) {
		return questionServices.addQuestion(question);
	}
	
	@PutMapping("update/{id}")
    public List<Question> updateQuestion(@PathVariable Integer id, @RequestBody Question newQuestion) {
        try {
            Question updatedQuestion = questionServices.updateQuestion(id, newQuestion);
            return List.of(updatedQuestion);
        } 
        catch (Exception e) {
            return null;
      }
     }
	
	
	@DeleteMapping("delete/{id}")
    public List<Void> deleteQuestion(@PathVariable Integer id) {
   	  questionServices.deleteQuestion(id);
   	  return null;
   	  

	
	
	}
	
	
	
	
	
	}
	

	

