package com.ssaf.play.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssaf.play.dto.User;
import com.ssaf.play.dto.Video;
import com.ssaf.play.service.VideoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api-video/")
public class VideoController {

	@Autowired
	private VideoService vservice;

	// 비디오 등록
	@PostMapping("regist")
	public ResponseEntity<?> regist(@RequestBody Video video) {
		// 넘어올 데이터 - id(youtubeId), sports(1 - 축구, 2 - 농구)
		if(video.getSport().equals("축구")) {
			video.setSports(1);
		} else {
			video.setSports(2);
		}
		
		vservice.regist(video);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 비디오 불러오기 (스포츠별로)
	@GetMapping("{sport}")
	public ResponseEntity<?> partvideo(@PathVariable String sport) {
		
		// 넘어오는 값이 축구면 1, 아니면 2
		int sports = 0;
		if(sport.equals("축구")) {
			 sports = 1;
		}
		else {
			sports = 2;
		}
		
		List<Video> list = vservice.selectSprotsVideo(sports);
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
	}

	@GetMapping("detail/{video_no}")
	public ResponseEntity<?> detailVideo(@PathVariable int video_no) {
		Video video = vservice.detailVideo(video_no);
		// 넘어온 비디오가 띄울 수 없는 비디오면(videoId로 검사)
		if (video.getId() == null) {
			// NO_CONTENT
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		// videoId를 받아 왔으면 video 넘겨주기
		return new ResponseEntity<Video>(video, HttpStatus.OK);
	}

}