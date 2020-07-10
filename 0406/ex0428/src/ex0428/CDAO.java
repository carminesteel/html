package ex0428;
import java.sql.*;
import java.util.*;
public class CDAO{
   public Connection con() throws Exception{
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "haksa";
        String password = "pass";
        Class.forName(driver);
        Connection connection=DriverManager.getConnection(url, user, password);
        return connection;
     } 
 //학생목록 출력
   public ArrayList<CVO> list(String type, String word)throws Exception{
      ArrayList<CVO> list=new ArrayList<CVO>();
      String sql="select*from view_course where " + type + " like ?";
      System.out.println(sql);
      PreparedStatement ps=con().prepareStatement(sql);
      ps.setString(1,"%" + word + "%");
      ResultSet rs=ps.executeQuery();  
      while(rs.next()) {
         CVO vo=new CVO();
         vo.setLcode(rs.getString("lcode"));
         vo.setLname(rs.getString("lname"));
         vo.setRoom(rs.getString("room"));
         vo.setPname(rs.getString("Pname"));
         vo.setDept(rs.getString("dept"));
         list.add(vo);
      }
      return list;
   }
}