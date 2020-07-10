package ex0423;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ex0423.ShopVO;

public class ShopDAO {

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
	
		
		//데이터 입력 메소드
		public void insert(ShopVO vo) throws Exception{
			String sql="insert into tbl_shop(sid,title,lprice,hprice,wdate,img) values(?, ? ,? ,? ,sysdate,?)";
			PreparedStatement ps = con().prepareStatement(sql);
			ps.setString(1, vo.getSid());
			ps.setString(2, vo.getTitle());
			ps.setInt(3, vo.getLprice());
			ps.setInt(4, vo.getHprice());
			ps.setString(5, vo.getImg());
			ps.execute();
			con().close();
		}
		
		//전체 데이터갯수 출력
		public int count() throws Exception{
			int count=0;
			String sql="select count(*) cnt from tbl_shop";
			PreparedStatement ps = con().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				count=rs.getInt("cnt");				
			}
			con().close();
			return count;
		}
		
		public ArrayList<ShopVO> list() throws Exception{
			ArrayList<ShopVO> list = new ArrayList<ShopVO>();
			String sql = "select * from tbl_shop order by wdate desc";
			PreparedStatement ps = con().prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				ShopVO vo = new ShopVO();
				vo.setSid(rs.getString("sid"));
				vo.setTitle(rs.getString("title"));
				vo.setLprice(rs.getInt("lprice"));
				vo.setHprice(rs.getInt("hprice"));
				vo.setWdate(rs.getDate("wdate"));
				vo.setImg(rs.getString("img"));				
				list.add(vo);
			}
			
			return list;
			
		}
		
		//데이터 삭제 메소드
		public void delete(String sid) throws Exception{
			String sql="delete from tbl_shop where sid = ?";
			PreparedStatement ps = con().prepareStatement(sql);
			ps.setString(1, sid);
			ps.execute();
			con().close();
		}
		 //데이타 수정
		   public void update(ShopVO vo)throws Exception{
		      String sql="update tbl_shop set lprice=?,hprice=? where sid=?";
		      PreparedStatement ps=con().prepareStatement(sql);
		      ps.setInt(1, vo.getLprice());
		      ps.setInt(2, vo.getHprice());
		      ps.setString(3, vo.getSid());
		      ps.executeQuery();
		   }
}
	

