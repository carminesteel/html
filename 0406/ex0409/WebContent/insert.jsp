<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="home.css"/>
	<style>
		.tbl{width:700px; border:3px solid green; border-collapse:collapse; margin:auto;}
		.tbl td,.tbl tr{padding:5px; text-align:center; border:1px dotted green;}
	</style>
</head>
<body>
	<div id="page">
		<div id="header">
			<h1>홍길동 블로그</h1>
		</div>
		
		<div id="content">
			<div id = "menu">
				<div class = "item"><a href="list.jsp">목록으로 이동</a></div>
			</div>
			
			<div class = "box" style=text-align:center;>
				<form action="sqlInsert.jsp">
					<table class=tbl>
						<tr>
							<th>제목</th>
							<td><input type="text" size=80 name="title"></td>
						</tr>
						
						<tr>
							<th>내용</th>
							<td><textarea rows="10" cols="80" name="article"></textarea></td>
						</tr>
					</table>
				<input type="submit" value="저장">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value="취소">
				</form>
			</div>
		</div>
		
		<div id="footer">
			<h3>작성자 : ICIA 홍길동</h3>
		</div>
	</div>
</body>
</html>