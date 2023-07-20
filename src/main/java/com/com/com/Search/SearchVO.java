package com.com.com.Search;

import lombok.Data;

@Data
public class SearchVO {
	
	private String keyword;			// 검색 키워드
	private String searchType;		// 검색 유형
	
	private String startDate;		// 시작 날짜
	private String endDate;			// 끝 날짜
	
}
