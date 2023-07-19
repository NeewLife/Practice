package com.com.com.Paging;

import lombok.Data;

@Data
public class Pagination {
	// 현재 페이지
	private int pageNum;
	
	// 한 페이지당 보여질 게시물 갯수
	private int amount;
	
	// 검색 키워드
	private String keyword; 
	
	// 기본 생성자 세팅
	public Pagination() {
		this(1, 10);
	}
	
	// 생성자 -> 원하는 pageNum, 원하는 amount
	public Pagination(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

}
