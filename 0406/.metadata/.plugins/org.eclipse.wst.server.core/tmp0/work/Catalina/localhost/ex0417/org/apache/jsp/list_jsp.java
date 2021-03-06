/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.5
 * Generated at: 2020-04-17 03:56:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ex0417.*;
import java.util.*;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<title>Insert title here</title>\r\n");
      out.write("\t<script src=\"http://code.jquery.com/jquery-1.9.1.js\"></script>\r\n");
      out.write("\t<style>\r\n");
      out.write("\t\th1 {text-align:center}\r\n");
      out.write("\t\t#content {width:500px;background:gray;color:white;text-align:center;margin:auto;padding:30px;}\r\n");
      out.write("\t\t#tbl {margin:auto;border-color:gray;border-collapse:collapse;background:white;color:black;}\r\n");
      out.write("\t\ttd{text-align:center;}\r\n");
      out.write("\t\tinput{text-align:right;}\r\n");
      out.write("\t</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h1>[성적처리]</h1>\r\n");
      out.write("\t<div id=\"content\">\r\n");
      out.write("\t\t이름:<input type=\"text\" id=\"txtName\">\r\n");
      out.write("\t\t<hr>\r\n");
      out.write("\t\t국어:<input type=\"text\" id=\"txtKor\">\r\n");
      out.write("\t\t<hr>\r\n");
      out.write("\t\t영어:<input type=\"text\" id=\"txtEng\">\r\n");
      out.write("\t\t<hr>\r\n");
      out.write("\t\t수학:<input type=\"text\" id=\"txtMat\">\r\n");
      out.write("\t\t<hr>\r\n");
      out.write("\t\t<input type=\"button\" value=\"등록\" id=\"btnInsert\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<h3>[성적목록]</h3>\r\n");
      out.write("\t\t<table id=\"tbl\" border=1 width=500px>\r\n");
      out.write("\t\t\t<tr class=\"title\">\r\n");
      out.write("\t\t\t\t<td>No.</td>\r\n");
      out.write("\t\t\t\t<td>이름</td>\r\n");
      out.write("\t\t\t\t<td>국어</td>\r\n");
      out.write("\t\t\t\t<td>영어</td>\r\n");
      out.write("\t\t\t\t<td>수학</td>\r\n");
      out.write("\t\t\t\t<td>수정</td>\r\n");
      out.write("\t\t\t\t<td>삭제</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t");
			
				GradeDAO dao = new GradeDAO();
				ArrayList<GradeVO> list = dao.list();
				for(int i=0; i<list.size(); i++){
					GradeVO vo = list.get(i);
					int gno=vo.getGno();
					String gname=vo.getGname();
					int kor=vo.getKor();
					int eng=vo.getEng();
					int mat=vo.getMat();
					out.println("<tr class='row'>");
					out.println("<td class='gno'>"+gno+"</td>");
					out.println("<td class='gname'>"+gname+"</td>");
					out.println("<td><input class='kor' type='text' size=2 value="+kor+"></td>");
					out.println("<td><input class='eng' type='text' size=2 value="+eng+"></td>");
					out.println("<td><input class='mat' type='text' size=2 value="+mat+"></td>");
					out.println("<td><button class='update'>수정</button></td>");
					out.println("<td><button class='delete'>삭제</button></td>");
				}
			
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("\t$(\"#tbl\").on(\"click\", \".row .delete\",function(){\r\n");
      out.write("\t\tvar row=$(this).parent().parent();\r\n");
      out.write("\t\tvar gno=row.find(\".gno\").html();\r\n");
      out.write("\t\tif(confirm(gno+\"번을 삭제하시겠습니까?\")==false)return;\r\n");
      out.write("\t\tlocation.href=\"sqlDelete.jsp?gno=\"+gno;\r\n");
      out.write("\t\talert(gno);\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#tbl\").on(\"click\", \".row .update\",function(){\r\n");
      out.write("\t\tvar row=$(this).parent().parent();\r\n");
      out.write("\t\tvar gno=row.find(\".gno\").html();\r\n");
      out.write("\t\tvar kor=row.find(\".kor\").val();\r\n");
      out.write("\t\tvar eng=row.find(\".eng\").val();\r\n");
      out.write("\t\tvar mat=row.find(\".mat\").val();\r\n");
      out.write("\t\tif(confirm(\"수정하시겠습니까?\")==false)return;\r\n");
      out.write("\t\tlocation.href=\"sqlUpdate.jsp?gno=\"+gno+\"&kor=\"+kor+\"&eng=\"+eng+\"&mat=\"+mat;\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#btnInsert\").on(\"click\", function(){\r\n");
      out.write("\t\tif(confirm(\"저장하시겠습니까\")==false) return;\r\n");
      out.write("\t\tvar gname=$(\"#txtName\").val();\r\n");
      out.write("\t\tvar kor=$(\"#txtKor\").val();\r\n");
      out.write("\t\tvar eng=$(\"#txtEng\").val();\r\n");
      out.write("\t\tvar mat=$(\"#txtMat\").val();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(gname==\"\"){\r\n");
      out.write("\t\t\talert(\"이름을 입력하세요!\");\r\n");
      out.write("\t\t\t$(\"#txtName\").val(\"\");\r\n");
      out.write("\t\t\t$(\"#txtName\").focus();\r\n");
      out.write("\t\t}else if(kor==\"\"||kor.replace(/[0-9]/g,'')){\r\n");
      out.write("\t\t\talert(\"점수를 숫자로 입력하세요!\");\r\n");
      out.write("\t\t\t$(\"#txtKor\").val(\"\");\r\n");
      out.write("\t\t\t$(\"#txtKor\").focus(\"\");\r\n");
      out.write("\t\t}else if(eng==\"\"||eng.replace(/[0-9]/g,'')){\r\n");
      out.write("\t\t\talert(\"점수를 숫자로 입력하세요!\");\r\n");
      out.write("\t\t\t$(\"#txtEng\").val(\"\");\r\n");
      out.write("\t\t\t$(\"#txtEng\").focus(\"\");\r\n");
      out.write("\t\t}else if(mat==\"\"||mat.replace(/[0-9]/g,'')){\r\n");
      out.write("\t\t\talert(\"점수를 숫자로 입력하세요!\");\r\n");
      out.write("\t\t\t$(\"#txtMat\").val(\"\");\r\n");
      out.write("\t\t\t$(\"#txtMat\").focus(\"\");\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tlocation.href=\"sqlInsert.jsp?gname=\"+gname+\"&kor=\"+kor+\"&eng=\"+eng+\"&mat=\"+mat;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
