package com.infome.dao;

import java.util.List;
//import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.google.appengine.api.search.SortExpression.SortDirection;
import com.infome.dataobject.Comment;
import com.infome.dataobject.Event;
import com.infome.dataobject.VideoObject;

public class DatastoreImpl implements Datastore{

	private static PersistenceManager pm;
	
	@Override
	public boolean put(String videoId) {
		try {
			pm = PMF.get().getPersistenceManager();
			pm.makePersistent(new VideoObject(videoId));
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		} finally {
			pm.close();
		}
	}

	@Override
	public boolean addComment(Comment comment) {
			
		try {
			pm = PMF.get().getPersistenceManager();
			pm.makePersistent(comment);
			return true; 
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		} finally {
			pm.close();
		}
	}
	
	@Override
	public boolean addEvent(Event event) {
			
		try {
			pm = PMF.get().getPersistenceManager();
			pm.makePersistent(event);
			return true; 
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		} finally {
			pm.close();
		}
	}
	
	@Override
	public VideoObject getVideoObject(String videoId) {
		pm = PMF.get().getPersistenceManager();
		return pm.getObjectById(VideoObject.class, videoId);
	}
	
	@Override
	public List<Comment> getComments(Long commentIdParam) {
		pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Comment.class);
		q.setFilter("commentId == commentIdParam");
		q.declareParameters("Long commentIdParam");
		@SuppressWarnings("unchecked")
		List<Comment> resultList = (List<Comment>) q.execute(commentIdParam);
		pm.close();
		return resultList;
	}
	
	@Override
	public List<Event> getEvents(Long eventIdParam) {
		pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Event.class);
		q.setFilter("eventId == eventIdParam");
		q.declareParameters("Long eventIdParam");
		@SuppressWarnings("unchecked")
		List<Event> resultList = (List<Event>) q.execute(eventIdParam);
		pm.close();
		return resultList;
	}
}
