package kr.ac.kopo.board.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.framework.ModelAndView;
import kr.ac.kopo.framework.annotation.RequestMapping;

public class BoardController{

	private BoardService service;
	
	// /board/list.do 요청시 실행 메소드
	@RequestMapping(value="/board/list.do")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("게시판 조회 서비스");
		
		ServletContext sc = request.getServletContext();
		
		service = (BoardService)sc.getAttribute("boardService");
		
		List<BoardVO> boardList = service.listAll();
		
		ModelAndView mav = new ModelAndView();
		mav.setView("/board/list.jsp");
		mav.addAttribute("list", boardList);
		
		return mav;
	}
	
	// /board/detail.do 요청시 실행메소드
	@RequestMapping(value="/board/detail.do")
	public ModelAndView detail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("게시판 상세 서비스");
		ModelAndView mav = new ModelAndView();
		mav.setView("/board/detail.jsp");
		return mav;
	}

	@RequestMapping("/board/writeForm.do")
	public ModelAndView write(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setView("/board/writeForm.jsp");
		return mav;
	}
	
	@RequestMapping("/board/write.do")
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		System.out.println("title : " + title);
		System.out.println("Writer : " + writer);
		System.out.println("content : " + content);
		
		ModelAndView mav = new ModelAndView();
		mav.setView("redirect:/board/list.do");
		return mav;
	}
}


















