package ex0416;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ex0416.ProductVO;

public class ProductDAO {
	
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
		public ArrayList<ProductVO> list() throws Exception{
			ArrayList<ProductVO> list = new ArrayList<ProductVO>();
			
			String sql="select * from tbl_product order by pno desc";
			PreparedStatement ps = con().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		
			while(rs.next()) {
				ProductVO vo=new ProductVO();
				vo.setPno(rs.getString("pno"));
				vo.setPname(rs.getString("pname"));
				vo.setPrice(rs.getInt("price"));
				list.add(vo);
				con().close();
			}		
			return list;
		}
		
		//데이터 입력 메소드
		public void insert(ProductVO vo) throws Exception{
			String sql="insert into tbl_product(pno,pname,price) values(sql_pno.nextval, ? ,?)";
			PreparedStatement ps = con().prepareStatement(sql);
			ps.setString(1, vo.getPname());
			ps.setInt(2, vo.getPrice());
			ps.execute();
			con().close();
		}
		
		//데이터 삭제 메소드
		public void delete(int pno) throws Exception{
			String sql="delete from tbl_product where pno = ?";
			PreparedStatement ps = con().prepareStatement(sql);
			ps.setInt(1, pno);
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
