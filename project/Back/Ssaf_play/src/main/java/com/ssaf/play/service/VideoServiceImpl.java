package com.ssaf.play.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssaf.play.dao.VideoDao;
import com.ssaf.play.dto.Video;

@Service
public class VideoServiceImpl implements VideoService {
	
	@Autowired
	VideoDao dao;
	
	// 비디오 등록
	@Override
	public int regist(Video video) {
		return dao.regist(video);
	}

	// 비디오 리스트 불러오기(sports가 1이면 축구 영상만, 2면 농구 영상만)
	@Override
	public List<Video> selectSprotsVideo(int sports) {
		return dao.selectSprotsVideo(sports);
	}

	// 비디오 클릭했을 때, 디테일한 정보 보여주기
	@Override
	public Video detailVideo(int video_no) {
		// 조회수 증가도 같이
		dao.videoUpdateViewCnt(video_no);
		return dao.detailVideo(video_no);
	}

}
