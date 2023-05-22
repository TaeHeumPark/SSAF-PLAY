package com.ssaf.play.dto;

public class Match {

	private int match_id;
	private String title;
	private String content;
	private String start_date;
	private int curr_head_count;
	private int limit_head_count;
	private String address;
	private String location;
	private double latitude;
	private double longitude;
	private int sports_id;
	private String sport;
	
	public Match() {
		// TODO Auto-generated constructor stub
	}

	public Match(int match_id, String title, String content, String start_date, int curr_head_count,
			int limit_head_count, String address, String location, double latitude, double longitude, int sports_id,
			String sport) {
		super();
		this.match_id = match_id;
		this.title = title;
		this.content = content;
		this.start_date = start_date;
		this.curr_head_count = curr_head_count;
		this.limit_head_count = limit_head_count;
		this.address = address;
		this.location = location;
		this.latitude = latitude;
		this.longitude = longitude;
		this.sports_id = sports_id;
		this.sport = sport;
	}

	public int getMatch_id() {
		return match_id;
	}

	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public int getCurr_head_count() {
		return curr_head_count;
	}

	public void setCurr_head_count(int curr_head_count) {
		this.curr_head_count = curr_head_count;
	}

	public int getLimit_head_count() {
		return limit_head_count;
	}

	public void setLimit_head_count(int limit_head_count) {
		this.limit_head_count = limit_head_count;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public int getSports_id() {
		return sports_id;
	}

	public void setSports_id(int sports_id) {
		this.sports_id = sports_id;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	@Override
	public String toString() {
		return "Match [match_id=" + match_id + ", title=" + title + ", content=" + content + ", start_date="
				+ start_date + ", curr_head_count=" + curr_head_count + ", limit_head_count=" + limit_head_count
				+ ", address=" + address + ", location=" + location + ", latitude=" + latitude + ", longitude="
				+ longitude + ", sports_id=" + sports_id + ", sport=" + sport + "]";
	}
}
