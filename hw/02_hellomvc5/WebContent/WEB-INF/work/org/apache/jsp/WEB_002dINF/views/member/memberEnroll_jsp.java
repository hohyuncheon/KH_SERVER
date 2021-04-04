/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.44
 * Generated at: 2021-03-31 08:02:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import member.model.service.MemberService;
import member.model.vo.Member;

public final class memberEnroll_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1617176426664L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jsp", Long.valueOf(1616656760773L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("member.model.service.MemberService");
    _jspx_imports_classes.add("member.model.vo.Member");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

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

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	String msg = (String)session.getAttribute("msg");
	if(msg != null) session.removeAttribute("msg");
	
	String loc = (String)request.getAttribute("loc");
	Member loginMember = (Member)session.getAttribute("loginMember");
	
	//사용자 쿠키처리
	String saveId = null;
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(Cookie c : cookies){
			String name = c.getName();
			String value = c.getValue();
			//System.out.println(name + " : " + value);
			if("saveId".equals(name))
				saveId = value;
		}
	}
	

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Hello MVC</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print( request.getContextPath() );
      out.write("/css/style.css\" />\r\n");
      out.write("<script src=\"");
      out.print( request.getContextPath() );
      out.write("/js/jquery-3.6.0.js\"></script>\r\n");
      out.write("<script>\r\n");
 if(msg != null) { 
      out.write(" \r\n");
      out.write("\talert(\"");
      out.print( msg );
      out.write("\"); \r\n");
 } 
      out.write("\r\n");
      out.write("\r\n");
 if(loc != null) { 
      out.write("\r\n");
      out.write("\tlocation.href = \"");
      out.print( loc );
      out.write("\";\r\n");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("$(function(){\r\n");
      out.write("\t/**\r\n");
      out.write("\t* 로그인 폼 유효성 검사 \r\n");
      out.write("\t*/\r\n");
      out.write("\t$(\"#loginFrm\").submit(function(){\r\n");
      out.write("\t\tvar $memberId = $(memberId);\r\n");
      out.write("\t\tvar $password = $(password);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(/^.{4,}$/.test($memberId.val()) == false){\r\n");
      out.write("\t\t\talert(\"유효한 아이디를 입력하세요.\");\r\n");
      out.write("\t\t\t$memberId.select();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(/^.{4,}$/.test($password.val()) == false){\r\n");
      out.write("\t\t\talert(\"유효한 비밀번호를 입력하세요.\");\r\n");
      out.write("\t\t\t$password.select();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"container\">\r\n");
      out.write("\t\t<header>\r\n");
      out.write("\t\t\t<h1>Hello MVC</h1>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"login-container\">\r\n");
      out.write("\t\t\t");
 if(loginMember == null) { 
      out.write("\r\n");
      out.write("\t\t\t\t<!-- 로그인폼 시작 -->\r\n");
      out.write("\t\t\t\t<form id=\"loginFrm\" action=\"");
      out.print( request.getContextPath() );
      out.write("/member/login\" method=\"POST\">\r\n");
      out.write("\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input \r\n");
      out.write("\t\t\t\t\t\t\t\t\ttype=\"text\" name=\"memberId\" id=\"memberId\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\tplaceholder=\"아이디\" tabindex=\"1\" value=\"");
      out.print( saveId != null ? saveId : "" );
      out.write("\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"submit\" value=\"로그인\" tabindex=\"3\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"password\" name=\"password\" id=\"password\" placeholder=\"비밀번호\" tabindex=\"2\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"saveId\" id=\"saveId\" ");
      out.print( saveId != null ? "checked" : "");
      out.write("/>\r\n");
      out.write("\t\t\t\t\t\t\t\t<label for=\"saveId\">아이디저장</label>&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"button\" value=\"회원가입\" onclick=\"location.href='");
      out.print( request.getContextPath() );
      out.write("/member/memberEnroll';\">\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t<!-- 로그인폼 끝-->\r\n");
      out.write("\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t<table id=\"login\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print( loginMember.getMemberName() );
      out.write("님, 안녕하세요.</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td> \r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"button\" value=\"내정보보기\" onclick=\"location.href='");
      out.print( request.getContextPath() );
      out.write("/member/memberView';\"/>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"button\" value=\"로그아웃\" \r\n");
      out.write("\t\t\t\t\t\t\t\tonclick=\"location.href='");
      out.print( request.getContextPath() );
      out.write("/member/logout';\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t");
 } 
      out.write("\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- 메인메뉴 시작 -->\r\n");
      out.write("\t\t\t<nav>\r\n");
      out.write("\t\t\t\t<ul class=\"main-nav\">\r\n");
      out.write("\t\t\t\t\t<li class=\"home\"><a href=\"");
      out.print( request.getContextPath() );
      out.write("\">Home</a></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"notice\"><a href=\"#\">공지사항</a></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"board\"><a href=\"#\">게시판</a></li>\r\n");
      out.write("\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t");
 if(loginMember != null && MemberService.ADMIN_ROLE.equals(loginMember.getMemberRole())){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t<li class=\"members\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/admin/memberList\">회원관리</a></li>\r\n");
      out.write("\t\t\t\t\t");
 }
      out.write("\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</nav>\r\n");
      out.write("\t\t\t<!-- 메인메뉴 끝-->\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</header>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<section id=\"content\">");
      out.write("\r\n");
      out.write("<form name=\"checkIdDuplicateFrm\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"memberId\" />\r\n");
      out.write("</form>\r\n");
      out.write("<section id=enroll-container>\r\n");
      out.write("\t<h2>회원 가입 정보 입력</h2>\r\n");
      out.write("\t<form name=\"memberEnrollFrm\" action=\"");
      out.print( request.getContextPath() );
      out.write("/member/memberEnroll\" method=\"post\">\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>아이디<sup>*</sup></th>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" placeholder=\"4글자이상\" name=\"memberId\" id=\"memberId_\" required>\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" value=\"중복검사\" onclick=\"checkIdDuplicate();\" />\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" id=\"idValid\" value=\"0\" />\r\n");
      out.write("\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>패스워드<sup>*</sup></th>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<input type=\"password\" name=\"password\" id=\"password_\" required><br>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>패스워드확인<sup>*</sup></th>\r\n");
      out.write("\t\t\t\t<td>\t\r\n");
      out.write("\t\t\t\t\t<input type=\"password\" id=\"password2\" required><br>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>  \r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>이름<sup>*</sup></th>\r\n");
      out.write("\t\t\t\t<td>\t\r\n");
      out.write("\t\t\t\t<input type=\"text\"  name=\"memberName\" id=\"memberName\" required><br>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>생년월일</th>\r\n");
      out.write("\t\t\t\t<td>\t\r\n");
      out.write("\t\t\t\t<input type=\"date\" name=\"birthday\" id=\"birthday\" ><br />\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr> \r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>이메일</th>\r\n");
      out.write("\t\t\t\t<td>\t\r\n");
      out.write("\t\t\t\t\t<input type=\"email\" placeholder=\"abc@xyz.com\" name=\"email\" id=\"email\"><br>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>휴대폰<sup>*</sup></th>\r\n");
      out.write("\t\t\t\t<td>\t\r\n");
      out.write("\t\t\t\t\t<input type=\"tel\" placeholder=\"(-없이)01012345678\" name=\"phone\" id=\"phone\" maxlength=\"11\" required><br>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>주소</th>\r\n");
      out.write("\t\t\t\t<td>\t\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" placeholder=\"\" name=\"address\" id=\"address\"><br>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>성별 </th>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"gender\" id=\"gender0\" value=\"M\" checked>\r\n");
      out.write("\t\t\t\t\t<label for=\"gender0\">남</label>\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"gender\" id=\"gender1\" value=\"F\">\r\n");
      out.write("\t\t\t\t\t<label for=\"gender1\">여</label>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>취미 </th>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<input type=\"checkbox\" name=\"hobby\" id=\"hobby0\" value=\"운동\"><label for=\"hobby0\">운동</label>\r\n");
      out.write("\t\t\t\t\t<input type=\"checkbox\" name=\"hobby\" id=\"hobby1\" value=\"등산\"><label for=\"hobby1\">등산</label>\r\n");
      out.write("\t\t\t\t\t<input type=\"checkbox\" name=\"hobby\" id=\"hobby2\" value=\"독서\"><label for=\"hobby2\">독서</label><br />\r\n");
      out.write("\t\t\t\t\t<input type=\"checkbox\" name=\"hobby\" id=\"hobby3\" value=\"게임\"><label for=\"hobby3\">게임</label>\r\n");
      out.write("\t\t\t\t\t<input type=\"checkbox\" name=\"hobby\" id=\"hobby4\" value=\"여행\"><label for=\"hobby4\">여행</label><br />\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<input type=\"submit\" value=\"가입\" >\r\n");
      out.write("\t\t<input type=\"reset\" value=\"취소\">\r\n");
      out.write("\t</form>\r\n");
      out.write("</section>\r\n");
      out.write("<script>\r\n");
      out.write("/**\r\n");
      out.write(" * 중복검사 이후 다시 아이디를 변경하는 것을 방지\r\n");
      out.write(" */\r\n");
      out.write("$(\"#memberId_\").change(function(){\r\n");
      out.write("\t$(\"#idValid\").val(0);\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("/**\r\n");
      out.write(" * 아이디 중복 검사함수\r\n");
      out.write(" * 팝업창으로 [name=checkIdDuplicateFrm]을 제출한다.\r\n");
      out.write(" * 현재 페이지에 머물면서 서버통신하기 위함.\r\n");
      out.write(" */\r\n");
      out.write("function checkIdDuplicate(){\r\n");
      out.write("\tvar $memberId = $(\"#memberId_\");\r\n");
      out.write("\tif(/^[a-zA-Z0-9_]{4,}$/.test($memberId.val()) == false){\r\n");
      out.write("\t\talert(\"유효한 아이디를 입력해주세요.\");\r\n");
      out.write("\t\t$memberId.select();\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//1.팝업생성\r\n");
      out.write("\t//popup Window객체의 name속성 : checkIdDuplicatePopup\r\n");
      out.write("\tvar title = \"checkIdDuplicatePopup\";\r\n");
      out.write("\topen(\r\n");
      out.write("\t\t\t\"\", \r\n");
      out.write("\t\t\ttitle, \r\n");
      out.write("\t\t\t\"width=300px, height=200px, left=200px, top=200px\"\r\n");
      out.write("\t\t);\r\n");
      out.write("\t\r\n");
      out.write("\t//2.폼제출\r\n");
      out.write("\t$frm = $(document.checkIdDuplicateFrm);\r\n");
      out.write("\t$frm.find(\"[name=memberId]\").val($memberId.val()); // 사용자 입력 id세팅\r\n");
      out.write("\tconsole.log($memberId.val());\r\n");
      out.write("\t\r\n");
      out.write("\t$frm.attr(\"action\", \"");
      out.print( request.getContextPath() );
      out.write("/member/checkIdDuplicate\")\r\n");
      out.write("\t\t.attr(\"method\", \"POST\")\r\n");
      out.write("\t\t.attr(\"target\", title) //popup과 form을 연결\r\n");
      out.write("\t\t.submit();\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/**\r\n");
      out.write(" * 회원가입 유효성 검사\r\n");
      out.write(" */\r\n");
      out.write("$(document.memberEnrollFrm).submit(function(){\r\n");
      out.write("\t//memberId\r\n");
      out.write("\tvar $memberId = $(\"#memberId_\");\r\n");
      out.write("\t//아이디는 영문자/숫자  4글자이상만 허용 \r\n");
      out.write("\tif(/^[a-zA-Z0-9]{4,}$/.test($memberId.val()) == false){\r\n");
      out.write("\t\talert(\"아이디는 최소 4자리이상이어야 합니다.\");\r\n");
      out.write("\t\t$memberId.select();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar $idValid = $(\"#idValid\");\r\n");
      out.write("\tif($idValid.val() == 0){\r\n");
      out.write("\t\talert(\"아이디 중복검사 해주세요.\");\r\n");
      out.write("\t\t$idValid.prev().focus();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t//password\r\n");
      out.write("\tvar $p1 = $(\"#password_\");\r\n");
      out.write("\tvar $p2 = $(\"#password2\");\r\n");
      out.write("\tif(/^[a-zA-Z0-9!@#$$%^&*()]{4,}/.test($p1.val()) == false){\r\n");
      out.write("\t\talert(\"유효한 패스워드를 입력하세요.\");\r\n");
      out.write("\t\t$p1.select();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tif($p1.val() != $p2.val()){\r\n");
      out.write("\t\talert(\"패스워드가 일치하지 않습니다.\");\r\n");
      out.write("\t\t$p1.select();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//memberName\r\n");
      out.write("\tvar $memberName = $(\"#memberName\");\r\n");
      out.write("\tif(/^[가-힣]{2,}$/.test($memberName.val()) == false){\r\n");
      out.write("\t\talert(\"이름은 한글 2글자 이상이어야 합니다.\");\r\n");
      out.write("\t\t$memberName.select();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//phone\r\n");
      out.write("\tvar $phone = $(\"#phone\");\r\n");
      out.write("\t//-제거하기\r\n");
      out.write("\t$phone.val($phone.val().replace(/[^0-9]/g, \"\"));//숫자아닌 문자(복수개)제거하기\r\n");
      out.write("\t\r\n");
      out.write("\tif(/^010[0-9]{8}$/.test($phone.val()) == false){\r\n");
      out.write("\t\talert(\"유효한 전화번호가 아닙니다.\");\r\n");
      out.write("\t\t$phone.select();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\treturn true;\r\n");
      out.write("\t\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\t\t</section>\r\n");
      out.write("\r\n");
      out.write("\t\t<footer>\r\n");
      out.write("\t\t\t<p>&lt;Copyright 1998-2021 <strong>KH정보교육원</strong>. All rights reserved.&gt;</p>\r\n");
      out.write("\t\t</footer>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
