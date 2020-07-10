<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "ex0429.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>[교수목록]</title>
	<style>
		body{text-align:center;}
		.title{text-align:center;}
		.row:hover{background:gray;color:white;cursor:pointer;}
		#slist, #clist {float:left;display:none;}
		#tbl{margin:auto;}
		#allspan {margin:auto;}
		#divaa {display:table; margin-left:auto; margin-right:auto;}
		span {
		display: table-cell;
		padding-left: 10px;
		text-align: left;
		vertical-align: middle;
		}
	</style>
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
	<h1>$교수목록$</h1>
	<form action = "list.jsp">
		<select name = "type">
			<option value = "pname">교수이름</option>
			<option value = "pcode">교번</option>
			<option value = "dept">소속학과</option>
		</select>
		<input type = "text" name= "word">
		<input type = "submit" value= "검색">
	</form>
	<table id="tbl" border=1 width=700> 
		<tr class = title>
			<td>교수번호</td>
			<td>교수이름</td>
			<td>소속학과</td>
			<td>임용일</td>
			<td>직급</td>
			<td>급여</td>
		</tr>
		<%
			PDAO dao = new PDAO();
			ArrayList<PVO> list = dao.list();
			for(PVO vo:list){
				out.println("<tr class = row>");
				out.print("<td class = pcode>"+vo.getPcode()+"</td>");
				out.print("<td class = pname>"+vo.getPname()+"</td>");
				out.print("<td>"+vo.getDept()+"</td>");
				out.print("<td>"+vo.getHireDate()+"</td>");
				out.print("<td>"+vo.getTitle()+"</td>");
				out.print("<td>"+vo.getSalary()+"</td>");
			}
		%>
	</table>
	<div id = "divaa">
	<span id = "slist">
		<h1>[학생목록]</h1>
		<div>담당교수:<span class = "pname"></span></div>
		<table id = "stable" border=1 width=500></table>
		
		<script id="temp" type="text/x-handlebars-template">
			<tr>
				<td>학번</td>
				<td>학생명</td>
				<td>전공</td>
				<td>학년</td>
				<td>생년월일</td>
				<td>지도교수 번호</td>
			<tr>
			{{#each slist}}
			<tr>
				<td>{{scode}}</td>
				<td>{{sname}}</td>
				<td>{{dept}}</td>
				<td>{{year}}</td>
				<td>{{birthday}}</td>
				<td>{{advisor}}</td>
			</tr>
			{{/each}}
		</script>
		
	</span>
	
	<span id = "clist">	
		<h1>[강좌목록]</h1>
		<div>담당교수:<span class = "pname"></span></div>
		<table id = "ctable" border=1 width=650></table>
		
		<script id="temp2" type="text/x-handlebars-template">
			<tr>
				<td>강좌번호</td>
				<td>강좌이름</td>
				<td>강의시간수</td>
				<td>강의실</td>
				<td>담당교수번호</td>
				<td>최대인원</td>
				<td>수강신청인원수</td>
			<tr>
			{{#each clist}}
			<tr>
				<td>{{lcode}}</td>
				<td>{{lname}}</td>
				<td>{{hours}}</td>
				<td>{{room}}</td>
				<td>{{instructor}}</td>
				<td>{{capacity}}</td>
				<td>{{persons}}</td>
			</tr>
			{{/each}}
		</script>
	
	</span>
	</div>
</body>
<script>
	$("#tbl").on("click", ".row", function(){
		var pcode = $(this).find(".pcode").html();
		var pname = $(this).find(".pname").html();
		$("#slist").show();
		$("#clist").show();
		$("#slist .pname").html(pname);
		$("#clist .pname").html(pname);
		
		$.ajax({
			type:"get",
			url:"json.jsp",
			dataType:"json",
			data:{"pcode":pcode},
			success:function(data){
				
				var temp=Handlebars.compile($("#temp").html());
				$("#stable").html(temp(data));
				temp=Handlebars.compile($("#temp2").html());				
				$("#ctable").html(temp(data));				
			}
		});
	});
		
</script>
</html>