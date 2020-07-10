<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = ' ex0504.*, java.util.*' %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>성적목록</title>
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
	<h1>성적목록</h1>	
	<table id = "etbl" border = 1  width=700></table>
	<script id = "etemp" type = "text/x-handlebars-template">
		<tr class = title>
			<td>lcode</td>
			<td>lname</td>
			<td>pname</td>
			<td>avg grade</td>
		</tr>
		{{#each clist}}
		<tr class = row2>
			<td>{{lcode}}</td>
			<td>{{lname}}</td>
			<td>{{pname}}</td>
			<td>{{avg}}</td>
		</tr>
		{{/each}}
	</script>
	
	<table id = "etbl2" border = 1  width=700></table>
	<script id = "gtemp" type = "text/x-handlebars-template">
		<tr class = title>
			<td>dept</td>
			<td>scode</td>
			<td>sname</td>
			<td>avg grade</td>
		</tr>
		{{#each glist}}
		<tr class = row2>
			<td>{{dept}}</td>
			<td>{{scode}}</td>
			<td>{{sname}}</td>
			<td>{{avg}}</td>
		</tr>
		{{/each}}
	</script>
</body>
<script>
	getList();

	function getList(){
		
		$.ajax({
			type:"get",
			url:"json.jsp",
			dataType:"json",
			success:function(data){
				var etemp=Handlebars.compile($("#etemp").html());
				$("#etbl").html(etemp(data));
				
				var gtemp=Handlebars.compile($("#gtemp").html());
				$("#etbl2").html(gtemp(data));
			}
		});		
	}
</script>
</html>