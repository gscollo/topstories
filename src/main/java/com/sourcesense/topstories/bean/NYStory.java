package com.sourcesense.topstories.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NYStory {
	private String section;
	private String subsection;
	private String title;
	@JsonProperty(value="abstract")
	private String text; 
	private String url;
	private String byline;
	private String item_type;
	private Date updated_date;
	private Date created_date;
	
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getSubsection() {
		return subsection;
	}
	public void setSubsection(String subsection) {
		this.subsection = subsection;
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
	public String getByline() {
		return byline;
	}
	public void setByline(String byline) {
		this.byline = byline;
	}
	public String getItem_type() {
		return item_type;
	}
	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}
	public Date getUpdated_date() {
		return updated_date;
	}
	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	
	@Override
	public String toString() {
		return "NYStory [section=" + section + ", subsection=" + subsection + ", title=" + title + ", text=" + text
				+ ", url=" + url + ", byline=" + byline + ", item_type=" + item_type + ", updated_date=" + updated_date
				+ ", created_date=" + created_date + "]";
	}
	
}