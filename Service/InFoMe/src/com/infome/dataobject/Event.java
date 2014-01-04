package com.infome.dataobject;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class Event {
	
	@Persistent
	private Long eventId;
	
	@Persistent
	private String eventText;
	
	@Persistent
	private int eventTime;
	
	public Event(Long eventId, String eventText, int eventTime) {
		this.eventId = eventId;
		this.eventText = eventText;
		this.eventTime = eventTime;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getEventText() {
		return eventText;
	}

	public void setEventText(String eventText) {
		this.eventText = eventText;
	}

	public int getEventTime() {
		return eventTime;
	}

	public void setEventTime(int eventTime) {
		this.eventTime = eventTime;
	}
}
