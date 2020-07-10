package ex0417;

import java.sql.*;
import java.util.*;

public class ReplyDAO {

public Connection con() throws Exception{
	
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String password = "1234";
	
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url, user, password);
		return con;		
	}
					
		//목록출력 메서드
		public ArrayList<ReplyVO> list()throws Exception{
		   ArrayList<ReplyVO> list=new ArrayList<ReplyVO>();
		   String sql="select * from tbl_reply order by rno desc";
		   PreparedStatement ps=con().prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   while(rs.next()) {
		      ReplyVO vo=new ReplyVO();
		      vo.setRno(rs.getInt("rno"));
		      vo.setContent(rs.getString("content"));
		      vo.setWdate(rs.getTimestamp("wdate"));
		      vo.setCnt(rs.getInt("cnt"));
		      list.add(vo);
		   }
		   return list;
		}
		
		//데이터 입력 메소드
		public void insert(ReplyVO vo) throws Exception{
			String sql="insert into tbl_reply (rno, content, wdate, cnt) values (seq_rno.nextval, ?, sysdate, 0)";
			PreparedStatement ps = con().prepareStatement(sql);
			ps.setString(1, vo.getContent());		
			ps.execute();		
		}  
		//데이터 삭제
		public void delete(int rno) throws Exception{
			String sql = "delete from tbl_reply where rno=?";
			Connection con = con();
			PreparedStatement ps = con().prepareStatement(sql);
			ps.setInt(1, rno);
			ps.execute();
		}
		

}
