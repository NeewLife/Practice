package com.com.com.Controller;

import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.com.com.Authorization.Service.AuthorizationService;
import com.com.com.Authorization.VO.MemberVO;


@Controller
public class AuthorizationController {

	@Autowired
	public AuthorizationService authorizationService;
	
	@Resource(name = "sqlSessionTemplate")
	public SqlSessionTemplate sqlSession;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("login 페이지 실행");
		return "login";
	}
	
	@RequestMapping(value = "/login", produces = "application/json; charset=utf8")
	@ResponseBody
	public HashMap<String, Object> login(@RequestParam String loginId,
						@RequestParam String loginPw,
						HttpSession session, Model model) {
		
		System.out.println("loginId = " + loginId.toString());
		System.out.println("loginPw = " + loginPw.toString());

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("loginId", loginId);
		paramMap.put("loginPw", loginPw);
			
		MemberVO login = authorizationService.login(paramMap);
	
		HashMap<String, Object> result = new HashMap <String,Object>();
		
		result.put("message", "등록되지 않은 사용자입니다.");
		if (login != null) {
			if (login.getUserPw().equals(loginPw)) {
				System.out.println("로그인 성공");
				result.put("user", login);
				result.replace("message", "로그인 성공");
				return result;
			}else {
				System.out.println("비밀번호가 다름");
				result.replace("message", "비밀번호가 일치하지 않습니다");
				return result;
			}
		}
		return result;
		
	}
	
	@RequestMapping(value = "/post")
	public String post(Model model, MemberVO memberVO,HttpServletRequest request , HttpServletResponse response) {
		System.out.println("memberVO = " + memberVO);
		HttpSession session = request.getSession();
		session.setAttribute("session", memberVO);
		model.addAttribute("user", memberVO);
		return "post";
	}
}
