package com.ssaf.play.dto;

public class UserMatch {

	private int user_match_id; // 기본 id
	private int user_id; // 매칭 되는 유저 id
	private int match_id; // 매칭 되는 경기 id
	private int match_positions; // 매칭 되는 경기의 position	
	private int team; // 1팀인지 2팀인지
	
	public UserMatch() {
		// TODO Auto-generated constructor stub
	}

	public UserMatch(int user_match_id, int user_id, int match_id, int match_positions, int team) {
		super();
		this.user_match_id = user_match_id;
		this.user_id = user_id;
		this.match_id = match_id;
		this.match_positions = match_positions;
		this.team = team;
	}

	public int getUser_match_id() {
		return user_match_id;
	}

	public void setUser_match_id(int user_match_id) {
		this.user_match_id = user_match_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getMatch_id() {
		return match_id;
	}

	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}

	public int getMatch_positions() {
		return match_positions;
	}

	public void setMatch_positions(int match_positions) {
		this.match_positions = match_positions;
	}

	public int getTeam() {
		return team;
	}

	public void setTeam(int team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "UserMatch [user_match_id=" + user_match_id + ", user_id=" + user_id + ", match_id=" + match_id
				+ ", match_positions=" + match_positions + ", team=" + team + "]";
	}
}
