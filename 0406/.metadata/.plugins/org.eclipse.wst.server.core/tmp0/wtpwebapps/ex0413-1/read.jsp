<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ex01.*" %>
<%
	String strAno=request.getParameter("ano");
	int ano=Integer.parseInt(strAno);
	ADDDAO dao=new ADDDAO();
	ADDVO vo = dao.read(ano);
 %>

<!DOCTYPE html>	
<html>
<head>
	<link rel="stylesheet" href="home.css"/>
	<meta charset="UTF-8">
	<title>주소보기</title>
</head>
<body>
	<div id = "page">
		<div id= "content">
			<h3>주소확인</h3>
			<hr>
			<br>
			<div id = "menu">
				<a href="list.jsp">목록</a>				
			</div>
			<form class = "frm" action="sqlUpdate.jsp">
				<table class="tblInsert">						
					<tr>
						<td>name</td>
						<td><input type="text" height=25px size=55px name="title" value="<%=vo.getAname()%>"></td>						
					</tr>
					<tr>
						<td>tel</td>
						<td><input type="text" height=25px size=55px name="title" value="<%=vo.getTel()%>"></td>						
					</tr>
					<tr>
						<td>address</td>
						<td><input type="text" height=25px size=55px name="title" value="<%=vo.getAddress()%>"></td>						
					</tr>
					
					<tr>	
						<td colspan=2 class = "button">							
						<input type="button" value="취소">
						<input type="button" value="수정">
						<input type="button" value="삭제">
						</td>
					</tr>
				</table>					
			</form>
		</div>
	</div>
</body>

</html>