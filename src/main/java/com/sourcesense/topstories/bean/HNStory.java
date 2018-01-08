package com.sourcesense.topstories.bean;

public class HNStory {
	private Integer id;
	private Boolean deleted;
	private String type;
	private String by;
	private long time;
	private String text;
	private Boolean dead;
	private String url;
	private Integer score;
	private String title;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBy() {
		return by;
	}
	public void setBy(String by) {
		this.by = by;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Boolean getDead() {
		return dead;
	}
	public void setDead(Boolean dead) {
		this.dead = dead;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "HNStory [id=" + id + ", deleted=" + deleted + ", type=" + type + ", by=" + by + ", time=" + time
				+ ", text=" + text + ", dead=" + dead + ", url=" + url + ", score=" + score + ", title=" + title + "]";
	}
}
