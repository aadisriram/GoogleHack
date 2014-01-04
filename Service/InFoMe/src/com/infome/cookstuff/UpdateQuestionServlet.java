package com.infome.cookstuff;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infome.dao.Datastore;
import com.infome.dao.DatastoreImpl;

@SuppressWarnings("serial")
public class UpdateQuestionServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/json");
		Datastore datastore = new DatastoreImpl();
		String result = null;
		try {
			 result = datastore.update(req.getParameter("key"), req.getParameter("response"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.getWriter().println(result);
	}
}
