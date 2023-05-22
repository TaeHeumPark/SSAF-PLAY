package com.ssaf.play.dto;

/**
 * @author xogma
 *
 */
public class Video {
	
	private int video_no;
	private String id;
	private String title;
	private String date;
	private int view_cnt;
	private int sports;
	private String sport;
	
	public Video() {
		// TODO Auto-generated constructor stub
	}

	public Video(int video_no, String id, String title, String date, int view_cnt, int sports, String sport) {
		super();
		this.video_no = video_no;
		this.id = id;
		this.title = title;
		this.date = date;
		this.view_cnt = view_cnt;
		this.sports = sports;
		this.sport = sport;
	}

	public int getVideo_no() {
		return video_no;
	}

	public void setVideo_no(int video_no) {
		this.video_no = video_no;
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

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	@Override
	public String toString() {
		return "Video [video_no=" + video_no + ", id=" + id + ", title=" + title + ", date=" + date + ", view_cnt="
				+ view_cnt + ", sports=" + sports + ", sport=" + sport + "]";
	}
}
