package com.com.com.Authorization.DAO;

import java.util.Map;

import com.com.com.Authorization.VO.MemberVO;

public interface AuthorizationDAO {
	public MemberVO login(Map<String, Object> params);
}
