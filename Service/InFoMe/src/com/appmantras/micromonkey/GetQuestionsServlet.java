package com.appmantras.micromonkey;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.datanucleus.util.StringUtils;

import com.appmantras.dao.Datastore;
import com.appmantras.dao.DatastoreImpl;
import com.google.gson.Gson;

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