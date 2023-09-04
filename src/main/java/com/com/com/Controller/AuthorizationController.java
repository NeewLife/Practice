package com.com.com.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.com.com.Authorization.Service.AuthorizationService;
import com.com.com.Authorization.VO.BoardRequest;
import com.com.com.Authorization.VO.BoardResponse;
import com.com.com.Authorization.VO.MemberVO;
import com.com.com.Authorization.VO.SearchVO;


@Controller
public class AuthorizationController {

	@Autowired
	public AuthorizationService authorizationService;
	  
	@Resource(name = "sqlSessionTemplate")
	public SqlSessionTemplate sqlSession;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) {
		session.invalidate();
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
			
		int id = authorizationService.login(paramMap);
	
		HashMap<String, Object> result = new HashMap <String,Object>();
		
		result.put("message", "등록되지 않은 사용자입니다.");
		if (id != 0) {
			MemberVO memberVO = authorizationService.user(id);
			if (memberVO.getUserPw().equals(loginPw)) {
				System.out.println("로그인 성공");
				result.put("user", memberVO);
				result.replace("message", "로그인 성공");
				session.setAttribute("memberVO", memberVO);
				return result;
			}else if(memberVO.getUserId() == null){
				System.out.println("없는 유저입니다");
			}
			else {
				System.out.println("비밀번호가 다름");
				result.replace("message", "비밀번호가 일치하지 않습니다");
				return result;
			}
		}
		return result;
		
	}
	
	@RequestMapping(value = "/post")
	public String post(Model model, HttpServletRequest request , HttpServletResponse response
					 , SearchVO searchVO) {
		HttpSession session = request.getSession(false);
		MemberVO sessionData = (MemberVO) session.getAttribute("memberVO");
		if(sessionData == null) { 
			return "redirect:/"; 
		}
		int id = sessionData.getId();
		System.out.println("세션으로 넘어온 데이터 = " + id);
		MemberVO memberVO = authorizationService.user(id);
		System.out.println("memberVO = " + memberVO);
		
		session.setAttribute("session", memberVO);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("userRank", sessionData.getUserRank());
		params.put("userName", sessionData.getUserName());
		params.put("searchType", searchVO.getSearchType());
		params.put("keyword", searchVO.getKeyword());
		params.put("authType", searchVO.getAuthType());
		params.put("startDate", searchVO.getStartDate());
		params.put("endDate", searchVO.getEndDate());
		System.out.println("params 값 = " + params);
		
		List<BoardResponse> list = authorizationService.list(params);
		model.addAttribute("user", memberVO);
		model.addAttribute("list", list);
		System.out.println("==================================");
		return "post";
	}
	
	@RequestMapping(value = "/search")
	@ResponseBody
	public List<BoardResponse> search(Model model, HttpServletRequest request , HttpServletResponse response
					   , SearchVO searchVO) {
		HttpSession session = request.getSession();
		MemberVO sessionData = (MemberVO) session.getAttribute("memberVO");
		int id = sessionData.getId();
		System.out.println("세션으로 넘어온 데이터 = " + id);
		MemberVO memberVO = authorizationService.user(id);
		System.out.println("memberVO = " + memberVO);
		
		session.setAttribute("session", memberVO);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("userRank", sessionData.getUserRank());
		params.put("userName", sessionData.getUserName());
		params.put("searchType", searchVO.getSearchType());
		params.put("keyword", searchVO.getKeyword());
		params.put("authType", searchVO.getAuthType());
		params.put("startDate", searchVO.getStartDate());
		params.put("endDate", searchVO.getEndDate());
		System.out.println("params 값 = " + params);
		
		List<BoardResponse> list = authorizationService.list(params);
		System.out.println("==================================");
		return list;
		
	}
	
	@RequestMapping(value = "/write")
	public String write(@RequestParam(
						value = "postId"
						, required = false, defaultValue = "0") int postId
						, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if(session == null) {
			return "/";
		}
		System.out.println("== /write 로 넘어온 postId = " + postId);
		int lastSeq = authorizationService.lastSeq();
		model.addAttribute("lastSeq",lastSeq);
		if(postId != 0) {
			System.out.println("postId 있음! postId = " + postId);
			BoardResponse post = authorizationService.view(postId);
			model.addAttribute("post", post);
		}
		System.out.println("==================================");
		return "write";
	}
	
	@RequestMapping(value = "/save")
	public String save(BoardRequest boardRequest, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session == null) {
			return "/";
		}
		MemberVO sessionData = (MemberVO) session.getAttribute("memberVO");
		int writerPkNum = sessionData.getId();
		boardRequest.setWriterPkNum(writerPkNum);
		authorizationService.save(boardRequest);
		return "redirect:/post";
	}
	
	@RequestMapping(value = "/update")
	public String update(BoardRequest boardRequest, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session == null) {
			return "/";
		}
		MemberVO sessionData = (MemberVO) session.getAttribute("memberVO");
		int writerPkNum = sessionData.getId();
		boardRequest.setWriterPkNum(writerPkNum);
		authorizationService.update(boardRequest);
		
		return "redirect:/post";
	}
	
	@RequestMapping(value = "/reject")
	public String reject(@RequestParam int postId, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session == null) {
			return "/";
		}
		MemberVO sessionData = (MemberVO) session.getAttribute("memberVO");
		String userName = sessionData.getUserName();
		Map<String, Object> params = new HashMap<String, Object>();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String nowTime = sdf1.format(now);
		params.put("confirmDate", nowTime);
		params.put("postId",postId);
		params.put("confirmPerson", userName);
		params.put("confirmStatus", '5');
		System.out.println("reject 에서 params 로 넘어온 데이터" + params);
		authorizationService.reject(params);
		authorizationService.creHistory(params);
		return "redirect:/post";
	}
	
	@RequestMapping(value = "/confirm")
	public String confirm(@RequestParam int postId, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session == null) {
			return "/";
		}
		MemberVO sessionData = (MemberVO) session.getAttribute("memberVO");
		String userRank = sessionData.getUserRank();
		String userName = sessionData.getUserName();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("postId",postId);
		params.put("confirmPerson", userName);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String nowTime = sdf1.format(now);
		params.put("confirmDate", nowTime);
		
		if(userRank.equals("과장")) {
			System.out.println("== userRank = 과장");
			params.put("confirmStatus", 3);
		}
		else if(userRank.equals("부장")) {
			System.out.println("== userRank = 부장");
			params.put("confirmStatus", 4);
		}
		else {
			System.out.println("잘못된 접근입니다.");
			return "redirect:/post";
		}
		authorizationService.confirm(params);
		authorizationService.creHistory(params);
		return "redirect:/post";
	}
	
	@RequestMapping(value = "/view")
	public String view(@RequestParam int postId, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if(session == null) {
			return "/";
		}
		System.out.println("view 에서 session = " + session.getAttribute("session"));
		System.out.println("넘어온 postId = " + postId);
		MemberVO sessionData = (MemberVO) session.getAttribute("memberVO");
		int id = sessionData.getId();
		BoardResponse post = authorizationService.view(postId);
		if(post.getConfirmStatus() == 1 && post.getWriterPkNum() == id) {
			model.addAttribute("post", post);
			return "write";
		}
		List<Map<String, Object>> postHistory = authorizationService.history(postId);
		model.addAttribute("post", post);
		model.addAttribute("history", postHistory);
		System.out.println("==================================");
		return "view";
	}
}
