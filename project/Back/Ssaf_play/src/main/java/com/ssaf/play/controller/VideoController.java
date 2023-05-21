package com.ssaf.play.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssaf.play.dto.Video;
import com.ssaf.play.service.VideoService;

@RestController
@RequestMapping("/api-video/main/")
public class VideoController {
	
	@Autowired
	private VideoService vservice;
	
	@GetMapping("{part}")
	public ResponseEntity<?> partvideo(@PathVariable String part){
		List<Video> list=vservice.selectPartFitVideo(part);
		if(list==null || list.size()==0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
	}
	
	@GetMapping("")
	public ResponseEntity<?> showvideos(HttpSession session){
		List<Video> list=vservice.selectInterestViewFitVideo();
		session.removeAttribute("youtubeId");
		if(list==null || list.size()==0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
	}
	
	
}