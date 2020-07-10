package ex01;

import java.sql.*;
import java.util.ArrayList;

public class PDAO {
	public Connection con() throws Exception{
		
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "system";
	String password = "1234";

	Class.forName(driver);
	Connection con=DriverManager.getConnection(url, user, password);
	String sql=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	return con;
	
	}
	
	public ArrayList<PVO> list() throws Exception{
		ArrayList<PVO> array = new ArrayList<PVO>();
		
		String sql="select * from tbl_product";
		PreparedStatement ps = con().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
	
		while(rs.next()) {
			PVO vo = new PVO();
			vo.setPno(rs.getString("pno"));
			vo.setPname(rs.getString("pname"));
			vo.setPrice(rs.getInt("price"));
			array.add(vo);
		}		
		return array;
	}
	
	
}