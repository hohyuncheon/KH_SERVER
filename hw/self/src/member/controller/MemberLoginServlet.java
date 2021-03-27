package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

@WebServlet(name = "member/login", urlPatterns = { "/member/login" })
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	MemberService memberService = new MemberService();


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String memberId = request.getParameter("memberId");
		String password = request.getParameter("password");	
		
		System.out.println("memberId@Servlet = " + memberId);
		System.out.println("password@Servlet = " + password);

		Member member = memberService.selectOne(memberId);
		
		if(memberId != null && password.contentEquals(member.getPassword())) {
			
			request.setAttribute("msg", "로그인에 성공했습니다");
		}else {
			request.setAttribute("msg", "로그인에 실패했습니다");
			request.setAttribute("loc", request.getContextPath());
			
		}
		
		RequestDispatcher reqDispatcher = 
				request.getRequestDispatcher("/index.jsp");
			reqDispatcher.forward(request, response);
		
		
	}
}
