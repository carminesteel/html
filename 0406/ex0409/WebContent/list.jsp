<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ex01.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>gildong blog</title>
	<link rel="stylesheet" href="home.css"/>
</head>
<body>
	<div id="page">
		<div id = "header">
			<h1>gildong blog</h1>
		</div>
		<div id = "menu">
			<div class = "item"><a href="insert.jsp">글쓰기</a></div>
		</div>
		<div id = "content">
			<%
			BDAO dao=new BDAO();
			ArrayList<BVO> list=dao.list();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy/mm/dd");
			for(int i=0; i<list.size(); i++){
				BVO vo=list.get(i);
				String strDate=sdf.format(vo.getWdate());
				out.println("<div class='box'>");
				out.println("<h1 class='title'>"+vo.getTitle()+"</h1>");
				out.println("<h3 class='date'>"+strDate+"</h3>");
				out.println("<h3 class='article'>"+vo.getArticle()+"</h3>");
				out.println("<a href='sqlDelete.jsp?bno="+vo.getBno()+"'>삭제</a>");
				out.println("</div>");
				
			}
			%>
		</div>
		
		<div id = "footer">
			<h3>작성자 : ICIA gildong</h3>	
		</div>
	</div>
</body>
</html>