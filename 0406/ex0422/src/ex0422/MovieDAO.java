package ex0422;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ex0422.MovieVO;

public class MovieDAO {

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
		public ArrayList<MovieVO> list() throws Exception{
			ArrayList<MovieVO> list = new ArrayList<MovieVO>();
			
			String sql="select * from tbl_movie order by seq_mno desc";
			PreparedStatement ps = con().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		
			while(rs.next()) {
				MovieVO vo=new MovieVO();
				vo.setMno(rs.getInt("seq_mno"));
				vo.setTitle(rs.getString("title"));
				vo.setActor(rs.getString("actor"));
				list.add(vo);
				con().close();
			}		
			return list;
		}
		
		//데이터 입력 메소드
		public void insert(MovieVO vo) throws Exception{
			String sql="insert into tbl_movie(seq_mno,title,actor) values(seq_mno.nextval, ? ,?)";
			PreparedStatement ps = con().prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getActor());
			ps.execute();
			con().close();
		}
		
		//데이터 삭제 메소드
		public void delete(int mno) throws Exception{
			String sql="delete from tbl_movie where seq_mno = ?";
			PreparedStatement ps = con().prepareStatement(sql);
			ps.setInt(1, mno);
			ps.execute();
			con().close();
		}
		/*
		//데이터 읽기 메소드
		public BoardVO read(int bno) throws Exception{
			String sql="select* from tbl_board where bno = ?";
			PreparedStatement ps = con().prepareStatement(sql);
			ps.setInt(1, bno);
			ResultSet rs = ps.executeQuery();
			
			BoardVO vo = new BoardVO();
			if(rs.next()) {
				vo.setBno(rs.getInt("bno"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
			}
			return vo;
		}
		
		  //데이타 수정
		   public void update(BoardVO vo)throws Exception{
		      String sql="update tbl_board set title=?, content=? where bno=?";
		      PreparedStatement ps=con().prepareStatement(sql);
		      ps.setString(1, vo.getTitle());
		      ps.setString(2, vo.getContent());
		      ps.setInt(3, vo.getBno());
		      ps.executeQuery();
		   }*/
}
	

