<%@page import="org.apache.catalina.connector.OutputBuffer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ex01.*" %>
<%@ page import="java.util.*" %>
<% 
	request.setCharacterEncoding("UTF-8");

	
 %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>[상품목록]</title>
</head>
<body>
	<h1>[상품목록]</h1>
	<table border=1 width=500>
		<tr>
			<th width=100>상품번호</th>
			<th width=300>상품명</th>
			<th tidth=100>가격</th>
		</tr>
		<!-- 데이터 읽어서 출력 -->
		<%
		ProductDAO dao=new ProductDAO();
		ArrayList<ProductVO> array = dao.list();
		
		for(int i=0; i<array.size(); i++){
			ProductVO vo=array.get(i);
			
			out.println("<tr>");
			out.print("<td>"+ vo.getPno() + "</td>");
			out.print("<td>"+ vo.getPname() + "</td>");
			out.print("<td>"+ vo.getPrice() + "</td>");
			out.println("</tr>");
		}
		%>
	</table>
</body>
</html>