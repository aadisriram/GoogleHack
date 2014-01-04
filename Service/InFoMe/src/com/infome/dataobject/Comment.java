package com.infome.dataobject;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class Comment {

	@Persistent
	private Long commentId;
	
	@Persistent
	private String description;
	
	@Persistent
	private int commentTime;
	
	@Persistent
	private String username;

	public Comment(Long commentId, String description, int commentTime, String username) {
		super();
		this.commentId = commentId;
		this.description = description;
		this.commentTime = commentTime;
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(int commentTime) {
		this.commentTime = commentTime;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}