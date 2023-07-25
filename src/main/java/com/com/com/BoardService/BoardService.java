package com.com.com.BoardService;

import java.util.List;
import java.util.Map;

import com.com.com.BoardVO.BoardRequest;
import com.com.com.BoardVO.BoardResponse;
import com.com.com.Search.SearchVO;

public interface BoardService {

	public List<BoardResponse> getList(SearchVO params);
	
	public int count();
	
	public void save(BoardRequest params);
	
	public int update(BoardRequest params);
	
	public void delete(int seq);
	
	public BoardResponse getView(int seq);
}
