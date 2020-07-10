<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ex0424.*,java.util.*,org.json.simple.*" %>
<%
	String seq=request.getParameter("seq");
	out.print(seq);
	
	String title=request.getParameter("title");
	out.print(title);
	
	DataVO vo = new DataVO();
	vo.setSeq(seq);
	vo.setTitle(title);
	DataDAO dao = new DataDAO();
	dao.update(vo);
%>