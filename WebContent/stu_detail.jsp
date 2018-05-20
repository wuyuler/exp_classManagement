<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="entity.Student"%>
    <%@page import="utils.Setting"%>
    <%@page import="dao.StuDao"%>
    <%String path = request.getContextPath();
      String basePath = request.getScheme()+"://"+"localhost:8080"+path+"/";
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>学生详细信息</h1>
<h1>学生主页</h1>
<%Student stu = StuDao.getStudentById(request.getParameter("id"));%>
<%-- <h2><%=session.getId() %></h2> --%>
<table>
<tr>
<td>
<!-- href前要加../否则无法正常跳转 -->
<a href="<%=basePath%>index.jsp">返回登录界面</a><br>

<a href="<%=basePath%>allStudentInfo.jsp">所有学生信息</a><br>
<a href="<%=basePath%>allTeacherInfo.jsp">所有老师信息</a><br>
<%if(session.getAttribute("identity").equals("teacher")){ %>
<a href="<%=basePath%>tch_updateInfo.jsp">更新个人信息</a><br>
<a href="<%=basePath%>tch.jsp">返回个人主页</a><br>
<a href="<%=basePath%>tch_updateScores.jsp">录入成绩</a><br>
<a href="<%=basePath%>tch_analyseStuScore.jsp">分析成绩</a><br>

<%} %>
<%if(session.getAttribute("identity").equals("student")){ %>
<a href="<%=basePath%>stu_updateInfo.jsp">更新个人信息</a><br>
<a href="<%=basePath%>stu.jsp">返回个人主页</a><br>
<%} %>
<%if(session.getAttribute("identity").equals("manager")){ %>
<a href="<%=basePath%>manager.jsp">返回个人主页</a><br>
<%} %>
</td>
<td>
<table>
<tr><td><h2>个人信息</h2></td></tr>
<tr> 
<td>学号：</td><td><%=stu.getId() %></td>
</tr>
<tr> 
<td>姓名：</td><td><%=stu.getName() %></td>
</tr>
<tr> 
<td>性别：</td><td><%=stu.getSex() %></td>
</tr>
<tr>
<td>生日：</td><td><%=stu.getBirthday() %></td>
</tr>
<tr> 
<td>邮箱：</td><td><%=stu.getEmail() %></td>
</tr>
<tr> 
<td>电话：</td><td><%=stu.getPhone() %></td>
</tr>
<tr> 
<td>自我介绍:</td>
</tr>
<tr> 
<td><%=stu.getInterview() %></td>
</tr>
</table>
<td>
</td>
</tr>
</table>

<table border="5" >
<!-- colspan控制单元格合并 -->
<tr><td align="center"  colspan="<%=Setting.numOfSubject %>"><h2>成绩单</h2></td></tr>
<tr>
<%for(int i =0;i<Setting.numOfSubject;i++){ %>
<th><%=Setting.allSubject[i] %></th>
<%} %>
</tr>
<tr>
<%for(int i =0;i<Setting.numOfSubject;i++){ %>
<td><%=stu.getScores()[i] %></td>
<%} %>
</tr>


</table>

</body>
</html>