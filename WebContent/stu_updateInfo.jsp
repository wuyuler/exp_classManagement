<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String path = request.getContextPath();
      String basePath = request.getScheme()+"://"+"localhost:8080"+path+"/";
    %>
    <%@page import="entity.Student"%>
    <%@page import="dao.StuDao"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>更新个人信息</h1>
<%Student user = (Student)session.getAttribute("user");%>
<%user=StuDao.getStudentById(user.getId()) ;%>
<%-- <h2><%=session.getId() %></h2> --%>
<table border="5">
<tr>
<td>

<a href="<%=basePath%>index.jsp">返回登录界面</a><br>
<a href="<%=basePath%>stu_updateInfo.jsp">更新个人信息</a><br>
<a href="<%=basePath%>allStudentInfo.jsp">所有学生信息</a><br>
<a href="<%=basePath%>allTeacherInfo.jsp">所有老师信息</a><br>
<a href="<%=basePath%>stu.jsp">返回个人主页</a><br>
</td>
<td>
<form action="servlet/UpdateInfo" method="post">
<table border="5">
<tr>
<td>学号：</td><td><input type = "text" name="id" value=<%=user.getId() %> readonly="readonly"></td>
</tr>
<tr>
<td>姓名：</td><td><input type = "text" name="name" value=<%=user.getName() %>></td>
</tr>

<tr>
<td><input type="radio" name="sex" value="男" checked="checked" />男<input type="radio" name="sex" value="女" />女</td><br>
</tr>

<tr>
<td>生日：</td>
<td><input type="date" name ="birthday" value=<%=user.getBirthday()%>><br></td>
</tr>

<tr>
<td>邮箱：</td><td><input type = "text" name="email" value=<%=user.getEmail() %>></td>
</tr>
<tr>
<td>电话：</td><td><input type = "text" name="phone" value=<%=user.getPhone() %>></td>
</tr>


<tr>
<td><strong>自我介绍：</strong></td>
<td><textarea name="interview" clos=",50" rows="5" warp="virtual"></textarea></td>


</tr>
</table>


<input type="submit" value="更新">

</form>



</td>


</tr>

</table>
</body>
</html>