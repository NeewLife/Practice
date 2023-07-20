package com.com.com.Controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.com.com.BoardService.BoardService;
import com.com.com.BoardVO.BoardRequest;
import com.com.com.BoardVO.BoardResponse;
import com.com.com.Search.SearchVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	public BoardService boardService;
	
//	전체 페이지 조회
	@RequestMapping(value = "/")
	public String home(@ModelAttribute("params") SearchVO params, Model model) {
		System.out.println("컨트롤러로 넘어온 데이터" + params.toString());
		List<BoardResponse> list = boardService.getList(params);
		model.addAttribute("list", list);
		model.addAttribute("params", params);
		return "home";
	}
	
//	글쓰기 페이지
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String postWrite(Model model) {
		return "write";
	}
	
//	게시글 작성
	@RequestMapping(value = "/post/save", method = RequestMethod.POST)
	public String save(Model model, BoardRequest params) {
		model.addAttribute(params);
		System.out.println("Controller save");
		boardService.save(params);
		System.out.println("글쓰기 완료");
		return "redirect:/";
	}
	
//	게시글 수정
	@RequestMapping(value = "/post/update", method = RequestMethod.POST)
	public String update(@RequestParam int seq, Model model, BoardRequest params) {
		model.addAttribute(params);
		System.out.println("Controller = update");
		int update = boardService.update(params);
		System.out.println(update + " 개 행이 수정되었습니다");
		boardService.update(params);
		System.out.println("글 수정 완료");
		return "redirect:/";
	}
	
//	게시글 삭제
	@RequestMapping(value = "/post/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("delSeq") int seq) {
		System.out.println("Controller = delete");
		System.out.println("넘어온 SEQ 데이터 = " + seq);
		boardService.delete(seq);
		System.out.println("글 삭제 완료");
		return "redirect:/";
	}
	
//	게시글 상세 조회
	@RequestMapping(value = "/post/view", method = RequestMethod.GET)
	public String view(@RequestParam int seq, Model model) {
		System.out.println("seq = " + seq);
		model.addAttribute("params", boardService.getView(seq));
		return "view";
	}
}
