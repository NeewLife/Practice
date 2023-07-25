package com.com.com.Search;

import lombok.Data;

@Data
public class Pagination {
	
	private int startPage;				// 시작 페이지
	private int endPage;				// 끝 페이지
	private boolean isExistPrevPage;	// 이전 페이지 존재 여부
	private boolean isExistNextPage;	// 다음 페이지 존재 여부
	private int totalRecordCount;		// 전체 데이터 수
	private int totalPageCount;			// 전체 페이지 수
	
	public Pagination(int totalRecordCount, SearchVO params) {
		if(totalRecordCount > 0) {
			this.totalRecordCount =totalRecordCount;
			this.calculation(params);
		}
	}
	
	public void calculation(SearchVO params) {
		totalPageCount = (totalRecordCount - 1) / params.getAmount() + 1;
		
		if (params.getPageNum() > totalPageCount) {
			params.setPageNum(totalPageCount);
		}
		
		startPage = (params.getPageNum() - 1) / params.getPageSize() * params.getPageSize() + 1;
		endPage = startPage + params.getPageSize() - 1;
		
		if (endPage > totalPageCount) {
			endPage = totalPageCount;
		}
		
		isExistPrevPage = startPage != 1;
		isExistNextPage = (endPage * params.getAmount()) < totalRecordCount;
	}
}
