package com.infome.cookstuff;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infome.dao.Datastore;
import com.infome.dao.DatastoreImpl;

@SuppressWarnings("serial")
public class PutQuestionServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		Datastore datastore = new DatastoreImpl();
		resp.setContentType("application/json");
		String videoId = req.getParameter("videoId");
		resp.getWriter().println(datastore.put(videoId));
	}
}