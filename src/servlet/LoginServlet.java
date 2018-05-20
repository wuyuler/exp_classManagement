package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StuDao;
import dao.TchDao;
import entity.Student;
import entity.Teacher;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String username =request.getParameter("username");
		String password = request.getParameter("password");
		String identity = request.getParameter("identity");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println("name");
		if(identity!=null)
		switch (identity) {
		case "student":
				if(username==null)out.println("登陆失败");
				else if(StuDao.isNewUsername(username))
					out.print("无此帐号");
				else if (StuDao.isCorrectPassword(username, password)) {
					Student stu = StuDao.getStudentByUsername(username);
					HttpSession session = request.getSession();
					session.setAttribute("user", stu);
					session.setAttribute("identity", "student");
					request.getRequestDispatcher("/stu.jsp").forward(request, response);
					//out.println("登陆成功");
					
				}
				else out.println("密码错误");
			break;
		case "teacher":
			if(username==null)out.println("登陆失败");
			else if(TchDao.isNewUsername(username))
				out.print("无此帐号");
			else if (TchDao.isCorrectPassword(username, password)) {
				Teacher stu = TchDao.getTeacherByUsername(username);
				HttpSession session = request.getSession();
				session.setAttribute("user", stu);
				session.setAttribute("identity", "teacher");
				request.getRequestDispatcher("/tch.jsp").forward(request, response);
				//out.println("登陆成功");
				
			}
			else out.println("密码错误");
			
			break;
		case "manager":
			if(username==null)out.println("登陆失败");
			else if(username.equals("admin")&&password.equals("admin")){
				HttpSession session = request.getSession();
				session.setAttribute("identity", "manager");
				request.getRequestDispatcher("/manager.jsp").forward(request, response);
			}
			else out.println("请检查帐号密码");
	
	
	break;

		default:
			break;
		}
		
		
	}

}
