package ex0417;
import java.util.*;
import java.sql.*;
import java.text.*;
public class GradeDAO {

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
		public ArrayList<GradeVO> list() throws Exception{
			
			ArrayList<GradeVO> array=new ArrayList<GradeVO>();
			String sql = "SELECT*FROM tbl_grade order by gno desc";
			PreparedStatement ps = con().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {				
				GradeVO vo = new GradeVO();
				vo.setGno(rs.getInt("gno"));
				vo.setGname(rs.getString("gname"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
				array.add(vo);				
			}			
			return array;
		}
		
		//데이터 입력 메소드
		public void insert(GradeVO vo) throws Exception{
			String sql="insert into tbl_grade (gno, gname, kor, eng, mat) values (seq_gno.nextval, ?, ?, ?, ?)";
			PreparedStatement ps = con().prepareStatement(sql);
			ps.setString(1, vo.getGname());
			ps.setInt(2, vo.getKor());
			ps.setInt(3, vo.getEng());
			ps.setInt(4, vo.getMat());			
			ps.execute();		
		}  
		
		//데이터 읽기 메소드
		public GradeVO read(int gno) throws Exception{
			String sql="SELECT*FROM tbl_grade where gno = ?";
			PreparedStatement ps = con().prepareStatement(sql);
			ps.setInt(1, gno);
			ResultSet rs = ps.executeQuery();
					
			GradeVO vo = new GradeVO();
			if(rs.next()) {
				vo.setGno(rs.getInt("gno"));
				vo.setGname(rs.getString("gname"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
			}
			return vo;					
		}                                                          
		
		//데이터 삭제
		public void delete(int gno) throws Exception{
			String sql = "delete from tbl_grade where gno=?";
			Connection con = con();
			PreparedStatement ps = con().prepareStatement(sql);
			ps.setInt(1, gno);
			ps.execute();
		}
		
		//데이터 수정
		public void update(GradeVO vo) throws Exception{
			String sql = "update tbl_grade set gname = ?, kor = ?, eng = ?, mat = ? where gno = ?";
			Connection con = con();
			PreparedStatement ps = con().prepareStatement(sql);
			ps.setString(1, vo.getGname());
			ps.setInt(2, vo.getKor());
			ps.setInt(3, vo.getEng());
			ps.setInt(4, vo.getMat());
			ps.setInt(5, vo.getGno());
			ps.execute();
		}

}
