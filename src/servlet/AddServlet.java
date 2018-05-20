package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StuDao;
import dao.TchDao;
import entity.Student;
import entity.Teacher;

/**
 * Servlet implementation class AddServlet
 */

public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String identity = request.getParameter("identity");
		String sex = request.getParameter("sex");
		String subject = request.getParameter("subject");
		if(identity.equals("student")) {
			if(!StuDao.isNewID(id))out.println("该学号已存在");
			else {
				Student stu = new Student();
				stu.setId(id);
				stu.setName(name);
				stu.setSex(sex);
				StuDao.insertStudent(stu);
				out.println("添加学生成功");
			}
			
		}
		if(identity.equals("teacher")) {
			if(!TchDao.isNewID(id))out.println("该教师号号已存在");
			else {
				Teacher tch = new Teacher();
				tch.setId(id);
				tch.setName(name);
				tch.setSex(sex);
				tch.setSubject(subject);
				TchDao.insertTeacher(tch);
				out.println("添加老师成功");
			}
			
		}
		
		
	}

}
