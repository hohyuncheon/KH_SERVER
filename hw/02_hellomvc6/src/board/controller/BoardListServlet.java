package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;
import common.MvcUtils;
import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * 페이징
 * - 한페이지당 게시글 수 5개
 */
@WebServlet("/board/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberService memberService = new MemberService();
	private BoardService boardService = new BoardService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		final int numPerPage = 5;
		int cPage = 1;
		
		try {
			cPage =	Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {
			// 처리 코드 없음. 기본값 1 유지.
		}
		//2. 업무로직 : 전체회원 - 회원가입일 내림차순으로 조회
		int end = cPage * numPerPage;
		int start = (cPage -1) * numPerPage + 1;
		List<Board> list = boardService.selectList(start, end);
		System.out.println("list@servlet = " + list);
		
		int totalContents = boardService.selectBoardCount();
		System.out.println("totalContents@servlet = " + totalContents);
		
		//3. pageBar영역 작업
		String url = request.getRequestURI();
		String pageBar = MvcUtils.getPageBar(
					cPage,
					numPerPage,
					totalContents,
					url
				);
		
		
		
		//4. jsp에 html응답메세지 작성 위임
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/views/board/boardList.jsp")
				.forward(request, response);
	}

}
