<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ex0423.*,java.util.*,org.json.simple.*" %>
<%
	ShopDAO dao = new ShopDAO();
	int count = dao.count();
	
	JSONObject jObject = new JSONObject();
	jObject.put("total",count);
	
	
	ArrayList<ShopVO> array = dao.list();
	JSONArray jArray = new JSONArray();
	
	for(ShopVO vo:array){
		JSONObject obj = new JSONObject();
		obj.put("sid", vo.getSid());
		obj.put("title", vo.getTitle());
		obj.put("hprice", vo.getHprice());
		obj.put("lprice", vo.getLprice());
		obj.put("img", vo.getImg());
		jArray.add(obj);
	}
	jObject.put("items", jArray);
	
	out.println(jObject);
%>