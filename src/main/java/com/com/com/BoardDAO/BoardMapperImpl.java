package com.com.com.BoardDAO;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.com.com.BoardVO.BoardRequest;
import com.com.com.BoardVO.BoardResponse;
import com.com.com.Paging.Pagination;
import com.com.com.Search.SearchVO;


@Repository("dao")
public class BoardMapperImpl implements BoardMapper{

	@Inject
	public SqlSessionTemplate sqlSession;

	@Override
	public List<BoardResponse> getList(SearchVO params) {
		System.out.println("매퍼까지 넘어온 데이터" + params.toString());
		return sqlSession.selectList("mapper.list", params);
	}

	@Override
	public void save(BoardRequest params) {
		sqlSession.insert("save", params);
	}
	
	@Override
	public int update(BoardRequest params) {
		return sqlSession.update("update", params);
	}
	
	@Override
	public void delete(int seq) {
		sqlSession.delete("delete", seq);	
	}

	@Override
	public BoardResponse getView(int seq) {
		System.out.println("getView DAO 실행, 받아온 seq = " + seq);
		return sqlSession.selectOne("mapper.view", seq);
	}

	@Override
	public List<Map<String, Object>> getListPaging(Pagination idx) {
		return sqlSession.selectList("mapper.getListPaging");
	}
}
