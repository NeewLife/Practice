package com.com.com.BoardService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.com.com.BoardDAO.BoardMapper;
import com.com.com.BoardVO.BoardRequest;
import com.com.com.BoardVO.BoardResponse;
import com.com.com.Search.SearchVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardResponse> getList(SearchVO params){
		System.out.println("서비스까지 넘어온 데이터" + params.toString());
//		String startDate = params.getStartDate();
//		String endDate = params.getEndDate();
//		
//		if (params.getStartDate() == "") {
//			System.out.println("시작 날짜 비어있음");
//			params.setStartDate();
//		}
//		if (params.getEndDate() == "") {
//			System.out.println("끝 날짜 비어있음");
//			params.setEndDate("99991231");
//		}
		return boardMapper.getList(params);
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
