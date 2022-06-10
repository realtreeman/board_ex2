package me.realtree.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	int page;
	int perPageNum;
	
	String type; //제목+내용 , 작성자 
	String keyword;
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
	}
	
	public int getPageStart() {
		
		return (this.page-1)*perPageNum;
	}
	
	//제목 T 내용 C 작성자 W 
	//제목+내용 : TC
	//내용+작성자 : CW
	public String[] getTypeCollection() { //마이바티스에서#{TypeCollection} 이렇게 전달함
		//TC
		//split을 쓸때 타입이 TC면 {T,C} 생산 CW면 {C,W} 생산
		return type !=null ? type.split("") : new String[] {};
	}
}
