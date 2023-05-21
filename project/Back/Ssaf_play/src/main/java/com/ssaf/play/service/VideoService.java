package com.ssaf.play.service;

import java.util.List;

import com.ssaf.play.dto.Video;

public interface VideoService {
	// 조회수별 비디오 담기
	public List<Video> selectInterestViewFitVideo();

	// 운동 부위별 비디오 담기
	public List<Video> selectPartFitVideo(String part);

}
