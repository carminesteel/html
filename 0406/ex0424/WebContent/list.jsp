<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ex0424.*,java.util.*,org.json.simple.*" %>
<%
	DataDAO dao = new DataDAO();
	int count = dao.count();
	
	JSONObject jObject = new JSONObject();
	jObject.put("total",count);
	
	
	ArrayList<DataVO> array = dao.list();
	JSONArray jArray = new JSONArray();
	
	for(DataVO vo:array){
		JSONObject obj = new JSONObject();
		obj.put("seq", vo.getSeq()); 
		obj.put("link", vo.getLink());
		obj.put("title", vo.getTitle());
		obj.put("description", vo.getDescription());
		jArray.add(obj);
	}
	jObject.put("items", jArray);
	
	out.println(jObject);
%>