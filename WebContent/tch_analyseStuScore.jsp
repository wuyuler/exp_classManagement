<%@page import="utils.Setting"%>
<%@page import="entity.Teacher"%>
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
<h1>分析学生成绩</h1>
<table>
<tr>
<td>
<a href="<%=basePath%>index.jsp">返回登录界面</a><br>

<a href="<%=basePath%>allStudentInfo.jsp">所有学生信息</a><br>
<a href="<%=basePath%>allTeacherInfo.jsp">所有老师信息</a><br>
<a href="<%=basePath%>tch_updateInfo.jsp">更新个人信息</a><br>
<a href="<%=basePath%>tch.jsp">返回个人主页</a><br>
<a href="<%=basePath%>tch_updateScores.jsp">录入成绩</a><br>
<a href="<%=basePath%>tch_analyseStuScore.jsp">分析成绩</a><br>

</td>
<%Teacher tch =(Teacher) session.getAttribute("user"); %>
<td>
<%ArrayList<Student> list = StuDao.getAllStudents(); %>

<table border="3">
<tr><th>学号</th><th>姓名</th><th>性别</th><th><%=tch.getSubject()+"成绩" %></th>
<%for(Student stu:list){ %>
<tr><td><%=stu.getId() %>&nbsp</td><td><%=stu.getName() %></td><td><%=stu.getSex() %></td>
<td><%=stu.getScores()[Setting.getIdOfSubject(tch.getSubject())] %></td>
</tr>
<%} %>
</table>

</td>
</tr>
</table>


</body>
</html>