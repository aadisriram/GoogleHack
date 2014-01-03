package com.gchack.dataobjects;

public class YoutubeVideo {
	private String id;
	private String thumbnail;
	private String name;
	private int length;
	
	public YoutubeVideo(String id, String thumbnail, String name, int length) {
		super();
		this.id = id;
		this.thumbnail = thumbnail;
		this.name = name;
		this.setLength(length);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	
}
