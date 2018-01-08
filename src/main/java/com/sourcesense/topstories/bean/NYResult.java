package com.sourcesense.topstories.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NYResult {
	private String status;
	private String copyright;
	private String section;
	private Date last_updated;
	private int num_results;
	private List<NYStory> results = new ArrayList<>();
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public Date getLast_updated() {
		return last_updated;
	}
	public void setLast_updated(Date last_updated) {
		this.last_updated = last_updated;
	}
	public int getNum_results() {
		return num_results;
	}
	public void setNum_results(int num_results) {
		this.num_results = num_results;
	}
	public List<NYStory> getResults() {
		return results;
	}
	public void setResults(List<NYStory> results) {
		this.results = results;
	}
	
	@Override
	public String toString() {
		return "NYResult [status=" + status + ", copyright=" + copyright + ", section=" + section + ", last_updated="
				+ last_updated + ", num_results=" + num_results + "]";
	}
	
}
