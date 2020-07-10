<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ex0424.*,java.util.*,org.json.simple.*" %>
<%
	String seq=request.getParameter("seq");

	
	DataDAO dao = new DataDAO();
	dao.delete(seq);
%>
