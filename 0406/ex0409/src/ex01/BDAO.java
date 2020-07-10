package ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BDAO {
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
	
		//데이터 출력 메소드	
		public ArrayList<BVO> list() throws Exception{
			ArrayList<BVO> array = new ArrayList<BVO>();
			
			String sql="select * from tbl_blog order by bno desc";
			PreparedStatement ps = con().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		
			while(rs.next()) {
				BVO vo=new BVO();
				vo.setBno(rs.getInt("bno"));
				vo.setTitle(rs.getString("title"));
				vo.setWdate(rs.getDate("wdate"));
				vo.setArticle(rs.getString("article"));
				array.add(vo);
			}		
			return array;
		}
		
		//데이터 입력 메소드
		public void insert(BVO vo) throws Exception{
			String sql="insert into tbl_blog(bno,title,wdate,article) values(seq.nextval, ? ,sysdate, ? )";
			PreparedStatement ps = con().prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getArticle());
			ps.execute();
			con().close();
		}
		
		//데이터 삭제 메소드
		public void delete(int bno) throws Exception{
			String sql="delete from tbl_blog where bno = ?";
			PreparedStatement ps = con().prepareStatement(sql);
			ps.setInt(1, bno);
			ps.execute();
			con().close();
		}
		
}
