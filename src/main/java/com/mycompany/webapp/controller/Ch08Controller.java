package com.mycompany.webapp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.webapp.dto.Ch07Board;
import com.mycompany.webapp.dto.Ch08Board;

@Controller
@RequestMapping("/ch08")
public class Ch08Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch06Controller.class);

	@GetMapping("/content")
	public String content() {
		logger.info("실행");
		return "ch08/content";
	}

	@GetMapping("/method1")
	public String method1(HttpSession session) {
		session.setAttribute("name", "스프링");
		session.setAttribute("age", 26);
		session.setAttribute("job", "인공지능 개발자");
		
		
		
		return "ch08/el";
	}
	
	@GetMapping("/method2")
	public String method2(Model model){
		Ch07Board board = new Ch07Board();
		board.setNo(1);
		board.setTitle("너무 추워요");
		board.setContent("과제하면 덜 추워요. 과제 내 주세요.");
		board.setWriter("감자바");
		board.setDate(new Date());
		model.addAttribute("board1",board);
		
		return "ch07/el";	
	}

	@GetMapping("/method3")
	public String method3(Model model){
		List<Ch07Board> list = new ArrayList<>();
		for(int i=1; i<=10; i++) {
			Ch07Board board = new Ch07Board();
			board.setNo(i);
			board.setTitle("너무 추워요" + i);
			board.setContent("과제하면 덜 추워요. 과제 내 주세요." + i);
			board.setWriter("감자바" + i);
			board.setDate(new Date());
			list.add(board);
		}
		model.addAttribute("boardList",list);
		return "ch08/el";
	}
	
	@PostMapping("/login")
	public String login(String uid, String upassword, HttpSession session) {
		if(uid.equals("admin") && upassword.equals("12345")){
			session.setAttribute("loginStatus", uid);
		}
		return "redirect:/ch08/content";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//개별적으로 데이터를 삭제
		//session.removeAttribute("loginStatus");
		
		//세션의 모든 데이터를 삭제
		session.invalidate();
		
		return "redirect:/ch08/content";
	}
	
	@PostMapping("/boardWrite")
	public String boardWrite(Ch08Board board, HttpSession session) {
		String uid = (String) session.getAttribute("loginStatus");
		
		if(uid != null) { //로그인이 되어있다면
			board.setWriter(uid);
			logger.info("title: " + board.getTitle());
			logger.info("content: " + board.getContent());
			logger.info("writer: " + board.getWriter());
			logger.info("게시물을 성공적으로 저장함");
		} else {
			logger.info("게시물을 저장하지 못함");
		}
		
		return "redirect:/ch08/content";
	}
	
}
