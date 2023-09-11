package com.ssaf.play.service;

import java.util.List;

import com.ssaf.play.dto.Video;

public interface VideoService {
	
	// 비디오 등록
	public int regist(Video video);
	
	// 스포츠 별 영상 담기
	public List<Video> selectSprotsVideo(int sports);
	
	// 디테일 비디오
	public Video detailVideo(int video_no);

}
