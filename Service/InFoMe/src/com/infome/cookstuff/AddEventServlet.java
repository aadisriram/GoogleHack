package com.infome.cookstuff;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infome.dao.Datastore;
import com.infome.dao.DatastoreImpl;
import com.infome.dataobject.Event;
import com.infome.dataobject.VideoObject;

@SuppressWarnings("serial")
public class AddEventServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/json");
		Datastore datastore = new DatastoreImpl();
		Boolean result = null;

		VideoObject videoObject = datastore.getVideoObject(req.getParameter("videoId"));
		
		try {
			 result = datastore.addEvent(new Event(videoObject.getSeekId(), 
					 								   req.getParameter("event"), 
					 								   Integer.parseInt(req.getParameter("time"))));
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.getWriter().println(result);
	}
}
