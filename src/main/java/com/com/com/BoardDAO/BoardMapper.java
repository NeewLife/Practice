package com.com.com.BoardDAO;

import java.util.List;
import java.util.Map;

import com.com.com.BoardVO.BoardRequest;
import com.com.com.BoardVO.BoardResponse;
import com.com.com.Paging.Pagination;
import com.com.com.Search.SearchDTO;

public interface BoardMapper {

	public List<BoardResponse> getList(SearchDTO params);
	
	public List<Map<String, Object>> getListPaging(Pagination idx);
	
	public void save(BoardRequest params);

	public int update(BoardRequest params);
	
	public void delete(int seq);
	
	public BoardResponse getView(int seq);
}
