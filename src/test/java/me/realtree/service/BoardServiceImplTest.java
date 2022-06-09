package me.realtree.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.realtree.AppTest;
import me.realtree.model.Board;

public class BoardServiceImplTest extends AppTest{

	@Autowired
	BoardService service;
	
//	@Test
//	public void getListTest() {
//		List<Board> list = service.getList();
//		assertEquals(4, list.size());
//	}

}
