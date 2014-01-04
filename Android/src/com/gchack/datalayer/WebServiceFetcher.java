package com.gchack.datalayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;

import com.gchack.dataobjects.Comment;
import com.gchack.dataobjects.Event;
import com.gchack.dataobjects.VideoDetails;
import com.gchack.dataobjects.YoutubeVideo;

public class WebServiceFetcher {
	
	public List<YoutubeVideo> ytubeList = new ArrayList<YoutubeVideo>();
	
	public String getJsonResponse(String url) {
		StringBuilder builder = new StringBuilder();
		HttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		try {
			HttpResponse response = client.execute(httpGet);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			if (statusCode == 200) {
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();
				BufferedReader reader = new BufferedReader(new InputStreamReader(content));
				String line;
				while ((line = reader.readLine()) != null) {
					builder.append(line);
				}
			} else {
				Log.e(WebServiceFetcher.class.toString(), "Failed to download file");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return builder.toString();
	}
	
	public VideoDetails getVideoDetails(String jsonString) throws Exception {
		JSONObject jObj = new JSONObject(jsonString);
		JSONArray commentArray = jObj.getJSONArray("comments");
		JSONArray eventArray = jObj.getJSONArray("events");
		
		List<Comment> commentList = new ArrayList<Comment>();
		for(int i = 0; i < commentArray.length(); i++) {
			JSONObject temp = commentArray.getJSONObject(i);
			commentList.add(new Comment(temp.getLong("commentId"), temp.getString("description"),
										temp.getInt("commentTime"), temp.getString("username")));
		}
		
		List<Event> eventList = new ArrayList<Event>();
		for(int i = 0; i < eventArray.length(); i++) {
			JSONObject temp = eventArray.getJSONObject(i);
			eventList.add(new Event(temp.getLong("eventId"), temp.getString("eventText"),
										temp.getInt("eventTime")));
		}
		
		VideoDetails videoDetails = new VideoDetails();
		videoDetails.comments = commentList;
		videoDetails.events = eventList;
		
		return videoDetails;
	}
	
	public String getYoutubeList() throws Exception {
		String jsonString = getJsonResponse("https://gdata.youtube.com/feeds/users/qJkAAmi4QKCPCF62r_-BhQ/uploads?alt=json");
		return jsonString;
	}
	
	public String getVideoData(String videoId) {
		String jsonString = getJsonResponse("http://1.ghfshack.appspot.com/getVideoDetails?videoId=" + videoId);
		return jsonString;
	}
}

