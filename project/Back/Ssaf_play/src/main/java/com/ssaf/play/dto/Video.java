package com.ssaf.play.dto;

/**
 * @author xogma
 *
 */
public class Video {
	private String id;
	private String title;
	private String date;
	private int view_cnt;
	private int sports;
	
	public Video() {
		// TODO Auto-generated constructor stub
	}

	public Video(String id, String title, String date, int view_cnt, int sports) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
		this.view_cnt = view_cnt;
		this.sports = sports;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getView_cnt() {
		return view_cnt;
	}

	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}

	public int getSports() {
		return sports;
	}

	public void setSports(int sports) {
		this.sports = sports;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", title=" + title + ", date=" + date + ", view_cnt=" + view_cnt + ", sports="
				+ sports + "]";
	}

	
}
