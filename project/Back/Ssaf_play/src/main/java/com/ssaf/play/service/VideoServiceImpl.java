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

	@Override
	public List<Video> selectInterestViewFitVideo() {
		return dao.selectInterestViewFitVideo();
	}

	@Override
	public List<Video> selectPartFitVideo(String part) {
		return dao.selectPartFitVideo(part);
	}

}
