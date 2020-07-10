<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "ex0429.*, java.util.*, org.json.simple.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>강좌목록</title>
	<link rel = "stylesheet" href="../home.css">	
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
	<div id = "menu">
		<a href="../professors/list.jsp">RLRL</a>
		<a href="../students/list.jsp">RHHR</a>
	</div>
	<h1>[강좌목록]</h1>
	<table id ="tbl" width=700>
		<tr class = "title">
			<td>강좌번호</td>
			<td>강좌명</td>
			<td>강의실</td>
			<td>담당교수</td>
			<td>성적입력</td>
		</tr>
		<%
			CDAO cdao=new CDAO();
			ArrayList<CVO> list = cdao.list("%%");
			for(CVO vo:list){
				out.println("<tr class=row>");
				out.println("<td class = lcode>" + vo.getLcode() + "</td>");
				out.println("<td class = lname>" + vo.getLname() + "</td>");
				out.println("<td>" + vo.getRoom() + "</td>");
				out.println("<td>" + vo.getInstructor() + "</td>");
				out.println("<td><button>성적입력</button></td>");
				out.println("</tr>");
			}
		%>
	</table>
	<div id = "enroll">
		<div id ="courses">
			강좌번호 :<span id = "lcode"></span>
			강좌이름 :<span id = "lname"></span>
		</div>
		<table id = "ctbl"></table>
		<button id = "chkSave">선택수정</button>
		<script id = "temp" type = "text/x-handlebars-template">		
		<tr class = title>
			<td><input type = checkbox id = chkAll></td>
			<td>학번</td>
			<td>성명</td>
			<td>수강신청일</td>
			<td>점수</td>
			<td>수정</td>
		</tr>
		{{#each clist}}
		<tr class = row2>
			<td><input type = checkbox class = chk></td>
			<td class = scode>{{scode}}</td>
			<td class = sname>{{sname}}</td>
			<td>{{edate}}</td>
			<td><input type=text class = grade value={{grade}}></td>
			<td><button class = save>저장</button></td>	
		</tr>
		{{/each}}
	</script>
	</div>
</body>
<script>
	var lcode;
	
		$("#chkSave").on("click", function(){
			if(!confirm("선택한 학생의 점수를 수정하시겠습니까?")) return;
			$("#ctbl .row2 .chk:checked").each(function(){
				var row = $(this).parent().parent();
				var scode=row.find(".scode").html();
				var grade=row.find(".grade").val();
				$("#chkAll").prop("checked", false);
				$.ajax({
					type:"post",
					url:"update.jsp",
					data:{"scode":scode, "lcode":lcode, "grade":grade},
					success:function(){						
					}	
				});
				$(this).prop("checked",false);
			});
		});
	
	
	$("#ctbl").on("click", ".title #chkAll", function(){
		if($("#chkAll").prop("checked")){

            // 태그들을 찾아서 checked옵션을 true로 정의
            $(".chk").prop("checked",true);
            //클릭이 안되있으면
        }else{
            // chk인 태그들을 찾아서 checked옵션을 false로 정의
            $(".chk").prop("checked",false);
        }
	
	});

	$("#enroll").hide();
	$("#ctbl").hide();
	//성적입력 버튼을 클릭했을때
	$("#tbl").on("click", ".row button", function(){
		
		var row = $(this).parent().parent();
		var lcode=row.find(".lcode").html();
		var lname=row.find(".lname").html();
		$("#lcode").html(lcode);
		$("#lname").html(lname);
		$("#enroll").show();
		getList();
		$("#ctbl").show();		
	});
	
	$("#ctbl").on("click", ".row2 .save", function(){
		if(!confirm("수정하시겠습니까?")) return;
		var row2 = $(this).parent().parent();
		var scode = row2.find(".scode").html();
		var grade = row2.find(".grade").val();
		$.ajax({
			type:"get",
			url:"update.jsp",
			data:{"grade":grade,"scode":scode,"lcode":lcode},
			success:function(data){
				var temp=Handlebars.compile($("#temp").html());
				$("#ctbl").html(temp(data));
				alert("수정완료!");
				getList();
				}
			});		
		}	
	);
	
	
	//성적수정
	function save(){
		$("#ctbl").on("click", ".row2 .save", function(){
		if(!confirm("수정하시겠습니까?")) return;
		var row2 = $(this).parent().parent();
		var scode = row2.find(".scode").html();
		var grade = row2.find(".grade").val();
		$.ajax({
			type:"get",
			url:"update.jsp",
			data:{"grade":grade,"scode":scode,"lcode":lcode},
			success:function(data){
				var temp=Handlebars.compile($("#temp").html());
				$("#ctbl").html(temp(data));
				alert("수정완료!");
				getList();
				}
			});		
		}	
	);
	}
	
	
	
	function getList(){
		lcode = $("#lcode").html()
		$.ajax({
			type:"get",
			url:"json.jsp",
			dataType:"json",
			data:{"lcode":lcode},
			success:function(data){
				var temp=Handlebars.compile($("#temp").html());
				$("#ctbl").html(temp(data));			
			}
		});		
	}
	
	

</script>
</html>