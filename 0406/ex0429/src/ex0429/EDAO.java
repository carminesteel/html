package ex0429;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EDAO {
	 public Connection con() throws Exception{
	        String driver = "oracle.jdbc.driver.OracleDriver";
	        String url = "jdbc:oracle:thin:@localhost:1521:xe";
	        String user = "haksa";
	        String password = "pass";
	        Class.forName(driver);
	        Connection connection=DriverManager.getConnection(url, user, password);
	        return connection;
	     } 
	 //특정 교수가 담당하는 강의목록
	 public ArrayList<EVO> list(String scode)throws Exception{
	      ArrayList<EVO> list=new ArrayList<EVO>();
	      String sql="select*from view_enrollment where scode = ?";
	      System.out.println(sql);
	      PreparedStatement ps=con().prepareStatement(sql);
	      ps.setString(1, scode);
	      ResultSet rs=ps.executeQuery();  
	      while(rs.next()) {
	         EVO vo=new EVO();
	         vo.setLcode(rs.getString("lcode"));
	         vo.setLname(rs.getString("lname"));
	         vo.setScode(rs.getString("scode"));
	         vo.setSname(rs.getString("sname"));
	         vo.setEdate(rs.getString("edate"));
	         vo.setGrade(rs.getInt("grade"));
	         list.add(vo);
	      }
	      return list;
	 }
	 
	 //수강신청
	 public void insert (String lcode, String scode) throws Exception{
	      String sql="insert into enrollments(lcode, scode, edate) values (?, ?, sysdate)";
	      PreparedStatement ps=con().prepareStatement(sql);
	      ps.setString(1, lcode);
	      ps.setString(2, scode);
	      ps.execute();
	      }
	 
	 
	 //수강취소
	 public void delete (String scode, String lcode) throws Exception{
	      String sql=" delete from enrollments where scode=? and lcode=?";
	      PreparedStatement ps=con().prepareStatement(sql);
	      ps.setString(1, scode);
	      ps.setString(2, lcode);	   
	      ps.execute();
	      }
	 
	 public void update (String scode, String lcode, int grade) throws Exception{
	      String sql="update enrollments set grade = ? where scode=? and lcode = ?";
	      PreparedStatement ps=con().prepareStatement(sql);
	      ps.setInt(1, grade);
	      ps.setString(2, scode);
	      ps.setString(3, lcode);
	      ps.execute();
	      }
	 
	 //특정 강좌를 신청한 학생 목록
	 public ArrayList<EVO> clist(String lcode)throws Exception{
	      ArrayList<EVO> list=new ArrayList<EVO>();
	      String sql="select*from view_enrollment where lcode = ?";
	      System.out.println(sql);
	      PreparedStatement ps=con().prepareStatement(sql);
	      ps.setString(1, lcode);
	      ResultSet rs=ps.executeQuery();  
	      while(rs.next()) {
	         EVO vo=new EVO();
	         vo.setLcode(rs.getString("lcode"));
	         vo.setLname(rs.getString("lname"));
	         vo.setScode(rs.getString("scode"));
	         vo.setSname(rs.getString("sname"));
	         vo.setEdate(rs.getString("edate"));
	         vo.setGrade(rs.getInt("grade"));
	         list.add(vo);
	      }
	      return list;
	 }
	 
	
}
