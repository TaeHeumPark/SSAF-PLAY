package com.ssaf.play.dto;

public class User {
    private int user_id;
    private String email;
    private String password;
    private String name;
    private String phone_number;
    private Object profile_img;
    private String birth_date;
    private String reg_date;
    private int gender_id;
    private String gender_name;
    private int manner_score;
    private int match_count;
    private String record;
    private int grade_id;
    private String grade_name;
    private int preferred_position;
    private String preferred_position_name;
    
    // 추가됨 ㅠ
    private String file_name;
    
    
    public User() {
        // TODO Auto-generated constructor stub
    }


    public User(int user_id, String email, String password, String name, String phone_number, Object profile_img,
            String birth_date, String reg_date, int gender_id, String gender_name, int manner_score, int match_count,
            String record, int grade_id, String grade_name, int preferred_position, String preferred_position_name,
            String file_name) {
        super();
        this.user_id = user_id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone_number = phone_number;
        this.profile_img = profile_img;
        this.birth_date = birth_date;
        this.reg_date = reg_date;
        this.gender_id = gender_id;
        this.gender_name = gender_name;
        this.manner_score = manner_score;
        this.match_count = match_count;
        this.record = record;
        this.grade_id = grade_id;
        this.grade_name = grade_name;
        this.preferred_position = preferred_position;
        this.preferred_position_name = preferred_position_name;
        this.file_name = file_name;
    }


    public int getUser_id() {
        return user_id;
    }


    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getPhone_number() {
        return phone_number;
    }


    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }


    public Object getProfile_img() {
        return profile_img;
    }


    public void setProfile_img(Object profile_img) {
        this.profile_img = profile_img;
    }


    public String getBirth_date() {
        return birth_date;
    }


    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }


    public String getReg_date() {
        return reg_date;
    }


    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }


    public int getGender_id() {
        return gender_id;
    }


    public void setGender_id(int gender_id) {
        this.gender_id = gender_id;
    }


    public String getGender_name() {
        return gender_name;
    }


    public void setGender_name(String gender_name) {
        this.gender_name = gender_name;
    }


    public int getManner_score() {
        return manner_score;
    }


    public void setManner_score(int manner_score) {
        this.manner_score = manner_score;
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


    public int getGrade_id() {
        return grade_id;
    }


    public void setGrade_id(int grade_id) {
        this.grade_id = grade_id;
    }


    public String getGrade_name() {
        return grade_name;
    }


    public void setGrade_name(String grade_name) {
        this.grade_name = grade_name;
    }


    public int getPreferred_position() {
        return preferred_position;
    }


    public void setPreferred_position(int preferred_position) {
        this.preferred_position = preferred_position;
    }


    public String getPreferred_position_name() {
        return preferred_position_name;
    }


    public void setPreferred_position_name(String preferred_position_name) {
        this.preferred_position_name = preferred_position_name;
    }


    public String getFile_name() {
        return file_name;
    }


    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }


    @Override
    public String toString() {
        return "User [user_id=" + user_id + ", email=" + email + ", password=" + password + ", name=" + name
                + ", phone_number=" + phone_number + ", profile_img=" + profile_img + ", birth_date=" + birth_date
                + ", reg_date=" + reg_date + ", gender_id=" + gender_id + ", gender_name=" + gender_name
                + ", manner_score=" + manner_score + ", match_count=" + match_count + ", record=" + record
                + ", grade_id=" + grade_id + ", grade_name=" + grade_name + ", preferred_position=" + preferred_position
                + ", preferred_position_name=" + preferred_position_name + ", file_name=" + file_name + "]";
    }

    

    
}
