package kr.ac.kopo.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.board.service.BoardService;

public class ContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("리스너 시작...");		
		ServletContext context = sce.getServletContext();
		BoardDAO boardDAO = new BoardDAO();
		BoardService boardService = new BoardService(boardDAO);		
		context.setAttribute("boardService", boardService);
	
	}

	
}
