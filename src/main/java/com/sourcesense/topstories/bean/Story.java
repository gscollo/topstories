package com.sourcesense.topstories.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Story {
	private String title;
	private String text;
	private String url;
	private String author;
	private Date time;
	
	public Story() {
		
	}
	
	public Story(NYStory nyStory) {
		this.title = nyStory.getTitle();
		this.text = nyStory.getText();
		this.url = nyStory.getUrl();
		this.time = nyStory.getCreated_date();
		this.author = nyStory.getByline();
	}
	
	public Story(HNStory hnStory) {
		if(hnStory != null) {
			this.title = hnStory.getTitle();
			this.text = hnStory.getText();
			this.url = hnStory.getUrl();
			this.time = new Date(hnStory.getTime() * 1000);
			this.author = hnStory.getBy();
		}
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Time: ").append(time)
			.append("\nTitle:").append(title)
			.append("\nAuthor").append(author)
			.append("\nURL").append(url)
			.append("\nText").append(text);
		
		return sb.toString();
	}
}
