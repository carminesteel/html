package ex0424;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ex0424.DataVO;

public class DataDAO {
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
		public void insert(DataVO vo) throws Exception{
			String sql="insert into tbl_data(seq,link,title,description) values(seq_data.nextval, ?, ? ,?)";
			PreparedStatement ps = con().prepareStatement(sql);
			ps.setString(1, vo.getLink());
			ps.setString(2, vo.getTitle());
			ps.setString(3, vo.getDescription());
			ps.execute();
			con().close();
		}
		
		//전체 데이터갯수 출력
		public int count() throws Exception{
			int count=0;
			String sql="select count(*) cnt from tbl_data";
			PreparedStatement ps = con().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				count=rs.getInt("cnt");				
			}
			con().close();
			return count;
		}
		
		//전체 데이터목록 추가순 출력
		public ArrayList<DataVO> list() throws Exception{
			ArrayList<DataVO> list = new ArrayList<DataVO>();
			String sql = "select * from tbl_data order by seq desc";
			PreparedStatement ps = con().prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				DataVO vo = new DataVO();
				vo.setSeq(rs.getString("seq"));
				vo.setLink(rs.getString("link"));
				vo.setTitle(rs.getString("title"));
				vo.setDescription(rs.getString("description"));		
				list.add(vo);
			}
			
			return list;
			
		}
		
		//전체 데이터목록 제목순 출력
		public ArrayList<DataVO> list2() throws Exception{
			ArrayList<DataVO> list = new ArrayList<DataVO>();
			String sql = "select * from tbl_data order by title desc";
			PreparedStatement ps = con().prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				DataVO vo = new DataVO();
				vo.setSeq(rs.getString("seq"));
				vo.setLink(rs.getString("link"));
				vo.setTitle(rs.getString("title"));
				vo.setDescription(rs.getString("description"));		
				list.add(vo);
			}
			
			return list;
			
		}
		
		//데이터 삭제 메소드
		public void delete(String seq) throws Exception{
			String sql="delete from tbl_data where seq = ?";
			PreparedStatement ps = con().prepareStatement(sql);
			ps.setString(1, seq);
			ps.execute();
			con().close();
		}
		
		//데이타 수정
		   public void update(DataVO vo)throws Exception{
		      String sql="update tbl_data set title=?, description=? where seq=?";
		      PreparedStatement ps=con().prepareStatement(sql);
		      ps.setString(1, vo.getTitle());
		      ps.setString(2, vo.getDescription());
		      ps.setString(3, vo.getSeq());
		      ps.executeQuery();
		   }
}
