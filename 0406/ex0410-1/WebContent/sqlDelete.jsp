<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="ex01.*"%>
<%
	String strBno=request.getParameter("bno");
	int bno=Integer.parseInt(strBno);	
	
	BoardDAO dao = new BoardDAO();
	dao.delete(bno);
	
%>

<script>
	location.href="list.jsp"	
	alert("삭제되었습니다");
</script>