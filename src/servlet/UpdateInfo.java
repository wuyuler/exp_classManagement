package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StuDao;
import dao.TchDao;
import entity.Student;
import entity.Teacher;

/**
 * Servlet implementation class UpdateInfo
 */

public class UpdateInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfo() {
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
		//PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String identity = (String)session.getAttribute("identity");
		PrintWriter out = response.getWriter();
		String id,name,sex,email,phone,interview,birthday;
		if(identity!=null)
		switch (identity) {
		case "student":
			 id = request.getParameter("id");
			 name = request.getParameter("name");
			 sex = request.getParameter("sex");
			 email = request.getParameter("email");
			 phone = request.getParameter("phone");
			 interview = request.getParameter("interview");
			 birthday = request.getParameter("birthday");
			Student stu = new Student(id,name, sex, birthday, email, phone, interview);
			StuDao.updateInfo(stu);
			response.sendRedirect("http://localhost:8080/exp_classManagement/stu.jsp");
			break;
		case "teacher":
			 id = request.getParameter("id");
			 name = request.getParameter("name");
			 sex = request.getParameter("sex");
			 email = request.getParameter("email");
			 phone = request.getParameter("phone");
			 interview = request.getParameter("interview");
			 birthday = request.getParameter("birthday");
			
			Teacher tch= new Teacher(id,name, sex, birthday, email, phone, interview);
			TchDao.updateInfo(tch);
			response.sendRedirect("http://localhost:8080/exp_classManagement/tch.jsp");
			break;
	
		case "manager":
	
	break;

		default:
			break;
		}
		
	}

}
