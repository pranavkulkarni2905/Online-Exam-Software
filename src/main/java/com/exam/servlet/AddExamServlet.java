package com.exam.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.DAO.courseDAO;
import com.exam.DAO.examDAO;
import com.exam.model.Exam;
import com.exam.model.Faculty;

/**
 * Servlet implementation class AddExamServlet
 */
@WebServlet("/AddExamServlet")
public class AddExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddExamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=request.getParameter("examcode");
		String name=request.getParameter("examname");
		String date=request.getParameter("date");
		String time=request.getParameter("optradio");
		String cName=request.getParameter("cname");
		
		int cid=0;
		courseDAO cd=new courseDAO();
		ResultSet rs=cd.getAllData();
		try {
			while(rs.next()) {
				if(rs.getString(2).contentEquals(cName)) {
					cid=rs.getInt(1);
					System.out.println(cid);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session=request.getSession();
		ServletContext sc=request.getServletContext();
		Faculty f=(Faculty)sc.getAttribute("faculty-obj");
		int facId=f.getFacId();
		String facName = f.getFname()+" "+f.getLname();
		Exam e=new Exam(code, name, date, time);
		
		examDAO ed=new examDAO();
<<<<<<< HEAD
<<<<<<< HEAD
		boolean b=ed.addExam(e,facId,cName,cid);
		int count=0;
=======
		boolean b=ed.addExam(e,facId,cName,cid, facName);
>>>>>>> aae03417528fae3881d03496eada4433d482e5d6
		if(b) {
			count++;
			sc.setAttribute("exam-count", count);
=======

		

		boolean b=ed.addExam(e,facId,cName,cid, facName);

		if(b) {
>>>>>>> abae294 (added code for rquest sent)
			session.setAttribute("exam-set-success", true);
			response.sendRedirect("SetExam.jsp");
		}else {
			session.setAttribute("exam-set-fail", false);
			response.sendRedirect("SetExam.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
