<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "ex0507.*, java.text.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>교수입력</title>
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
	<h1>교수입력</h1>
	<div>
		교수번호 : <input type = "text" id= "txtpcode" maxlength=3>
		교수명 : <input type = "text" id= "txtpname">
		<input type = "button" id = "btnSave" value="저장">
	</div>
	
</body>
<script>
	$("#btnSave").on("click", function(){
		if(!confirm("저장하시겠습니까?")) return;
		var pcode=$("#txtpcode").val();
		var pname=$("#txtpname").val();
		if(pcode.lenth==0 || pcode.length!=3){
			alert("교수번호를 다시 입력하세요")
			$("txtpcode").focus();
		}else if(pname.length == 0 ){
			alert("교수명을 입력하세요!");
			$("txtpname").focus();
		}else{
			//저장
			$.ajax({
				type:"post",
				url:"pinsert.jsp",
				data:{"pcode":pcode, "pname":pname},
				success:function(){
					alert("저장완료")
					$("#txtpcode").val("");
					$("#txtpname").val("");
					$("#txtpcode").focus();
					
					
				}
			})
		}
	});
</script>
</html>