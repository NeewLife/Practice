package com.com.com.Authorization.Service;

import java.util.Map;

import com.com.com.Authorization.VO.MemberVO;

public interface AuthorizationService {
	public MemberVO login(Map<String, Object> params);
}
