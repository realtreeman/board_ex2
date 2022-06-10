package me.realtree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.realtree.mapper.BoardMapper;
import me.realtree.model.Board;
import me.realtree.model.Criteria;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<Board> getList(Criteria criteria) {
		return boardMapper.getList(criteria);
	}

	@Override
	public Board get(Long bno) {
		return boardMapper.get(bno);
	}

	@Override
	public void register(Board board) {
		boardMapper.insert(board);
	}

	@Override
	public void modify(Board board) {
		boardMapper.update(board);
	}

	@Override
	public void remove(Long bno) {
		boardMapper.delete(bno);
	}

	@Override
	public int totalCount(Criteria criteria) {
		return boardMapper.totalCount(criteria);
	}

}
