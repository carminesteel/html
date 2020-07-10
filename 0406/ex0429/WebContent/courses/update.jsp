<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "ex0429.*"%>
<%
	String strGrade = request.getParameter("grade");
	int grade=Integer.parseInt(strGrade);
	String scode = request.getParameter("scode");
	String lcode = request.getParameter("lcode");
	EDAO edao = new EDAO();	
	edao.update(scode, lcode, grade);
%>