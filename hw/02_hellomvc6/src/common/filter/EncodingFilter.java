package common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter("/*")
public class EncodingFilter implements Filter {

/*
 * web.xml에 등록된 순서대로 처리된다.
 * web.xml이 @WebFilter보다 우선처리된다.
 * encoding 필터는 등록안해줘서 순서가 앞에서부터
 * 
 */
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//인코딩처리해버리기
		request.setCharacterEncoding("utf-8");
		System.out.println("[utf-8] encoding 처리함");
		
		chain.doFilter(request, response);
	}


}
