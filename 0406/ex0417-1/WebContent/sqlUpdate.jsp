<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ex0417.*"%>

<% 

	String strRno=request.getParameter("rno");
	int rno=Integer.parseInt(strRno);
	
	ReplyDAO dao = new ReplyDAO();
	dao.update(rno);

%>

<script>
	alert("추천하셨습니다.");
	location.href="list.jsp";
</script>
