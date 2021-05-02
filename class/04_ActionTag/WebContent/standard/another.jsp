<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/standard/header.jsp">
	<jsp:param value="ANOTHER" name="title"/>
</jsp:include>
		<article>
			<h2>2222222</h2>
			<a href="${pageContext.request.contextPath}/standard/include.jsp">include</a>
		</article>
<jsp:include page="/standard/footer.jsp"></jsp:include>