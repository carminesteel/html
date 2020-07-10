<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "ex0428.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>강좌목록</title>
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
 	<style>
 	</style>
</head>
<body>
	<h1>강좌목록</h1>
	<div id=sexyboy>
	<form action = "clist.jsp">
		<select name = "type">
			<option value = "lname">강의명</option>
			<option value = "lcode">강의코드</option>
			<option value = "room">강의실</option>
			<option value = "Instructor">교수명</option>
			<option value = "pdept">교수학과</option>
		</select>
		<input type = "text" name= "word">
		<input type = "submit" value= "검색">
	</form>
	<table id = tbl width=700px border=1>
		<tr id = row>
			<td>강의명</td>
			<td>강의코드</td>
			<td>강의실</td>
			<td>교수명</td>
			<td>교수학과</td>
		</tr>
	<%
		String type = request.getParameter("type")==null?"lcode":request.getParameter("type");
		String word = request.getParameter("word")==null?"":request.getParameter("word");
		
		CDAO dao = new CDAO();
		ArrayList<CVO> list=dao.list(type, word);
		for(CVO vo:list){
			out.print("<tr class = row>");
			out.print("<td class = lcode>"+vo.getLcode()+"</td>");
			out.print("<td class = lname>"+vo.getLname()+"</td>");
			out.print("<td>"+vo.getRoom()+"</td>");
			out.print("<td>"+vo.getPname()+"</td>");
			out.print("<td>"+vo.getDept()+"</td>");
			out.print("<tr>");
		}
	%>
	</table>
	<div id = "enroll">
		<h1><span id = "lname"></span></h1>
		<h5><span id = "total"></span></h5>
		<table id = "tbl1"></table>
		<script id="temp" type="text/x-handlebars-template">
			<tr>
				<td>강의번호</td>
				<td>강의명</td>
				<td>수강생</td>
				<td>학번</td>
				<td>신청날짜</td>
				<td>점수</td>
			<tr>
			{{#each items}}
			<tr>
				<td>{{lcode}}</td>
				<td>{{lname}}</td>
				<td>{{scode}}</td>
				<td>{{sname}}</td>
				<td>{{edate}}</td>
				<td>{{grade}}</td>
			</tr>
			{{/each}}
		</script>
	</div>
	</div>	
</body>
<script>
	$("#tbl").on("click", ".row", function(){
		var lname=$(this).find(".lname").html();
		$("#lname").html(lname+" 을 수강하는 학생");
	
		var lcode = $(this).find(".lcode").html();
		$.ajax({
			type:"get",
			url:"enroll.jsp",
			dataType:"json",
			data:{"lcode":lcode},
			success:function(data){
				
				total=data.total;
				$("#total").html("총" + total + "건의 결과");
				
				var temp=Handlebars.compile($("#temp").html());
				$("#tbl1").html(temp(data));
				
			}
		});
	});
	
	
</script>
</html>