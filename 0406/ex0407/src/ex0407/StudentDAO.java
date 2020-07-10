package ex0407;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ex0407.StudentVO;

public class StudentDAO extends StudentVO {
	
	//데이터접속	
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
		//데이터입력
		public void insert(StudentVO vo)throws Exception{
			String sql="insert into tbl_student1(sno,sname,tel,address) values(?,?,?,?)";
			PreparedStatement ps=con().prepareStatement(sql);
			ps.setString(1,vo.getSno());
			ps.setString(2,vo.getSname());
			ps.setString(3,vo.getTel());
			ps.setString(4,vo.getAddress());
			ps.execute();
		}	
		//조회
		//데이터 목록
				public ArrayList<StudentVO> list() throws Exception{
					ArrayList<StudentVO> array=new ArrayList<StudentVO>();
					String sql="select * from tbl_student1";
					PreparedStatement ps=con().prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					
					while(rs.next()) {
						StudentVO vo=new StudentVO();
						vo.setSno(rs.getString("sno"));
						vo.setSname(rs.getString("sname"));
						vo.setTel(rs.getString("tel"));
						vo.setAddress(rs.getString("address"));
						array.add(vo);				
					}			
					return array;
				}
		}		

