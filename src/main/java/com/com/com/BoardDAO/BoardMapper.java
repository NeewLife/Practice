package com.com.com.BoardDAO;

import java.util.List;
import java.util.Map;

import com.com.com.BoardVO.BoardRequest;
import com.com.com.BoardVO.BoardResponse;
import com.com.com.Search.Pagination;
import com.com.com.Search.SearchVO;

public interface BoardMapper {

	public List<BoardResponse> getList(SearchVO params);
	
	public List<Map<String, Object>> getListTest(Map<String, Object> params);
	
	public int count();
	
	public int nextSeq();
	
	public List<Map<String, Object>> getListPaging(Pagination idx);
	
	public void save(BoardRequest params);

	public int update(BoardRequest params);
	
	public void delete(int seq);
	
	public BoardResponse getView(int seq);
}
