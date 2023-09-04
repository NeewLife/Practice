package com.com.com.Authorization.Service;

import java.util.List;
import java.util.Map;

import com.com.com.Authorization.VO.BoardRequest;
import com.com.com.Authorization.VO.BoardResponse;
import com.com.com.Authorization.VO.MemberVO;

public interface AuthorizationService {
	public int login(Map<String, Object> params);
	
	public MemberVO user(int id);

	public List<BoardResponse> list(Map<String, Object> params);

	public BoardResponse view(int postId);

	public List<Map<String, Object>> history(int postId);
	
	public void save(BoardRequest params);
	
	public void update(BoardRequest params);
	
	public void reject(Map<String, Object> params);
	
	public void confirm(Map<String, Object> params);
	
	public void creHistory(Map<String, Object> params);
	
	public int lastSeq();
}
