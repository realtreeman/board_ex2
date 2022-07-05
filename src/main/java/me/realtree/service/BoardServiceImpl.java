package me.realtree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.realtree.mapper.BoardAttachMapper;
import me.realtree.mapper.BoardMapper;
import me.realtree.model.Board;
import me.realtree.model.BoardAttachVO;
import me.realtree.model.Criteria;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private BoardAttachMapper attachMapper;
	
	@Override
	public List<Board> getList(Criteria criteria) {
		return boardMapper.getList(criteria);
	}

	@Override
	public Board get(Long bno) {
		return boardMapper.get(bno);
	}

	@Transactional
	@Override
	public void register(Board board) {
		boardMapper.insert(board);
		if(board.getAttachList()==null || board.getAttachList().size()==0) return;
		board.getAttachList().forEach(attach -> {
			attach.setBno(board.getBno());
			attachMapper.insert(attach);
		});
	}

	@Transactional
	@Override
	public void modify(Board board) {
		attachMapper.deleteAll(board.getBno());
		boardMapper.update(board);
		if(board.getAttachList()!=null) {
			
			board.getAttachList().forEach(attach->{
				attach.setBno(board.getBno());
				attachMapper.insert(attach);
			});
		}
	}

	@Transactional
	@Override
	public void remove(Long bno) {
		attachMapper.deleteAll(bno);
		boardMapper.delete(bno);
	}

	@Override
	public int totalCount(Criteria criteria) {
		return boardMapper.totalCount(criteria);
	}
	
	@Override
	public List<BoardAttachVO> getAttachListVO(Long bno) {
		return attachMapper.findByBno(bno);
	}

}
