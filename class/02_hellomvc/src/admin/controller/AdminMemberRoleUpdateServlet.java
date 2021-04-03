package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.MvcUtils;
import member.model.service.MemberService;
import member.model.vo.Member;

@WebServlet("/admin/memberRoleUpdate")
public class AdminMemberRoleUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberService memberService = new MemberService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 사용자 입력값 처리 : memberId, memberRole
		String memberId = request.getParameter("memberId");
		String memberRole = request.getParameter("memberRole");
		System.out.println("memberId"+memberId);
		System.out.println("memberRole"+memberRole);

		// 2. 업무로직
		// 아이디로 member찾기
		Member member = new MemberService().selectOne(memberId);

		// role바꾸기
		int result = 0;
		System.out.println("set전"+member);
		member.setMemberRole(memberRole);
		System.out.println("set후"+member);
		result = memberService.updateMemberRole(member);

		// role변경 성공/실패 여부 판단
		HttpSession session = request.getSession();

		if (result > 0) {
			// role변경 성공
			session.setAttribute("msg", "role변경 성공하셨습니다");
		} else {
			// role변경 실패
			session.setAttribute("msg", "role변경 실패하셨습니다");
		}

		response.sendRedirect(request.getContextPath() + "/admin/memberList");
	}

}
