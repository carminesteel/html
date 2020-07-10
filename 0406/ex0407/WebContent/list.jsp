<%@page import="org.apache.catalina.connector.OutputBuffer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ex0407.*" %>
<%@ page import="java.util.*" %>
<% 
	request.setCharacterEncoding("UTF-8");

	
 %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>[학생목록]</title>
</head>
<body>
	<h1>[학생목록]</h1>
	<table border=1 width=500>
		<tr>
			<th width=100>학생번호</th>
			<th width=200>이름</th>
			<th width=100>전화번호</th>
			<th width=100>주소</th>
		</tr>
		<!-- 데이터 읽어서 출력 -->
		<%
		StudentDAO dao=new StudentDAO();
		ArrayList<StudentVO> array = dao.list();
		
		for(int i=0; i<array.size(); i++){
			StudentVO vo=array.get(i);
			
			out.println("<tr>");
			out.print("<td>"+ vo.getSno() + "</td>");
			out.print("<td>"+ vo.getSname() + "</td>");
			out.print("<td>"+ vo.getTel() + "</td>");
			out.print("<td>"+ vo.getAddress() + "</td>");
			out.println("</tr>");
		}
		%>
	</table>
</body>
</html>