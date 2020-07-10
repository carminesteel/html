<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "ex0416.*, java.util.*,java.text.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상품목록</title>
	<link rel="stylesheet" href="home.css">
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>	
	<style>
		.del:hover{color:white;background:pink;cursor:pointer};
	</style>
</head>
<body>
	<h1 id="title">[상품목록]</h1>
	<div id="content">
	
		<div id = "menu">
			<button class="btn">1</button>
			<button class="btn">2</button>
			<button class="btn">3</button>
			<button class="btn">4</button>
			<a href="insert.html" style="text-decoration:none;color:white">[상품등록]</a>
		</div>
		<%
			ProductDAO dao = new ProductDAO();
			ArrayList<ProductVO> list=dao.list();
			for(int i=0; i<list.size(); i++){
				ProductVO vo = list.get(i);
				DecimalFormat df=new DecimalFormat("#,###원");
				String strPrice=df.format(vo.getPrice());
				out.println("<div class = 'box'>");
				out.println("<img src='http://placehold.it/150x150'>");
				out.println("<div class='pname'>" + vo.getPname() + "</div>");
				out.println("<div class='price'>" + strPrice + "</div>");
				out.println("<div class='del' pno="+vo.getPno() +" pname="+vo.getPname()+">"+"삭제</div>");
				out.println("</div>");
			}
		%>
	</div>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
	
	<div id="darken-background">
		 <div id="lightbox">
		 	<img src="http://placehold.it/600x750"/>
		 	<div><button id="btnClose">닫기</button></div>
		 	<div id = "txtName">상품명</div>
		 	<div id="txtPrice">가격</div>
		 </div>
	</div>
</body>
<script>
	$(".box").on("click", ".del", function(){
		var pno=$(this).attr("pno");
		var pname=$(this).attr("pname");
	    if(confirm(pname + " 상품을 삭제하시겠습니까?")==false) return;
	  	location.href="sqlDelete.jsp?pno="+pno;
	});
	    
	

	$(".box").on("click","img",function(){
		
		var box=$(this).parent();
		var pname=box.find(".pname").html();
		var price=box.find(".price").html();
		
		$("#txtName").html(pname);
		$("#txtPrice").html(price);
		$("#darken-background").show();	
	});
	
	$("#btnClose").on("click",function(){
		$("#darken-background").hide();
	});
	
	$("#menu").on("click",".btn", function(){
		var num=$(this).html();
		$("#content").css("width", 190*num);
	});
</script>
</html>