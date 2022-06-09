package me.realtree.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageMaker {
	
	
	private Criteria criteria;
	private int startPage;
	private int endPage;
	private int tempEndPage;
	private int totalCount;
	private int displayPageNum=10;
	
	private boolean prev;
	private boolean next;
	
	
	public PageMaker(Criteria criteria, int totalCount) {
		this.criteria = criteria;
		this.totalCount = totalCount;
		endPage = (int)Math.ceil(criteria.getPage()/(double)displayPageNum) * displayPageNum;
		startPage = endPage - displayPageNum + 1;
		tempEndPage = (int) Math.ceil(totalCount/ (double)criteria.getPerPageNum());
		if(endPage > tempEndPage) endPage = tempEndPage; //엔드 페이지 계산
		
		//endPage < tempEndPage;
		// endPage tempEndPage;
		//[1 ]~ [10] 42 true
		//[11]~[20] 42true
		//endPage[50]<tempEndPage[42]
				
		prev = startPage != 1;
		next = endPage < tempEndPage;
	}
}
