<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page import="dao.StuDao"%>
   <%@page import="entity.Student"%>
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
<h1>所有学生的信息</h1>

<table>
<tr>
<td>
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
<%ArrayList<Student> list = StuDao.getAllStudents(); %>

<table border="3">
<tr><th>学号</th><th>姓名</th><th>性别</th><th>生日</th><th>邮箱</th><th>电话</th></tr>
<%for(Student stu:list){ %>
<tr><td><%=stu.getId() %>&nbsp</td><td><%=stu.getName() %></td><td><%=stu.getSex() %></td><td><%=stu.getBirthday() %>&nbsp</td><td><%=stu.getEmail() %>&nbsp</td>
<td><%=stu.getPhone() %></td><td><a href="<%=basePath%>stu_detail.jsp?id=<%=stu.getId()%>">详情</a></td>
</tr>
<%} %>
</table>

</td>
</tr>
</table>
</body>
</html>