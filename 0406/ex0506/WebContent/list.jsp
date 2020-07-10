<%@page import="com.sun.org.apache.xerces.internal.impl.dv.xs.DecimalDV"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = ' ex0506.*, java.util.*, java.text.*' %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>강좌별 평균점수</title>
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
	<h1>강좌별점수</h1>	
	<table id = "tbl" border = 1  width=700>
	
		<tr class = title>
			<td>lcode</td>
			<td>lname</td>
			<td>instructor</td>
			<td>room</td>
			<td>avg</td>
			<td>cnt</td>
		</tr>
		<%
		CDAO dao = new CDAO();
		ArrayList<CVO> list = dao.clist();
		for(CVO vo:list){
			out.println("<tr>");
			out.println("<td>"+vo.getLcode() + "</td>");
			out.println("<td>"+vo.getLname() + "</td>");
			out.println("<td>"+vo.getPname() + "</td>");
			out.println("<td>"+vo.getRoom() + "</td>");
			DecimalFormat df = new DecimalFormat("#0.00");
			String strAvg=df.format(vo.getAvg());
			out.println("<td>"+ strAvg + "</td>");
			out.println("<td>"+vo.getCnt() + "</td>");
			out.println("</tr>");
		}
		%>
	</table>
	
	<h1>[학생별 평균점수]</h1>
	<table border=1 width=700>
		<tr>
			<td>scode</td>
			<td>sname</td>
			<td>dept</td>
			<td>avg</td>
			<td>cnt</td>
		</tr>
		<%
		CDAO dao2 = new CDAO();
		ArrayList<CVO> list2 = dao.glist();
		for(CVO vo:list2){
			out.println("<tr>");
			out.println("<td>"+vo.getScode() + "</td>");
			out.println("<td>"+vo.getSname() + "</td>");
			out.println("<td>"+vo.getDept() + "</td>");
			DecimalFormat df = new DecimalFormat("#0.00");
			String strAvg=df.format(vo.getAvg());
			out.println("<td>"+ strAvg + "</td>");
			out.println("<td>"+vo.getCnt() + "</td>");
			out.println("</tr>");
		}
		%>
	</table>
	
	<h1>학생목록</h1>	
	<table id = "stbl" border = 1  width=700>
	
		<tr class = stitle>
			<td>학번</td>
			<td>학생명</td>
			<td>학과</td>
			<td>지도교수명</td>
		</tr>
		<%
		CDAO dao3 = new CDAO();
		ArrayList<CVO> list3 = dao.slist();
		for(CVO vo:list3){
			out.println("<tr class = srow>");
			out.println("<td class = scode>"+vo.getScode() + "</td>");
			out.println("<td>"+vo.getSname() + "</td>");
			out.println("<td>"+vo.getDept() + "</td>");
			out.println("<td>"+vo.getPname() + "</td>");
			out.println("</tr>");
		}
		%>
		</table>
		<br>
		<div id = "시팔" style=display:none>
		<h1 id = cnthead>해당학생 점수 목록</h1>
		<table id = "cntbl" border = 1  width=700></table>
		<script id = "cntemp" type = "text/x-handlebars-template">
		<tr class = cntitle>
			<td>학번 : {{scode}}</td>
			<td>수강 수 : {{cnt}}</td>
			<td>평균 : {{avg}}</td>
		</tr>
		</script>
		
		<table id = "etbl" border = 1  width=700></table>
		<script id = "etemp" type = "text/x-handlebars-template">
		
		<tr class = etitle>
			<td>강의코드</td>
			<td>강의명</td>
			<td>점수</td>
		</tr>
		{{#each elist}}
		<tr class = erow>
			<td>{{lcode}}</td>
			<td>{{lname}}</td>
			<td>{{grade}}</td>
		</tr>
		{{/each}}

		</script>
		</div>
		
</body>
<script>

	$("#stbl").on("click",".srow", function(){
		$("#시팔").show();
		var row = $(this);
		var scode = row.find(".scode").html();
		alert(scode)
		$.ajax({
			type:"get",
			url:"json.jsp",
			dataType:"json",
			data:{"scode":scode},
			success:function(data){
				var etemp=Handlebars.compile($("#etemp").html());
				$("#etbl").html(etemp(data));
				
				var cntemp=Handlebars.compile($("#cntemp").html());
				$("#cntbl").html(cntemp(data));
			
			}
		});				
	});


</script>
</html>