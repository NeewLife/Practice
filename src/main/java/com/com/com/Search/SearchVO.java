package com.com.com.Search;

import lombok.Data;

@Data
public class SearchVO {
	
	private String keyword;			// 검색 키워드
	private String searchType;		// 검색 유형
	
	private String startDate;		// 시작 날짜
	private String endDate;			// 끝 날짜
	
	private int pageNum;			// 현재 페이지
	private int amount;				// 한 페이지당 보여질 게시물 갯수
	private int pageSize;			// 하단의 페이지 갯수
	
	private Pagination pagination;	// 페이지 정보
	
	public SearchVO() {
		this.pageNum = 1;
		this.amount = 10;
		this.pageSize = 10;
	}
}
