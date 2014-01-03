package com.infome.cookstuff;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.datanucleus.util.StringUtils;

import com.infome.dao.Datastore;
import com.infome.dao.DatastoreImpl;
import com.infome.dataobject.QuestionObject;

@SuppressWarnings("serial")
public class PutQuestionServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		Datastore datastore = new DatastoreImpl();
		resp.setContentType("application/json");
		String questionTitle = req.getParameter("question");
		String questionCategory = req.getParameter("category");
		QuestionObject questionObj;
		String rootCategory = "Questions";
		String categoryPath = null;
		if(StringUtils.notEmpty(questionCategory)) {
			categoryPath = questionCategory;
			questionObj = new QuestionObject(questionTitle, 0, 0, categoryPath);
			resp.getWriter().println(datastore.put(questionObj));
		}
		questionObj = new QuestionObject(questionTitle, 0, 0, rootCategory);
//		resp.getWriter().println(datastore.put(questionObj));
		
	}
}