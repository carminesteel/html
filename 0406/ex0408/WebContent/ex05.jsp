<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="ex01.*" %>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Shop</title>
	<link rel="stylesheet" href="home.css"/>
</head>
<body>
	<div id="page">
		<div id="top">
			<h1>홍길동의 쇼핑몰</h1>
		</div>
		
		<div id="nav" style=text-align:center;>
			<hr>
			<br>
			<span>냉장고</span>
			<span>에어컨</span>
			<span>모니터</span>
			<span>프로젝터</span>
			<span>게임기</span>
			<br><br>
			<hr>
		</div>		
		
		<div id="content">
			<div class="group">
			<% 
			PDAO dao=new PDAO();
			ArrayList<PVO> array = dao.list();
			for(int i=0; i<array.size(); i++){
				PVO vo=array.get(i);
				out.println("<div class='box'>");
				out.println("<img src ='http://placehold.it/150x100'>");
				out.println("<div class='title'>"+vo.getPname()+"</div>");
				out.println("<div class='price'>"+vo.getPrice()+"</div>");
				out.println("</div>");
			}
			%>									
			</div>
		</div>
	</div>
</body>
</html>