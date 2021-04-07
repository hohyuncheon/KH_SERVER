package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;

/**
 * Servlet implementation class BoardViewServlet
 */
@WebServlet("/board/boardView")
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardService boardService = new BoardService();
	
	/*
	 * 게시글 상세보기
	 * -board + attachment 조회
	 * - 조인없이 두번의 쿼리요청할 것
	 * 
	 * 게시글 등록 후 성공시 바로 상세보기 페이지로 이동할것
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 사용자 입력값 : no
		
		String no = request.getParameter("no");
//		int no = Integer.parseInt(request.getParameter("no"));
		
		
		//2. 업무로직 board 객체 조회 (첨부파일 조회)
		Board board = boardService.selectBoard(no);
		System.out.println(board+"board@servlet");
		
		
		
		//3. jsp forwarding
		
		request.setAttribute("board", board);
		request.getRequestDispatcher("/WEB-INF/views/board/boardView.jsp")
				.forward(request, response);
		
	}

}
