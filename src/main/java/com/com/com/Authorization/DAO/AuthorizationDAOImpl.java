package com.com.com.Authorization.DAO;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.com.com.Authorization.VO.MemberVO;


@Repository("authorizationDAO")
public class AuthorizationDAOImpl implements AuthorizationDAO{

	@Inject
	SqlSession sqlSession;
	
	@Override
	public MemberVO login(Map<String, Object> params) {
		MemberVO result = sqlSession.selectOne("mapper.login", params);
		System.out.println("DTO result = " + result);
		return result;
	}
}
