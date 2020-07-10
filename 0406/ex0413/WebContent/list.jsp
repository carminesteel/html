<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, ex01.*" %>
<%
	BBSDAO dao = new BBSDAO();
	ArrayList<BBSVO> array=dao.list();
%>

<!DOCTYPE html>
<html>
<head>
	<style>div {background:gray; color:yellow; font-size:40px}
	</style>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>[게시판 목록]</h1>
	<a href = "insert.jsp">글쓰기</a>
	<%
		for(int i=0; i<array.size(); i++) {
			BBSVO vo = array.get(i);
			out.println("<div>");
			out.println(vo.getBno()+"\t");
			out.println("<a href='read.jsp?bno="+vo.getBno()+"'>"+vo.getTitle()+"</a>");
			out.println(vo.getTitle()+"\t");
			out.println(vo.getWdate()+"\t");
			out.println("</div>");
		}
	%>
</body>
</html>