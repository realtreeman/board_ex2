package me.realtree.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import me.realtree.model.Criteria;
import me.realtree.model.ReplyVO;

public interface ReplyMapper {
	List<ReplyVO> getListAll();
	
	List<ReplyVO> getListWithPaging(
			@Param("cri") Criteria criteria, @Param("bno") Long bno);
	int insert(ReplyVO vo);
	ReplyVO read(Long rno);
	int delete(Long rno);
	int update(ReplyVO vo);
	
}
