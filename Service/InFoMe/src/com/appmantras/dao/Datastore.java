package com.appmantras.dao;

import java.util.List;

import com.appmantras.dataobject.QuestionObject;

public interface Datastore {
	
	public boolean put(QuestionObject entity);
	
	public QuestionObject getQuestionById(Long qId);
	
	public String update(String entity, String response);
	
	public List<QuestionObject> getByCategory(String category);
	
	public List<String> getCategories();
}
