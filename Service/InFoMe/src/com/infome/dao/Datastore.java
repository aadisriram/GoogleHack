package com.infome.dao;

import java.util.List;

import com.infome.dataobject.Comment;
import com.infome.dataobject.Event;
import com.infome.dataobject.VideoObject;

public interface Datastore {
	
	public boolean put(String videoId);
	
	public boolean addComment(Comment comment);
	
	VideoObject getVideoObject(String videoId);
	
	List<Comment> getComments(Long commId);
	
	List<Event> getEvents(Long eventIdParam);

	boolean addEvent(Event event);
}
