<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%String path = request.getContextPath();
      String basePath = request.getScheme()+"://"+"localhost:8080"+path+"/";
    %>
    <%@page import="entity.Teacher"  %>
    <%@page import="dao.TchDao"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>所有老师的信息</h1>

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
<%ArrayList<Teacher> list = TchDao.getAllTeachers(); %>

<table border="3">
<tr><th>学号</th><th>姓名</th><th>教授科目</th><th>性别</th><th>生日</th><th>邮箱</th><th>电话</th></tr>
<%for(Teacher tch:list){ %>
<tr><td><%=tch.getId() %>&nbsp</td><td><%=tch.getName() %>&nbsp</td>
<td><%=tch.getSubject() %></td>
<td><%=tch.getSex() %></td><td><%=tch.getBirthday() %>&nbsp</td><td><%=tch.getEmail() %>&nbsp</td>
<td><%=tch.getPhone() %></td><td><a href="<%=basePath%>tch_detail.jsp?id=<%=tch.getId()%>">详情</a></td>
</tr>
<%} %>
</table>

</td>
</tr>
</table>
</body>
</html>