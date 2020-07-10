package ex0428;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class EDAO {
public Connection con() throws Exception{
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "haksa";
		String password = "pass";

		Class.forName(driver);
		Connection con=DriverManager.getConnection(url, user, password);
		return con;		
	}

	//수강신청 목록 출력
	public ArrayList<EVO> list(String lcode)throws Exception{
		ArrayList<EVO> list = new ArrayList<EVO>();
		String sql = "select * from view_enrollment where lcode=?";
		PreparedStatement ps = con().prepareStatement(sql);
		ps.setString(1, lcode);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			EVO vo = new EVO();
			vo.setLcode(rs.getString("lcode"));
			vo.setLname(rs.getString("lname"));
			vo.setScode(rs.getString("scode"));
			vo.setSname(rs.getString("sname"));
			vo.setEdate(rs.getDate("edate"));
			vo.setGrade(rs.getInt("grade"));
			list.add(vo);
		}
		
		return list;		
	}
	
	//학생이 신청한 수강신청 과목수
	
	public int count(String lcode) throws Exception{
		int count =0;
		String sql="select count(*) cnt from enrollments where lcode=?";
		PreparedStatement ps = con().prepareStatement(sql);
		ps.setString(1, lcode);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			count=rs.getInt("cnt");
		}
		return count;
	}

}
