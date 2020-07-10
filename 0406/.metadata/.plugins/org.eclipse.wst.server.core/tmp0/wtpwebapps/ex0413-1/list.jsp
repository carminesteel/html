<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, ex01.*, java.text.*" %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>주소 목록</title>
	<link rel="stylesheet" href="home.css"/>
</head>
<body>
	<div id = "page">
		<div id = "content">
			<h3>게시판 목록</h3>
			<hr>
			<div id = "menu">
				<a href="insert.jsp">주소 추가하기</a>

			</div>
			<table class = "tbl">
				<tr class = "title">
					<td width=30>No.</td>
					<td>Name</td>
					<td width=200>Tel</td>
					<td width=200>Address</td>
					<td width=35></td>
				</tr>
				<%
					ADDDAO dao = new ADDDAO();
					ArrayList<ADDVO> list = dao.list();
					for(int i=0; i<list.size(); i++){
						ADDVO vo=new ADDVO();
						vo=list.get(i);
						int ano=vo.getAno();
						String tel = vo.getTel();
						String aname=vo.getAname();
						String address = vo.getAddress();
						out.print("<tr class = 'data'>");
						out.print("<td>" + ano + "</td>");
						out.print("<td><a href='read.jsp?ano=" + ano + "'>" + aname + "</a></td>");
						out.print("<td>" + tel + "</td>");
						out.print("<td>" + address + "</td>");
						out.print("<td><a href='sqlDelete.jsp?ano="+ano+"'>삭제</a></td>");
						out.print("</tr>");
					}
				%>
			</table>
		</div>
	</div>
</body>
</html>