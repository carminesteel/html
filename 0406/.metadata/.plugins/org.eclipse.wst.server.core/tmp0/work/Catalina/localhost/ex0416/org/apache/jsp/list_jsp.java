/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.5
 * Generated at: 2020-04-16 06:41:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ex0416.*;
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
      out.write("    \r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<title>상품목록</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"home.css\">\r\n");
      out.write("\t<script src=\"http://code.jquery.com/jquery-1.9.1.js\"></script>\t\r\n");
      out.write("\t<style>\r\n");
      out.write("\t\t.del:hover{color:white;background:pink;cursor:pointer};\r\n");
      out.write("\t</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<h1 id=\"title\">[상품목록]</h1>\r\n");
      out.write("\t<div id=\"content\">\r\n");
      out.write("\t\r\n");
      out.write("\t\t<div id = \"menu\">\r\n");
      out.write("\t\t\t<button class=\"btn\">1</button>\r\n");
      out.write("\t\t\t<button class=\"btn\">2</button>\r\n");
      out.write("\t\t\t<button class=\"btn\">3</button>\r\n");
      out.write("\t\t\t<button class=\"btn\">4</button>\r\n");
      out.write("\t\t\t<a href=\"insert.html\" style=\"text-decoration:none;color:white\">[상품등록]</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t");

			ProductDAO dao = new ProductDAO();
			ArrayList<ProductVO> list=dao.list();
			for(int i=0; i<list.size(); i++){
				ProductVO vo = list.get(i);
				DecimalFormat df=new DecimalFormat("#,###원");
				String strPrice=df.format(vo.getPrice());
				out.println("<div class = 'box'>");
				out.println("<img src='http://placehold.it/150x150'>");
				out.println("<div class='pname'>" + vo.getPname() + "</div>");
				out.println("<div class='price'>" + strPrice + "</div>");
				out.println("<div class='del' pno="+vo.getPno() +" pname="+vo.getPname()+">"+"삭제</div>");
				out.println("</div>");
			}
		
      out.write("\r\n");
      out.write("\t</div>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        \r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"darken-background\">\r\n");
      out.write("\t\t <div id=\"lightbox\">\r\n");
      out.write("\t\t \t<img src=\"http://placehold.it/600x750\"/>\r\n");
      out.write("\t\t \t<div><button id=\"btnClose\">닫기</button></div>\r\n");
      out.write("\t\t \t<div id = \"txtName\">상품명</div>\r\n");
      out.write("\t\t \t<div id=\"txtPrice\">가격</div>\r\n");
      out.write("\t\t </div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("\t$(\".box\").on(\"click\", \".del\", function(){\r\n");
      out.write("\t\tvar pno=$(this).attr(\"pno\");\r\n");
      out.write("\t\tvar pname=$(this).attr(\"pname\");\r\n");
      out.write("\t    if(confirm(pname + \" 상품을 삭제하시겠습니까?\")==false) return;\r\n");
      out.write("\t  \tlocation.href=\"sqlDelete.jsp?pno=\"+pno;\r\n");
      out.write("\t});\r\n");
      out.write("\t    \r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\t$(\".box\").on(\"click\",\"img\",function(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar box=$(this).parent();\r\n");
      out.write("\t\tvar pname=box.find(\".pname\").html();\r\n");
      out.write("\t\tvar price=box.find(\".price\").html();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#txtName\").html(pname);\r\n");
      out.write("\t\t$(\"#txtPrice\").html(price);\r\n");
      out.write("\t\t$(\"#darken-background\").show();\t\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#btnClose\").on(\"click\",function(){\r\n");
      out.write("\t\t$(\"#darken-background\").hide();\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#menu\").on(\"click\",\".btn\", function(){\r\n");
      out.write("\t\tvar num=$(this).html();\r\n");
      out.write("\t\t$(\"#content\").css(\"width\", 190*num);\r\n");
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
