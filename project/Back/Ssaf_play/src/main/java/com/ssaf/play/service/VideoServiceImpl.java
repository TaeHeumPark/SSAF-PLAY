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
	public int regist(Video video) {
		return dao.regist(video);
	}

	@Override
	public List<Video> selectSprotsVideo(int sports) {
		return dao.selectSprotsVideo(sports);
	}


}
