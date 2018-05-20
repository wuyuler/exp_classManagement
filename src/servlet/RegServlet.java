package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StuDao;
import dao.TchDao;
import entity.Student;
import entity.Teacher;

/**
 * Servlet implementation class RegServlet
 */

public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
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
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String id = request.getParameter("id");
		String identity = request.getParameter("identity");
		if(identity.equals("student")) {
			if(!StuDao.isFirstCreateUsername(id))out.println("已有帐号，如忘记密码请联系管理员");
			else if(!StuDao.isNewUsername(username))out.println("该帐号已注册");
			else {
				Student stu = new Student();
				stu.setId(id);
				stu.setUsername(username);
				stu.setPassword(password);
				StuDao.updateInfo(stu);
				out.println("注册成功");
			}
			
		}
		else {
			if(!TchDao.isFirstCreateUsername(id))out.println("已有帐号，如忘记密码请联系管理员");
			else if(!TchDao.isNewUsername(username))out.println("该帐号已注册");
			else {
				Teacher stu = new Teacher();
				stu.setId(id);
				stu.setUsername(username);
				stu.setPassword(password);
				TchDao.updateInfo(stu);
				out.println("注册成功");
			}
			
		}
		
		
	}

}
