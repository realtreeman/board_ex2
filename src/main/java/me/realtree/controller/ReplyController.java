package me.realtree.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import me.realtree.model.ReplyVO;
import me.realtree.service.ReplyService;

@RestController
@RequestMapping("/replies")
@AllArgsConstructor
public class ReplyController {
	
	private ReplyService service;
	
	@PostMapping(value= "new",
			consumes = "application/json",
			produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		int insertCount = service.register(vo);
		return insertCount == 1 ?
				new ResponseEntity<>("success",HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
