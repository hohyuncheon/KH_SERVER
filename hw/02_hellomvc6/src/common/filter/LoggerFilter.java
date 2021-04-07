package common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class LoggerFilter implements Filter{

	
	

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("LoggerFilter의 init 메소드 호출!");
	}

	@Override
	public void destroy() {
		System.out.println("LoggerFilter의 destroy 메소드 호출!");
	}
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	throws IOException, ServletException{
		//1.servlet 호출전 (doFilter의 기준전에 작성해서)
		System.out.println("\n=====================do filter 이전");
		HttpServletRequest httpReq = (HttpServletRequest)request;
		String uri = httpReq.getRequestURI();
		System.out.println(uri);
		System.out.println("\n---------------------do filter 이전2");
		//다음 filterChain 객체를 호출
		//다음 filter객체가 존재하지 않으면, servlet 호출
		
		chain.doFilter(request, response);
		
		
		
		//2.servlet jsp 처리이후
		System.out.println("_____________________________do filter이후");
		
	}

}
