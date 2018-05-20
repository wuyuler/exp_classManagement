package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StuDao;
import entity.Student;
import entity.Teacher;
import utils.Setting;

/**
 * Servlet implementation class UpdateScores
 */

public class UpdateScores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateScores() {
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
		ArrayList<Student> list=null;
		try {
			list = StuDao.getAllStudents();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Integer> scoreList = new ArrayList<>();
		
		for(int i =0;i <list.size();i++) {
			scoreList.add(Integer.parseInt(request.getParameter("stu"+i)));
		}
		
		HttpSession session = request.getSession();
		
		Teacher tch = (Teacher)session.getAttribute("user"); 
		int id_subject = Setting.getIdOfSubject(tch.getSubject());
		StuDao.updateScores(scoreList, id_subject);
		out.println("成绩更新成功");
		
		
	}

}
