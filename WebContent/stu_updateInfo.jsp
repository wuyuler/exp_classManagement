<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String path = request.getContextPath();
      String basePath = request.getScheme()+"://"+"localhost:8080/"+path+"/";
    %>
    <%@page import="entity.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>修改个人信息</h1>
<% Student user =(Student) session.getAttribute("user"); %>
<h2><%=session.getId() %></h2>
<table>
<tr>
<td>

<a href="<%=basePath%>index.jsp">返回登录界面</a><br>
<a href="<%=basePath%>stu_updateInfo.jsp">更新个人信息</a>
</td>
<td>
<form action="servlet/UpdateInfo" method="post">
<table>
<tr>
<td>姓名：</td><td><input type = "text" name="name" value=<%=user.getName() %>></td>
</tr>
<tr>
<td><input type="radio" name="gender" value="male" checked="checked" />男<input type="radio" name="gender" value="female" />女</td>
</tr>
<tr>
<input type="date" name ="birthday" >
</tr>
<tr>
<td>邮箱：</td><td><input type = "text" name="email"></td>
</tr>
<tr>
<td>电话：</td><td><input type = "text" name="phone"></td>
</tr>
</table>


<input type="submit" value="更新">

</form>



</td>


</tr>

</table>
</body>
</html>