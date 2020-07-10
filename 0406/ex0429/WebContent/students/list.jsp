<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = ' ex0429.*, java.util.*' %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>학생목록</title>
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
	<h1>학생목록</h1>
	<table border = 1 width = 700 id='tbl'>
		<tr class = title>
			<td>학번</td>
			<td>학과</td>
			<td>성명</td>
			<td>생년월일</td>
			<td>지도교수</td>
			<td>수강신청</td>
		</tr>
		<%
			SDAO sdao = new SDAO();
			ArrayList<SVO> list = sdao.list("%%");
			for(SVO vo:list){
				out.println("<tr class = row>");
				out.println("<td class = scode>" + vo.getScode() + "</td>");
				out.println("<td class = sname>" + vo.getSname() + "</td>");
				out.println("<td>" + vo.getDept() + "</td>");
				out.println("<td>" + vo.getBirthday() + "</td>");
				out.println("<td>" + vo.getAdvisor() + "</td>");
				out.println("<td><button>수강신청</button></td>");
				out.println("</tr>");
			}
		%>
	</table>
	<div id = "enroll" style="display:none">
		<h1>수강신청목록</h1>
		<div>
			학번:<span id = "scode"></span>
			성명:<span id = "sname"></span>
		</div>
		강좌명:
		<select id = "lcode"></select>
		<script id = "temp" type = "text/x-handlebars-template">
		{{#each clist}}
			<option value = {{lcode}}>{{lcode}}:{{lname}}</option>
		{{/each}}
		</script>
		<input type ="button" value="신청" id = "btnEnroll">
	</div>
	<table id = "etbl" border = 1  width=700></table>
	<script id = "etemp" type = "text/x-handlebars-template">
		<tr class = title>
			<td>강좌번호</td>
			<td>강좌명</td>
			<td>수강신청일</td>
			<td>점수</td>
			<td>수강취소</td>
		</tr>
		{{#each elist}}
		<tr class = row2>
			<td class = lcode>{{lcode}}</td>
			<td>{{lname}}</td>
			<td>{{edate}}</td>
			<td>{{grade}}</td>
			<td><button>수강취소</button></td>	
		</tr>
		{{/each}}
	</script>
</body>
<script>

	var scode;
	
	$("#btnEnroll").on("click", function(){
		if(!confirm("수강신청하시겠습니까?")) return;
		var lcode=$("#lcode").val();
		alert(scode + ":" + lcode);		
		$.ajax({
			type:"get",
			url:"insert.jsp",
			data:{"scode":scode, "lcode":lcode},
			success:function(){
				alert("수강신청완료!");
				getList();
			}
		});				
	});
	
	$("#etbl").on("click", ".row2 button", function(){
		if(!confirm("수강취소하시겠습니까?")) return;
		var row=$(this).parent().parent();
		var lcode = row.find(".lcode").html();
		$.ajax({
			type:"get",
			url:"delete.jsp",
			data:{"scode":scode, "lcode":lcode},
			success:function(){
				alert(scode + lcode);
				
			}
		});				
	});
		
	function getList(){
		$.ajax({
			type:"get",
			url:"ejson.jsp",
			dataType:"json",
			data:{"scode":scode},
			success:function(data){
				var etemp=Handlebars.compile($("#etemp").html());
				$("#etbl").html(etemp(data));			
			}
		});		
	}
		
	$("#tbl").on("click", ".row button", function(){
		var row = $(this).parent().parent();
		scode = row.find(".scode").html();
		var sname = row.find(".sname").html();
		$("#scode").html(scode);
		$("#sname").html(sname);
		$("#enroll").show();
		getList();
		
		$.ajax({
			type:"post",
			url:"cjson.jsp",
			dataType:"json",
			success:function(data){
				var temp=Handlebars.compile($("#temp").html());
				$("#lcode").html(temp(data));
			}
		})
	})
	
	
</script>
</html>