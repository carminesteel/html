package ex0506;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ex0506.CVO;

public class CDAO {
	 public Connection con() throws Exception{
	        String driver = "oracle.jdbc.driver.OracleDriver";
	        String url = "jdbc:oracle:thin:@localhost:1521:xe";
	        String user = "haksa";
	        String password = "pass";
	        Class.forName(driver);
	        Connection connection=DriverManager.getConnection(url, user, password);
	        return connection;
	     }
	 
	 public ArrayList<CVO> clist()throws Exception{
		 ArrayList<CVO> list=new ArrayList<CVO>();
		 String sql="select lcode, lname, pname, room, avg(grade), count(scode) cnt from couenr group by lcode, lname, pname, room";
		 PreparedStatement ps = con().prepareStatement(sql);
		 ResultSet rs = ps.executeQuery();
		 while(rs.next()) {
			 CVO vo = new CVO();
			 vo.setLcode(rs.getString("lcode"));
			 vo.setLname(rs.getString("lname"));
			 vo.setPname(rs.getString("pname"));
			 vo.setRoom(rs.getString("room"));
			 vo.setAvg(rs.getDouble("avg(grade)"));
			 vo.setCnt(rs.getInt("cnt"));
			 list.add(vo);
			 System.out.println(vo.toString());
		 }
		 return list;		 
	 }
	 public ArrayList<CVO> glist()throws Exception{
		 ArrayList<CVO> list2=new ArrayList<CVO>();
		 String sql="select s.scode, s.sname, s.dept, avg(grade), count(lcode) from students s, enrollments e where s.scode = e.scode group by s.scode, s.sname, s.dept";
		 PreparedStatement ps = con().prepareStatement(sql);
		 ResultSet rs = ps.executeQuery();
		 while(rs.next()) {
			 CVO vo = new CVO();
			 vo.setScode(rs.getString("scode"));
			 vo.setSname(rs.getString("sname"));
			 vo.setDept(rs.getString("dept"));
			 vo.setAvg(rs.getDouble("avg(grade)"));
			 vo.setCnt(rs.getInt("count(lcode)"));
			 list2.add(vo);
			 System.out.println(vo.toString());
		 }
		 return list2;		 
	 }
	 
	 public ArrayList<CVO> slist()throws Exception{
		 ArrayList<CVO> list3=new ArrayList<CVO>();
		 String sql="select scode, sname, s.dept, pname from students s, professors p where s.advisor=p.pcode";
		 PreparedStatement ps = con().prepareStatement(sql);
		 ResultSet rs = ps.executeQuery();
		 while(rs.next()) {
			 CVO vo = new CVO();
			 vo.setScode(rs.getString("scode"));
			 vo.setSname(rs.getString("sname"));
			 vo.setDept(rs.getString("dept"));
			 vo.setPname(rs.getString("pname"));
			 list3.add(vo);
		 }
		 return list3;		 
	 }
	 
	 public ArrayList<CVO> elist(String scode)throws Exception{
		 ArrayList<CVO> list4=new ArrayList<CVO>();
		 String sql="select lcode, lname, grade from couenr where scode = ?";
		 System.out.println(sql);
		 PreparedStatement ps = con().prepareStatement(sql);
		 ps.setString(1, scode);
		 ResultSet rs = ps.executeQuery();
		 while(rs.next()) {
			 CVO vo=new CVO();
	         vo.setLcode(rs.getString("lcode"));
	         vo.setLname(rs.getString("lname"));
	         vo.setGrade(rs.getInt("grade"));
	         list4.add(vo); 		 
		 }
		 return list4;
	 }

	 public CVO avg(String scode) throws Exception{
		 CVO vo=new CVO();
		 String sql="select scode, avg(grade), count(lcode) from couenr where scode = ? group by scode";
		 PreparedStatement ps = con().prepareStatement(sql);
		 ps.setString(1, scode);
		 ResultSet rs = ps.executeQuery();
		 if(rs.next()) {			 
			 vo.setScode(rs.getString("scode"));
			 vo.setAvg(rs.getDouble("avg(grade)"));
	         vo.setCnt(rs.getInt("count(lcode)"));    
		 }	
		 return vo;
	 }
	 
}
