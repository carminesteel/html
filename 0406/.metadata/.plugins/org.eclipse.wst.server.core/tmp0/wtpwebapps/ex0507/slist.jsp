<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ex0507.*, org.json.simple.*"%>
<% 
	String scode = request.getParameter("scode");
	DAO sdao = new DAO();
	JSONObject jObject = sdao.elist(scode);
	
	out.println(jObject);
%>
	
	 