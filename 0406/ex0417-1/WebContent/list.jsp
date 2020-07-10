<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "ex0417.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<style>
		#page{width:650px;background:white;text-align:center;margin:auto;margin-top:50px;padding:25px;box-shadow:10px 10px 3px #43d8c9;}
		h1 {text-align:center;color:#43d8c9}
		body{background:#A2F2EA;}
		.content{margin:10px;text-align:left;width:590px}
		#content{height:50px;margin:10px;margin-bottom:20px;border:2px solid #43d8c9}
		.title{text-align:right;margin-right:20px;}
		hr {border:1px dotted #43d8c9;margin-bottom:20px;}
		.box {border:2px solid #43d8c9;padding:4px;margin-bottom:50px;}
		.btnDelete{float:right;}
		.date{float:left;margin-left:10px;font-size:11px;}
		.like{margin-right:15px}
	</style>
	<meta charset="UTF-8">
	<title>fk</title>
</head>
<body>
<div id="page">
	<h1>[댓글관리]</h1>	
		<input type="text" id="content" size=50px>
		<input type="button" value="저장" id="btnInsert">
		
		
		<%
			ReplyDAO dao=new ReplyDAO();
			ArrayList<ReplyVO> list= dao.list();
			out.println("<div class='box'>");
			for(int i=0;i<list.size();i++){
				ReplyVO vo = list.get(i);
				int rno=vo.getRno();
				String content=vo.getContent();
				Date wdate=vo.getWdate();
				int cnt=vo.getCnt();
				out.println("<div class='rno'rno=" + rno +">");
				out.println("<div class='content'>");
				out.println(content+"<input type='button' value='X' class='btnDelete'></div>");
				out.println("<div class='title'>");
				out.println("<span class='date'>"+wdate+"</span>");
				out.println("<span>"+cnt+"</span>");
				out.println("<input type='button' class='like' value='♬'>");			
				out.println("<hr size=1px>");
				out.println("</div>");	
				out.println("</div>");	
			}
			out.println("</div>");
		%>
	</div>
</body>
<script>
	$("#btnInsert").on("click", function(){
		if(confirm("댓글 달아요?")==false) return;
		var content=$("#content").val();
		location.href="sqlInsert.jsp?content="+content;
	});
	
	$(".btnDelete").on("click", function(){
		var rno=$(this).parent().parent().attr("rno");
		if(confirm("삭제해요?")==false) return;	
		location.href="sqlDelete.jsp?rno="+rno;
	});
		
	$(".like").on("click", function(){
		var rno=$(this).parent().parent().attr("rno");
		if(confirm("좋아요를 누르시겠습니까?")==false)return;
		location.href="sqlUpdate.jsp?rno="+rno;
	});
		
</script>
</html>