package com.kh.web.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestPerson2Servlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		//0. encoding 선언
		
		request.setCharacterEncoding("utf-8");
		
		//1. 사용자입력값 변수에 담기
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String animal = request.getParameter("animal");
		String[] foodArr= request.getParameterValues("food");
		
		
		
		System.out.println("name = "+name);
		System.out.println("color = "+color);
		System.out.println("animal = "+animal);
		System.out.println("foodArr = "+Arrays.toString(foodArr));
		
		//2. 업무로직
		
		//3. 응답메세지처리 html
		
		
	}
	
	

}
