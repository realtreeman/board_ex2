package me.realtree.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import me.realtree.model.Criteria;
import me.realtree.model.ReplyVO;
import me.realtree.service.ReplyService;

@RestController
@RequestMapping("/replies")
@AllArgsConstructor
public class ReplyController {
	
	private ReplyService service;
	
	@PostMapping(value= "new",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		int insertCount = service.register(vo);
		return insertCount == 1 
				? new ResponseEntity<>("success",HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "/pages/{bno}/{page}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ReplyVO>> getList(
			@PathVariable int page, 
			@PathVariable Long bno){
		Criteria criteria = new Criteria(page,10);
		
		return new ResponseEntity<>(service.getListWithPaging(criteria, bno),HttpStatus.OK);
	}
	
	@GetMapping(value = "/{rno}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ReplyVO> get(@PathVariable Long rno){
		return new ResponseEntity<ReplyVO>(service.get(rno),HttpStatus.OK);
	}
	//@PathVariable주소로 사용할때
	//삭제성공할때 1이 나옴 
	//예외처리 하고 싶을때 if문으로 바꾸면 가능
	//리턴값을 보고 MediaType 결정 하면 댐
	@DeleteMapping(value="/{rno}",produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> remove(@PathVariable Long rno){
		return service.remove(rno) == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping(value = "/{rno}")
	public ResponseEntity<String> modify(
			@RequestBody ReplyVO vo,@PathVariable Long rno){
		vo.setRno(rno);
		return service.modify(vo) == 1 
				? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
	
	
}
