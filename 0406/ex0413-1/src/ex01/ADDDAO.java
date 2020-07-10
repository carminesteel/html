package ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ADDDAO {

public Connection con() throws Exception{
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String password = "1234";

		Class.forName(driver);
		Connection con=DriverManager.getConnection(url, user, password);
		return con;		
		}
		
		//데이터 목록 출력
		public ArrayList<ADDVO> list() throws Exception{
			
			ArrayList<ADDVO> array=new ArrayList<ADDVO>();
			String sql = "SELECT*FROM tbl_address order by ano desc";
			PreparedStatement ps = con().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {				
				ADDVO vo = new ADDVO();
				vo.setAno(rs.getInt("ano"));
				vo.setAname(rs.getString("aname"));
				vo.setTel(rs.getString("tel"));
				vo.setAddress(rs.getString("address"));				
				array.add(vo);				
			}			
			return array;
		}
		
		//데이터 입력 메소드
		public void insert(ADDVO vo) throws Exception{
			String sql="insert into tbl_address (ano, aname, tel, address) values (SEQ_address.nextval, ?, ?, ?)";
			PreparedStatement ps = con().prepareStatement(sql);
			ps.setString(1, vo.getAname());
			ps.setString(2, vo.getTel());
			ps.setString(3, vo.getAddress());			
			ps.execute();		
		}  
		
		//데이터 읽기 메소드
		public ADDVO read(int ano) throws Exception{
			String sql="SELECT*FROM tbl_address where ano = ?";
			PreparedStatement ps = con().prepareStatement(sql);
			ps.setInt(1, ano);
			ResultSet rs = ps.executeQuery();
					
			ADDVO vo = new ADDVO();
			if(rs.next()) {
				vo.setAno(rs.getInt("ano"));
				vo.setAname(rs.getString("aname"));
				vo.setTel(rs.getString("tel"));
				vo.setAddress(rs.getString("address"));
			}
			return vo;					
		}                                                          
		
		//데이터 삭제
		public void delete(int ano) throws Exception{
			String sql = "delete from tbl_address where ano=?";
			Connection con = con();
			PreparedStatement ps = con().prepareStatement(sql);
			ps.setInt(1, ano);
			ps.execute();
		}
		
		//데이터 수정
		public void update(ADDVO vo) throws Exception{
			String sql = "update tbl_address set aname = ?, tel = ?, address = ? where ano = ?";
			Connection con = con();
			PreparedStatement ps = con().prepareStatement(sql);
			ps.setString(1, vo.getAname());
			ps.setString(2, vo.getTel());
			ps.setString(3, vo.getAddress());
			ps.setInt(4, vo.getAno());
			ps.execute();
		}

}
