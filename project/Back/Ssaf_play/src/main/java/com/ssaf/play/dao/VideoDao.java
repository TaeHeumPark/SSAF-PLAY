package com.ssaf.play.dao;

import java.util.List;

import com.ssaf.play.dto.Video;

public interface VideoDao {
	// 조회수별 비디오 담기
	public List<Video> selectInterestViewFitVideo();

	// 운동 부위별 비디오 담기
	public List<Video> selectPartFitVideo(String part);

	// 비디오 조회수 증가
	public void videoUpdateViewCnt(String resId);
}
