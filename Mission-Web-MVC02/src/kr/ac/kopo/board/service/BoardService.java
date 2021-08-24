package kr.ac.kopo.board.service;

import java.util.List;

import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.board.vo.BoardVO;

public class BoardService {

	private BoardDAO dao;
	
	
	public BoardService(BoardDAO dao) {
		this.dao = dao;
	}

	public List<BoardVO> listAll() {
		
		List<BoardVO> list = dao.selectAll();
		
		return list;
	}
}
