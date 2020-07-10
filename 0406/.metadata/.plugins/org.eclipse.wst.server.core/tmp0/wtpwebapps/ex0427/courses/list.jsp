<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*, ex0427.*"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>강의</title>
</head>
<body>
	<h1>강의목록</h1>
	<form action="list.jsp">
		<select name="type">
			<option value = "pname">지도교수명</option>
			<option value = "lname">강의명</option>
			<option value = "room">강의실</option>
			<option value = "dept">전공</option>
		</select>
		<input type = "text" name = "word" value = "">
		<input type = "submit" value = "검색">
	</form>
		
	<table width = 700px border = 1px>
		<tr>
			<td>강좌번호</td>
			<td>강좌이름</td>
			<td>강의실</td>
			<td>교수명</td>
			<td>교수전공</td>
		</tr>
		<%
			String type=request.getParameter("type")==null?"lcode":
				request.getParameter("type");
			String word=request.getParameter("word")==null?"":
				request.getParameter("word");
			CDAO dao = new CDAO();
			ArrayList<CVO> list = dao.list(type, word);	
			for (CVO vo : list){
				out.print("<tr>");
				out.print("<td>"+vo.getLcode()+"</td>");
				out.print("<td>"+vo.getLname()+"</td>");
				out.print("<td>"+vo.getRoom()+"</td>");
				out.print("<td>"+vo.getPname()+"</td>");
				out.print("<td>"+vo.getDept()+"</td>");
				out.print("</tr>");
			};
		%>
	</table>
</body>
</html>