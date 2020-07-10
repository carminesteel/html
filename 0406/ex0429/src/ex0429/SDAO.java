package ex0429;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SDAO {
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
	 public ArrayList<SVO> list(String pcode)throws Exception{
	      ArrayList<SVO> list=new ArrayList<SVO>();
	      String sql="select*from students where advisor like ?";
	      System.out.println(sql);
	      PreparedStatement ps=con().prepareStatement(sql);
	      ps.setString(1, pcode);
	      ResultSet rs=ps.executeQuery();  
	      while(rs.next()) {
	         SVO vo=new SVO();
	         vo.setScode(rs.getString("scode"));
	         vo.setSname(rs.getString("sname"));
	         vo.setDept(rs.getString("dept"));
	         vo.setYear(rs.getString("year"));
	         vo.setBirthday(rs.getString("birthday"));
	         vo.setAdvisor(rs.getString("advisor"));
	         list.add(vo);
	      }
	      return list;
	 }
}
