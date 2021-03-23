package com.kh.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet
 * webservice를 위한 java class
 * HttpServlet를 상속해야함
 * 
 * Servlet생명주기
 * -was구동내내 딱 하나의 객체만 만들어져서 처리된다.(singletone방식)
 * 
 * 1. Servlet 객체생성(생성자 호출) 				- 최초client 호출시 1회
 * 2. init메소드 호출 							- 최초client 호출시 1회
 * 3. HttpServlet의 service메소드 호출 			- client 매요청마다 처리
 * 4. 전송방식에 따라 doGet | doPost 호출 			- client 매요청마다 처리
 * 5. destroy호출(tomcat종료시 객체 반환.)			- 마지막 1회
 * 
 * 
 * 멱등
 * - 서비스 전후로 database의 상태가 바뀌지 않는 경우
 * - select -> GET 				    멱등인경우엔 이거
 * - insert update delete -> POST 멱등이아닌경우 이거 (회원가입, 수정, DB상태가 바뀌는경우)
 * - login id/password -> POST 				   (아이디비밀번호가 노출되지않도록)
 *
 */
public class TestPerson1Servlet extends HttpServlet{

	
	/**
	 * 기본생성자
	 */
	public TestPerson1Servlet() {
		super();
		System.out.println("기본생성자  TestPerson1Servlet()호출!");
	}

	@Override
	public void init(ServletConfig config) {
		System.out.println("init(ServletConfig) 호출!");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy() 호출!");
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws IOException, ServletException{
		//매 요청시 사용되는 servlet객체는 동일하다.
		System.out.println(this.hashCode());
	
		
		//1. 사용자 입력값을 가져오기
		//getparameter은 한개의 값만 가져올수있음
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String animal = request.getParameter("animal");
		String[] foodArr= request.getParameterValues("food"); //string 배열을 리턴해서 여러값을 가져올 수 있음
		
		System.out.println("name = "+name);
		System.out.println("color = "+color);
		System.out.println("animal = "+animal);
		System.out.println("foodArr = "+Arrays.toString(foodArr));
		
		//2. 응답메세지 작성: html
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>개취 검사 결과</title>");
		
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>개취 검사 결과 GET</h1>");
		out.println("<P>" + name + "님의 개인 취향 검사 결과는</P>");
		out.println("<P>" + color + "색을 좋아합니다.</P>");
		out.println("<P>좋아하는 동물은 " + animal + "입니다.</P>");
		out.println("<P>좋아하는 음식은" + Arrays.toString(foodArr) + "입니다</P>");
		out.println("</body>");
		out.println("</html>");
	}
	
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws IOException, ServletException{
		
		
		//0. 인코딩 선언 (한글깨져서)
		//http message body부분 인코딩이 요효하도록 한다.
		request.setCharacterEncoding("utf-8");
		
		
		//1. 사용자 입력값을 가져오기
		//getparameter은 한개의 값만 가져올수있음
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String animal = request.getParameter("animal");
		String[] foodArr= request.getParameterValues("food"); //string 배열을 리턴해서 여러값을 가져올 수 있음
		
		System.out.println("name = "+name);
		System.out.println("color = "+color);
		System.out.println("animal = "+animal);
		System.out.println("foodArr = "+Arrays.toString(foodArr));
		
		//2. 응답메세지 작성: html
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>개취 검사 결과</title>");
		
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>개취 검사 결과 Post</h1>");
		out.println("<P>" + name + "님의 개인 취향 검사 결과는</P>");
		out.println("<P>" + color + "색을 좋아합니다.</P>");
		out.println("<P>좋아하는 동물은 " + animal + "입니다.</P>");
		out.println("<P>좋아하는 음식은" + Arrays.toString(foodArr) + "입니다</P>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
}
