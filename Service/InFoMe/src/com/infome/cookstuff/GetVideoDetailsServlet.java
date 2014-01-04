package com.infome.cookstuff;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.datanucleus.util.StringUtils;

import com.google.gson.Gson;
import com.infome.dao.Datastore;
import com.infome.dao.DatastoreImpl;
import com.infome.dataobject.VideoData;
import com.infome.dataobject.VideoObject;

@SuppressWarnings("serial")
public class GetVideoDetailsServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/json");
		VideoData videoData = new VideoData();
		String videoId = req.getParameter("videoId");
		String json = null;
		Datastore datastore = new DatastoreImpl();
		if(!StringUtils.isEmpty(videoId)) {
			if(videoId != null) {
				VideoObject video = datastore.getVideoObject(videoId);
				videoData.comments = datastore.getComments(video.getCommentId());
				videoData.events = datastore.getEvents(video.getSeekId());
				json = new Gson().toJson(videoData);
			}
		}

		resp.getWriter().println(json);
	}
}