<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "ex0424.*" %>
<%

	String link = request.getParameter("link");
	String title = request.getParameter("title");
	String description = request.getParameter("description");
	
	DataVO vo = new DataVO();
	vo.setLink(link);
	vo.setTitle(title);
	vo.setDescription(description);
	
	DataDAO dao = new DataDAO();
	dao.insert(vo);
	
%>
