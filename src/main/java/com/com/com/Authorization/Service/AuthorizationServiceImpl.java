package com.com.com.Authorization.Service;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.com.com.Authorization.DAO.AuthorizationDAO;
import com.com.com.Authorization.VO.MemberVO;


@Repository("authorizationService")
public class AuthorizationServiceImpl implements AuthorizationService{

	@Inject
	AuthorizationDAO authorizationDAO;
	
	@Override
	public MemberVO login(Map<String, Object> params) {
		MemberVO result = authorizationDAO.login(params);
		System.out.println("Service 에서 넘어온 값 = " + result);
		return result;
	};
}
