<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ex01.*" %>    
<%
	request.setCharacterEncoding("UTF-8"); //한글 안나올때 사용
	String pno = request.getParameter("pno");
	String pname = request.getParameter("pname");
	String strPrice=request.getParameter("price");
	int price=Integer.parseInt(strPrice); // string을 integer로 바꾸는
	
	ProductVO vo=new ProductVO();
	vo.setPno(pno);
	vo.setPname(pname);
	vo.setPrice(price);
	
	ProductDAO dao = new ProductDAO();
	dao.insert(vo);
%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>데이터저장</title>
</head>
<body>
	<h1>데이터가 저장되었습니다.</h1>
	<a href="list.jsp">목록으로 이동</a>
</body>
</html>