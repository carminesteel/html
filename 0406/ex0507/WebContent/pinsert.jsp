<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "ex0507.*, java.text.*, java.util.*, org.json.simple.*" %>

<% 
	String pcode = request.getParameter("pcode");
	String pname = request.getParameter("pname");
	
	DAO dao = new DAO();
	ArrayList<PVO> list = dao.pinsert(pcode,pname);
	
	JSONArray array = new JSONArray();
	for(PVO vo:list){
		JSONObject obj = new JSONObject();
		obj.put("pcode", vo.getPcode());
		obj.put("pname", vo.getPname());
		array.add(obj);
	}
	
	out.println(array);
%>