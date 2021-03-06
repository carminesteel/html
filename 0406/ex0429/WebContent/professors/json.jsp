<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="ex0429.*, java.util.*, org.json.simple.*" %>
<%
	String pcode = request.getParameter("pcode");
	SDAO sdao = new SDAO();
	ArrayList<SVO> slist = sdao.list(pcode);
	
	CDAO cdao = new CDAO();
	ArrayList<CVO> clist=cdao.list(pcode);
	
	JSONObject jObject=new JSONObject();
	
	JSONArray sarray = new JSONArray();
	for(SVO vo:slist){
		JSONObject obj = new JSONObject();
		obj.put("scode",vo.getScode());
		obj.put("sname",vo.getSname());
		obj.put("dept",vo.getDept());
		obj.put("year",vo.getYear());
		obj.put("birthday",vo.getBirthday());
		obj.put("advisor",vo.getAdvisor());	
		
		sarray.add(obj);		
	}
	
	JSONArray carray = new JSONArray();
	for(CVO vo:clist){
		JSONObject obj = new JSONObject();
		obj.put("lcode",vo.getLcode());
		obj.put("lname",vo.getLname());
		obj.put("hours",vo.getHours());
		obj.put("room",vo.getRoom());
		obj.put("instructor",vo.getInstructor());
		obj.put("capacity",vo.getCapacity());	
		obj.put("persons",vo.getPersons());	
		
		carray.add(obj);		
	}
	
	jObject.put("slist", sarray);
	jObject.put("clist", carray);
	out.println(jObject);
	
	

%>