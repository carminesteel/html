<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="home.css"/>
	<meta charset="UTF-8">
	<title>주소쓰기</title>
</head>
<body>
	<div id = "page">
		<div id= "content">
			<h3>주소 추가하기</h3>
			<hr>
			<br>
			<div id = "menu">
				<a href="list.jsp">목록</a>				
			</div>
			<form class = "frm" action="sqlInsert.jsp">
				<table class="tblInsert">						
					<tr>
						<td>name</td>
						<td><input type="text" size=86px name="aname"></td>						
					</tr>
					
					<tr>
						<td>tel</td>
						<td><input type="text" size=86px name="tel"></td>						
					</tr>
					
					<tr>
						<td>address</td>
						<td><input type="text" size=86px name="address"></td>						
					</tr>
					
					<tr>	
						<td colspan=2 class = "button">							
						<input type="reset" value="취소">
						<input type="submit" value="제출">
						</td>
					</tr>
				</table>					
			</form>
		</div>
	</div>
</body>