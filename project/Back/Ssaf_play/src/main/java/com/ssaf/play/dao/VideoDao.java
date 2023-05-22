package com.ssaf.play.dao;

import java.util.List;

import com.ssaf.play.dto.Video;

public interface VideoDao {
	
	public int regist(Video video);
	
	// 조회수별 비디오 담기
	public List<Video> selectSprotsVideo(int sports);
	
	// 비디오 디테일
	public Video detailVideo(int video_no);

	// 비디오 조회수 증가
	public void videoUpdateViewCnt(int video_no);
}
