<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h1>管理员主页</h1>
<script>

function doValidate(){
	var	idReg=/^16\d{8}$/;
	if(!idReg.test(document.addInfo.id.value)){
		alert('id格式不正确,16开头,共10位');
		document.addInfo.id.focus();
		return false;
	}
	return true;
}
</script>
<table>
<tr>
<td>
<a href="<%=basePath%>index.jsp">返回登录界面</a><br>
<a href="<%=basePath%>allStudentInfo.jsp">所有学生信息</a><br>
<a href="<%=basePath%>allTeacherInfo.jsp">所有老师信息</a><br>
<%if(session.getAttribute("identity").equals("teacher")){ %>
<a href="<%=basePath%>tch.jsp">返回个人主页</a><br>
<%} %>
<%if(session.getAttribute("identity").equals("student")){ %>
<a href="<%=basePath%>stu.jsp">返回个人主页</a><br>
<%} %>
<%if(session.getAttribute("identity").equals("manager")){ %>
<a href="<%=basePath%>manager.jsp">返回个人主页</a><br>
<%} %>
</td>
<td>
<table>
<tr>
<td>
添加
</td>
<td>
<form action="AddServlet" name="addInfo" method="post" onsubmit="return doValidate()">
<table border="5">
<tr>
<td>ID：</td><td><input type = "text" name="id"  > </td>
</tr>
<tr>
<td>姓名：</td><td><input type = "text" name="name" ></td>
</tr>
<tr>
<td>教授科目：</td><td><input type = "text" name="subject" ></td>
</tr>
<tr>
<td><input type="radio" name="sex" value="男" checked="checked" />男<input type="radio" name="sex" value="女" />女</td><br>
</tr>
	<tr><input type="radio" name="identity" value="student" checked="checked" />学生 
	<input type="radio" name="identity" value="teacher" />教师 
</tr>
<tr><input type="submit" value="添加"></tr>
</table>
</form>
</td>
</tr>

<tr>
<td>
删除
</td>
<td>
<form action="DeleteServlet" method="post">
<table border="5">
<tr>
<td>ID：</td><td><input type = "text" name="id"  > </td>
</tr>

	<tr><input type="radio" name="identity" value="student" checked="checked" />学生 
	<input type="radio" name="identity" value="teacher" />教师 
</tr>
<tr><input type="submit" value="删除"></tr>
</table>
</form>
</td>
</tr>

</table>

</td>
<tr>
</table>
</body>
</html>