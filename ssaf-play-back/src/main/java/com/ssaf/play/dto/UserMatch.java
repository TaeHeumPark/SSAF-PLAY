package com.ssaf.play.dto;

public class UserMatch {

	private int user_match_id; // 기본 id
	private int user_id; // 매칭 되는 유저 id
	private int match_id; // 매칭 되는 경기 id
	private int match_positions; // 매칭 되는 경기의 position	
	private int team; // 1팀인지 2팀인지
	private int team_idx;
	
	// 출력을 위한
	private String name;
	private String profile_img;
	private int match_count;
	private String record;
	private String position_name;
	private String grade_name;
	// match_positions
	// team
	// 두 개는 위에 있음.
	
	public UserMatch() {
		// TODO Auto-generated constructor stub
	}

	public UserMatch(int user_match_id, int user_id, int match_id, int match_positions, int team, int team_idx) {
		super();
		this.user_match_id = user_match_id;
		this.user_id = user_id;
		this.match_id = match_id;
		this.match_positions = match_positions;
		this.team = team;
		this.team_idx = team_idx;
	}
	
	

	public UserMatch(int match_positions, int team, String name, String profile_img, int match_count, String record,
			String position_name, String grade_name) {
		super();
		this.match_positions = match_positions;
		this.team = team;
		this.name = name;
		this.profile_img = profile_img;
		this.match_count = match_count;
		this.record = record;
		this.position_name = position_name;
		this.grade_name = grade_name;
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
	
	// ---

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfile_img() {
		return profile_img;
	}

	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}

	public int getMatch_count() {
		return match_count;
	}

	public void setMatch_count(int match_count) {
		this.match_count = match_count;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public String getPosition_name() {
		return position_name;
	}

	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}

	public String getGrade_name() {
		return grade_name;
	}

	public void setGrade_name(String grade_name) {
		this.grade_name = grade_name;
	}

		
	public int getTeam_idx() {
		return team_idx;
	}

	public void setTeam_idx(int team_idx) {
		this.team_idx = team_idx;
	}

	@Override
	public String toString() {
		return "UserMatch [user_match_id=" + user_match_id + ", user_id=" + user_id + ", match_id=" + match_id
				+ ", match_positions=" + match_positions + ", team=" + team + ", name=" + name + ", profile_img="
				+ profile_img + ", match_count=" + match_count + ", record=" + record + ", position_name="
				+ position_name + ", grade_name=" + grade_name + "]";
	}
}
