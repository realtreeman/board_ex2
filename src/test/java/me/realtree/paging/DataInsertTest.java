package me.realtree.paging;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.realtree.AppTest;
import me.realtree.mapper.BoardMapper;
import me.realtree.model.Board;

public class DataInsertTest extends AppTest{

	@Autowired
	BoardMapper mapper;
	
	@Test
	public void dataInsert() {
		
		for (int i = 1; i <= 412; i++) {
			Board board = new Board();
			board.setTitle("페이징 처리 연습" + i);
			board.setContent("내용 페이징 처리 연습" + i);
			board.setWriter("작성자");
			mapper.insert(board);
			
		}
		
	}
}
