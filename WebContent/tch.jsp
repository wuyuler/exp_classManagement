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
<% Teacher tch = (Teacher)session.getAttribute("user");%>
<%tch=TchDao.getTeacherById(tch.getId());%>
<table>
<tr>
<td>
<!-- href前要加../否则无法正常跳转 -->
<a href="<%=basePath%>index.jsp">返回登录界面</a><br>
<a href="<%=basePath%>tch_updateInfo.jsp">更新个人信息</a><br>
<a href="<%=basePath%>allStudentInfo.jsp">所有学生信息</a><br>
<a href="<%=basePath%>allTeacherInfo.jsp">所有老师信息</a><br>
<a href="<%=basePath%>tch.jsp">返回个人主页</a><br>
<a href="<%=basePath%>tch_updateScores.jsp">录入成绩</a><br>
<a href="<%=basePath%>tch_analyseStuScore.jsp">分析成绩</a><br>
</td>
<td>
<table>
<tr><td><h2>个人信息</h2></td></tr>
<tr> 
<td>教师编号：</td><td><%=tch.getId() %></td>
</tr>
<tr> 
<td>姓名：</td><td><%=tch.getName() %></td>
</tr>
<tr> 
<td>教授科目：</td><td><%=tch.getSubject() %></td>
</tr>
<tr> 
<td>性别：</td><td><%=tch.getSex() %></td>
</tr>
<tr>
<td>生日：</td><td><%=tch.getBirthday() %></td>
</tr>
<tr> 
<td>邮箱：</td><td><%=tch.getEmail() %></td>
</tr>
<tr> 
<td>电话：</td><td><%=tch.getPhone() %></td>
</tr>
<tr> 
<td>自我介绍:</td>
</tr>
<tr> 
<td><%=tch.getInterview() %></td>
</tr>
</table>
<td>
</td>
</tr>
</table>
</body>
</html>