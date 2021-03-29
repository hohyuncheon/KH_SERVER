package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberDeleteServlet
 */
@WebServlet({ "/MemberDeleteServlet", "/member/memberDelete" })
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberService memberService = new MemberService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. encoding처리
		request.setCharacterEncoding("utf-8");
		
		// 2. 사용자입력값처리
		String memberId = request.getParameter("memberId");
		
		
		int result = memberService.deleteMember(memberId);
		
		
		if(result > 0) {
			//회원탈퇴 성공
			System.out.println("회원탈퇴 성공");
			HttpSession session = request.getSession(false);
			
			//무효화하기
			if(session != null)
				session.invalidate();
			
			//쿠키삭제
			Cookie c = new Cookie("saveId", memberId);
			c.setPath(request.getContextPath()); //path 쿠키를 전송할 url
			c.setMaxAge(0); //0으로 지정해서 즉시 삭제, 음수로 지정하면 session종료시 제거 
			response.addCookie(c);
			
		}else {
			//회원탈퇴 실패
			System.out.println("회원탈퇴 실패");
			
		}
		
		//리다이렉트 : url변경
		response.sendRedirect(request.getContextPath());
	}

}
