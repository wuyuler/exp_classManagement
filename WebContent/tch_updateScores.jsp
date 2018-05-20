<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="entity.Student"%>
    <%@page import="dao.StuDao"%>
    <%@page import="entity.Teacher"  %>
    <%@page import="dao.TchDao"  %>
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


<%ArrayList<Student> list = StuDao.getAllStudents();%>
<%Teacher tch = (Teacher)session.getAttribute("user"); %>
<h1>录入<%=tch.getSubject() %>成绩</h1>
<table>
<tr>
<td>
<td>
<a href="<%=basePath%>index.jsp">返回登录界面</a><br>
<a href="<%=basePath%>tch_updateInfo.jsp">更新个人信息</a><br>
<a href="<%=basePath%>allStudentInfo.jsp">所有学生信息</a><br>
<a href="<%=basePath%>allTeacherInfo.jsp">所有老师信息</a><br>
<a href="<%=basePath%>tch.jsp">返回个人主页</a><br>
<a href="<%=basePath%>tch_updateScores.jsp">录入成绩</a><br>
<a href="<%=basePath%>tch_analyseStuScore.jsp">分析成绩</a><br>
</td>

<td>
<form action="servlet/UpdateScores" method="post">
<table>

<%for(int i =0;i <list.size();i++){ %>
	<tr>
<td><%=list.get(i).getId() %>&nbsp</td><td><%=list.get(i).getName() %></td>

<td><input type="text" name=<%="stu"+i %> ></td>
	</tr>

<%} %>

<tr><td><input type="submit" value="更新成绩"></td>	</tr>
</table>

</form></td>
</tr>
</table>


</body>
</html>