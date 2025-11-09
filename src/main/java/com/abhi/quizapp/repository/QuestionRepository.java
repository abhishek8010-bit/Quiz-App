package com.abhi.quizapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhi.quizapp.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question , Integer>{
	
	 List<Question>findQuestionByCategory(String category);

}
