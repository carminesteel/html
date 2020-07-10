/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.5
 * Generated at: 2020-05-06 07:15:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.sun.org.apache.xerces.internal.impl.dv.xs.DecimalDV;
import ex0506.*;
import java.util.*;
import java.text.*;

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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<title>강좌별 평균점수</title>\r\n");
      out.write("\t<script src=\"http://code.jquery.com/jquery-1.9.1.js\"></script>\r\n");
      out.write(" \t<script src=\"https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<h1>강좌별점수</h1>\t\r\n");
      out.write("\t<table id = \"tbl\" border = 1  width=700>\r\n");
      out.write("\t\r\n");
      out.write("\t\t<tr class = title>\r\n");
      out.write("\t\t\t<td>lcode</td>\r\n");
      out.write("\t\t\t<td>lname</td>\r\n");
      out.write("\t\t\t<td>instructor</td>\r\n");
      out.write("\t\t\t<td>room</td>\r\n");
      out.write("\t\t\t<td>avg</td>\r\n");
      out.write("\t\t\t<td>cnt</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");

		CDAO dao = new CDAO();
		ArrayList<CVO> list = dao.clist();
		for(CVO vo:list){
			out.println("<tr>");
			out.println("<td>"+vo.getLcode() + "</td>");
			out.println("<td>"+vo.getLname() + "</td>");
			out.println("<td>"+vo.getPname() + "</td>");
			out.println("<td>"+vo.getRoom() + "</td>");
			DecimalFormat df = new DecimalFormat("#0.00");
			String strAvg=df.format(vo.getAvg());
			out.println("<td>"+ strAvg + "</td>");
			out.println("<td>"+vo.getCnt() + "</td>");
			out.println("</tr>");
		}
		
      out.write("\r\n");
      out.write("\t</table>\r\n");
      out.write("\t\r\n");
      out.write("\t<h1>[학생별 평균점수]</h1>\r\n");
      out.write("\t<table border=1 width=700>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>scode</td>\r\n");
      out.write("\t\t\t<td>sname</td>\r\n");
      out.write("\t\t\t<td>dept</td>\r\n");
      out.write("\t\t\t<td>avg</td>\r\n");
      out.write("\t\t\t<td>cnt</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");

		CDAO dao2 = new CDAO();
		ArrayList<CVO> list2 = dao.glist();
		for(CVO vo:list2){
			out.println("<tr>");
			out.println("<td>"+vo.getScode() + "</td>");
			out.println("<td>"+vo.getSname() + "</td>");
			out.println("<td>"+vo.getDept() + "</td>");
			DecimalFormat df = new DecimalFormat("#0.00");
			String strAvg=df.format(vo.getAvg());
			out.println("<td>"+ strAvg + "</td>");
			out.println("<td>"+vo.getCnt() + "</td>");
			out.println("</tr>");
		}
		
      out.write("\r\n");
      out.write("\t</table>\r\n");
      out.write("\t\r\n");
      out.write("\t<h1>학생목록</h1>\t\r\n");
      out.write("\t<table id = \"stbl\" border = 1  width=700>\r\n");
      out.write("\t\r\n");
      out.write("\t\t<tr class = stitle>\r\n");
      out.write("\t\t\t<td>학번</td>\r\n");
      out.write("\t\t\t<td>학생명</td>\r\n");
      out.write("\t\t\t<td>학과</td>\r\n");
      out.write("\t\t\t<td>지도교수명</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");

		CDAO dao3 = new CDAO();
		ArrayList<CVO> list3 = dao.slist();
		for(CVO vo:list3){
			out.println("<tr class = srow>");
			out.println("<td class = scode>"+vo.getScode() + "</td>");
			out.println("<td>"+vo.getSname() + "</td>");
			out.println("<td>"+vo.getDept() + "</td>");
			out.println("<td>"+vo.getPname() + "</td>");
			out.println("</tr>");
		}
		
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<div id = \"시팔\" style=display:none>\r\n");
      out.write("\t\t<h1 id = cnthead>해당학생 점수 목록</h1>\r\n");
      out.write("\t\t<table id = \"cntbl\" border = 1  width=700></table>\r\n");
      out.write("\t\t<script id = \"cntemp\" type = \"text/x-handlebars-template\">\r\n");
      out.write("\t\t<tr class = cntitle>\r\n");
      out.write("\t\t\t<td>학번 : {{scode}}</td>\r\n");
      out.write("\t\t\t<td>수강 수 : {{cnt}}</td>\r\n");
      out.write("\t\t\t<td>평균 : {{avg}}</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<table id = \"etbl\" border = 1  width=700></table>\r\n");
      out.write("\t\t<script id = \"etemp\" type = \"text/x-handlebars-template\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr class = etitle>\r\n");
      out.write("\t\t\t<td>강의코드</td>\r\n");
      out.write("\t\t\t<td>강의명</td>\r\n");
      out.write("\t\t\t<td>점수</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t{{#each elist}}\r\n");
      out.write("\t\t<tr class = erow>\r\n");
      out.write("\t\t\t<td>{{lcode}}</td>\r\n");
      out.write("\t\t\t<td>{{lname}}</td>\r\n");
      out.write("\t\t\t<td>{{grade}}</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t{{/each}}\r\n");
      out.write("\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("\t$(\"#stbl\").on(\"click\",\".srow\", function(){\r\n");
      out.write("\t\t$(\"#시팔\").show();\r\n");
      out.write("\t\tvar row = $(this);\r\n");
      out.write("\t\tvar scode = row.find(\".scode\").html();\r\n");
      out.write("\t\talert(scode)\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype:\"get\",\r\n");
      out.write("\t\t\turl:\"json.jsp\",\r\n");
      out.write("\t\t\tdataType:\"json\",\r\n");
      out.write("\t\t\tdata:{\"scode\":scode},\r\n");
      out.write("\t\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t\tvar etemp=Handlebars.compile($(\"#etemp\").html());\r\n");
      out.write("\t\t\t\t$(\"#etbl\").html(etemp(data));\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tvar cntemp=Handlebars.compile($(\"#cntemp\").html());\r\n");
      out.write("\t\t\t\t$(\"#cntbl\").html(cntemp(data));\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\t\t\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\r\n");
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