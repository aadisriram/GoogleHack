package com.infome.dataobject;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class VideoObject {
	
	@PrimaryKey
	private String videoId;
	
	@Persistent(valueStrategy = IdGeneratorStrategy.SEQUENCE)
	private Long commentId;
	
	@Persistent(valueStrategy = IdGeneratorStrategy.SEQUENCE)
	private Long seekId;
	
	public VideoObject(String videoId) {
		this.setVideoId(videoId);
	}

	public Long getSeekId() {
		return seekId;
	}

	public void setSeekId(Long seekId) {
		this.seekId = seekId;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
}
