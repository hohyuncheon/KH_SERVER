<%@page import="board.model.vo.Board"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	Board board = (Board) request.getAttribute("board");
	System.out.println("board@jsp = " + board);
%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/board.css" />
<section id="board-container">
	<h2>게시판</h2>
	<table id="tbl-board-view">
		<tr>
			<th>글번호</th>
			<td><%= board.getNo() %></td>
		</tr>
		<tr>
			<th>제 목</th>
			<td><%= board.getTitle() %></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%= board.getWriter() %></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td><%= board.getReadCount() %></td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td>
				<% if(board.getAttach() != null) {%>
				<img width = 180px src="<%= request.getContextPath()%>/upload/board/<%=board.getAttach().getRenamedFileName()%>">
				<br>
				<%= board.getAttach() + "이거야" %>>
				<a href="<%= request.getContextPath()%>/upload/board/<%=board.getAttach().getRenamedFileName()%>"><%= board.getAttach().getRenamedFileName() %></a>
				<% } else {%>
				<a> </a>
				<% }%>
			</td>
		</tr>
		<tr>
			<th>내 용</th>
			<td><%= board.getContent() %></td>
		</tr>
		<tr>
			<%-- 작성자와 관리자만 마지막행 수정/삭제버튼이 보일수 있게 할 것 --%>
			<th colspan="2">
				<input type="button" value="수정하기" onclick="updateBoard()">
				<input type="button" value="삭제하기" onclick="deleteBoard()">
			</th>
		</tr>
	</table>
</section>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
