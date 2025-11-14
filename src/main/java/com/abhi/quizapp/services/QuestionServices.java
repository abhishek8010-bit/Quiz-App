package com.abhi.quizapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.abhi.quizapp.model.Question;
import com.abhi.quizapp.repository.QuestionRepository;


@Service
public class QuestionServices {
	@Autowired
	private QuestionRepository questionRepository;

	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
			return new ResponseEntity(questionRepository.findAll(), HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	
	public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
		try {
			return new ResponseEntity(questionRepository.findQuestionByCategory(category), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Question> addQuestion(Question question) {
		try {
			return new ResponseEntity(questionRepository.save(question), HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity(new ArrayList<>(), HttpStatus.BAD_REQUEST);
		 
	}

	public Question updateQuestion(Integer id, Question newQuestion) {
        Question user = questionRepository.findById(id).orElseThrow();
        user.setDifficultyLevel(newQuestion.getDifficultyLevel());
        user.setCategory(newQuestion.getCategory());
        user.setQuestionTitle(newQuestion.getQuestionTitle());
        user.setOption1(newQuestion.getOption1());
        user.setOption2(newQuestion.getOption2());
        user.setOption3(newQuestion.getOption3());
        user.setOption4(newQuestion.getOption4());
        user.setRightAnswer(newQuestion.getRightAnswer());
        return questionRepository.save(user);
    }

	public void deleteQuestion(Integer id) {
		questionRepository.deleteById(id);
	}

	

	

	

	 

}
