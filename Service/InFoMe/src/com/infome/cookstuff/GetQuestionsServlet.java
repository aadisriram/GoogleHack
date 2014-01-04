package com.infome.cookstuff;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.datanucleus.util.StringUtils;

import com.google.gson.Gson;
import com.infome.dao.Datastore;
import com.infome.dao.DatastoreImpl;

@SuppressWarnings("serial")
public class GetQuestionsServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/json");
		String questionCategory = req.getParameter("category");
		String qId = req.getParameter("qId");
		String json = null;
		Datastore datastore = new DatastoreImpl();
		if(StringUtils.isEmpty(questionCategory)) {
			if(qId != null) {
				Long id = Long.parseLong(qId);
				json = new Gson().toJson(datastore.getQuestionById(id));
			} else {
				questionCategory = "general";
				json = new Gson().toJson(datastore.getByCategory(questionCategory));
			}
		}

		resp.getWriter().println(json);
	}
}