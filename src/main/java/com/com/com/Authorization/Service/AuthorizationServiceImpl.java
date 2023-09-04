package com.com.com.Authorization.Service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.com.com.Authorization.DAO.AuthorizationDAO;
import com.com.com.Authorization.VO.BoardRequest;
import com.com.com.Authorization.VO.BoardResponse;
import com.com.com.Authorization.VO.MemberVO;


@Repository("authorizationService")
public class AuthorizationServiceImpl implements AuthorizationService{

	@Inject
	AuthorizationDAO authorizationDAO;
	
	@Override
	public int login(Map<String, Object> params) {
		return authorizationDAO.login(params);
	};
	
	@Override
	public MemberVO user(int id) {
		return authorizationDAO.user(id);
	}
	
	@Override
	public List<BoardResponse> list(Map<String, Object> params) {
		List<BoardResponse> list = authorizationDAO.list(params);
		System.out.println("list 목록 = " + list.get(0));
		if(list.get(0) == null) {
			System.out.println("list가 비어있습니다");
		}
		return authorizationDAO.list(params);
	}
	
	@Override
	public BoardResponse view(int postId) {
		System.out.println("Service postId 전달");
		return authorizationDAO.view(postId);
	}

	@Override
	public List<Map<String, Object>> history(int postId) {
		return authorizationDAO.history(postId);
	}

	@Override
	public int lastSeq() {
		return authorizationDAO.lastSeq();
	}

	@Override
	public void save(BoardRequest params) {
		authorizationDAO.save(params);
	}
	
	@Override
	public void update(BoardRequest params) {
		authorizationDAO.update(params);
	}


	@Override
	public void reject(Map<String, Object> params) {
		authorizationDAO.reject(params);
	}

	@Override
	public void confirm(Map<String, Object> params) {
		authorizationDAO.confirm(params);
	}

	@Override
	public void creHistory(Map<String, Object> params) {
		authorizationDAO.creHistory(params);
	}

	
	
}
