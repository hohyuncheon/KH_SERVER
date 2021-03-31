package member.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/member/memberUpdate")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberService();
	
	
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/memberView.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// 1. encoding처리
		request.setCharacterEncoding("utf-8");
		
		
		// 2. 사용자입력값처리
				String memberId = request.getParameter("memberId");
				String password = request.getParameter("password");
				String memberName = request.getParameter("memberName");
				String birthday = request.getParameter("birthday");
				
				Date bday = null;
				if(birthday != null && !birthday.equals(""))
					bday = Date.valueOf(birthday);
				String email = request.getParameter("email");
				String phone = request.getParameter("phone");
				String address = request.getParameter("address");
				String gender = request.getParameter("gender");
				String[] hobby = request.getParameterValues("hobby");
				
				String hobbies = "";
				if(hobby != null)
					hobbies = String.join(",", hobby);

				System.out.println("memberId@servlet = " + memberId);
				System.out.println("password@servlet = " + password);
				System.out.println("memberName@servlet = " + memberName);
				System.out.println("birthday@servlet = " + birthday);
				System.out.println("bday@servlet = " + bday);
				
				System.out.println("email@servlet = " + email);
				System.out.println("phone@servlet = " + phone);
				System.out.println("address@servlet = " + address);
				System.out.println("gender@servlet = " + gender);
				System.out.println("hobby@servlet = " + Arrays.toString(hobby));
				System.out.println("hobbies@servlet = " + hobbies);
				
				// 3. 업무로직 : memberId로 회원객체를 수정
				
				Member member = new Member();
				
				member.setMemberId(memberId);
				member.setPassword(password);
				member.setMemberName(memberName);
				member.setMemberRole(MemberService.MEMBER_ROLE);
				member.setBirthday(bday);
				member.setEmail(email);
				member.setPhone(phone);
				member.setAddress(address);
				member.setGender(gender);
				member.setHobby(hobbies);
				
				System.out.println("입력한 회원정보 : " + member);
				
				int result = memberService.updateMember(member);
				System.out.println("result@updateservlet = " + result);
				
				//회원가입 성공/실패 여부 판단
				HttpSession session = request.getSession();
				
				if(result > 0) {
					//회원가입 성공
					session.setAttribute("msg", "정보수정에 성공하셨습니다");
					session.setAttribute("loginMember", member);
				}else {
					//회원가입 실패
					session.setAttribute("msg", "정보수정에 실패하셨습니다");
				}
				
				
				response.sendRedirect(request.getContextPath());
		
	}

}
