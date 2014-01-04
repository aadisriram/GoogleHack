package com.gchack.dataobjects;

public class Comment {

	private Long commentId;
	private String comment;
	private int time;
	private String userName;
	
	public Comment(Long commentId, String comment, int time, String userName) {
		super();
		this.commentId = commentId;
		this.comment = comment;
		this.time = time;
		this.userName = userName;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
