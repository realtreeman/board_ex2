package me.realtree.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import me.realtree.model.Criteria;
import me.realtree.model.ReplyVO;

public interface ReplyService {
	List<ReplyVO> getListWithPaging(Criteria criteria, Long bno);
	int register(ReplyVO vo);
	ReplyVO get(Long rno);
	int remove(Long rno);
	int modify(ReplyVO vo);
	
}
