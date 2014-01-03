package com.infome.cookstuff;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infome.dao.Datastore;
import com.infome.dao.DatastoreImpl;
import com.infome.dataobject.Comment;
import com.infome.dataobject.VideoObject;

@SuppressWarnings("serial")
public class AddCommentServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/json");
		Datastore datastore = new DatastoreImpl();
		Boolean result = null;

		VideoObject videoObject = datastore.getVideoObject(req.getParameter("videoId"));
		
		try {
			 result = datastore.addComment(new Comment(videoObject.getCommentId(), 
					 								   req.getParameter("comment"), 
					 								   Integer.parseInt(req.getParameter("time")),
					 								   req.getParameter("username")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.getWriter().println(result);
	}
}
