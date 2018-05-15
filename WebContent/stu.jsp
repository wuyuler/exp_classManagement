<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
    <%@page import="entity.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>学生主页</h1>
<%Student stu = (Student)session.getAttribute("user");%>
<h2><%=session.getId() %></h2>
<table>
<tr>
<td>
<!-- href前要加../否则无法正常跳转 -->
<a href="../index.jsp">返回登录界面</a><br>
<a href="../stu_updateInfo.jsp">更新个人信息</a>
</td>
<td>
<table>

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
<%=stu.getInterview() %>
</tr>
</table>

<td>
</td>

</tr>

</table>
</body>
</html>