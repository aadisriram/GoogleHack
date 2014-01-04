package com.gchack.dataobjects;

public class Event {

	private Long eventId;
	private String event;
	private int time;
	
	public Event(Long eventId, String event, int time) {
		super();
		this.eventId = eventId;
		this.event = event;
		this.time = time;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	
}
