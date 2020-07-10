<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "ex0504.*, java.util.*, org.json.simple.*, java.text.*"%>
<%
	DecimalFormat df = new DecimalFormat("###.00");
	EnrollDAO dao = new EnrollDAO();
	ArrayList<EnrollVO> list = dao.clist();
	
	JSONObject jObject = new JSONObject();
	JSONArray array = new JSONArray();
	for(EnrollVO vo:list){
		JSONObject obj = new JSONObject();
		obj.put("lcode", vo.getLcode());
		obj.put("lname", vo.getLname());
		obj.put("pname", vo.getPname());
		String avg = df.format(vo.getAvg());
		obj.put("avg", vo.getAvg());
		array.add(obj);
	}
	jObject.put("clist", array);
	
	
	
	//
	
	GDAO dao2 = new GDAO();
	ArrayList<GVO> list2 = dao2.glist();
	JSONArray array2 = new JSONArray();
	
	for(GVO vo:list2){
		JSONObject obj2 = new JSONObject();
		obj2.put("dept", vo.getDept());
		obj2.put("scode", vo.getScode());
		obj2.put("sname", vo.getSname());
		String avg = df.format(vo.getAvg());
		obj2.put("avg", vo.getAvg());
		array2.add(obj2);
}
jObject.put("glist", array2);
out.println(jObject);

%>
