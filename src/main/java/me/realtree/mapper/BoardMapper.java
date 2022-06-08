package me.realtree.mapper;

import java.util.List;

import me.realtree.model.Board;

public interface BoardMapper {
	List<Board> getList();
	Board get(Long bno);
	void insert(Board board);
	void update(Board board);
	void delete(Long bno);
}
