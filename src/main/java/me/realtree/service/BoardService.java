package me.realtree.service;

import java.util.List;

import me.realtree.model.Board;
import me.realtree.model.Criteria;

public interface BoardService {
	List<Board> getList(Criteria criteria);
	Board get(Long bno);
	void register(Board board);
	void modify(Board board);
	void remove(Long bno);
	int totalCount(Criteria criteria);
}
