package com.com.com.BoardService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.com.com.BoardDAO.BoardMapper;
import com.com.com.BoardVO.BoardRequest;
import com.com.com.BoardVO.BoardResponse;
import com.com.com.Search.Pagination;
import com.com.com.Search.SearchVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardResponse> getList(SearchVO params){
		return boardMapper.getList(params);
	}
	
	@Override
	public int count() {
		return boardMapper.count();
	}

	@Override
	public void save(BoardRequest params) {
		boardMapper.save(params);
	}
	
	@Override
	public int update(BoardRequest params) {
		return boardMapper.update(params);
	}
	
	@Override
	public void delete(int seq) {
		boardMapper.delete(seq);
	}

	@Override
	public BoardResponse getView(int seq) {
		System.out.println("getView 서비스 실행, 받아온 seq = " + seq);
		return boardMapper.getView(seq);
	};
}
