package com.exam.servlet;

import java.io.IOException;
<<<<<<< HEAD
=======
import java.sql.ResultSet;
import java.sql.SQLException;
>>>>>>> abae294 (added code for rquest sent)
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.DAO.RequestDAO;
<<<<<<< HEAD
=======
import com.exam.DAO.examDAO;
>>>>>>> abae294 (added code for rquest sent)
import com.exam.model.Faculty;
import com.exam.model.Student;

/**
 * Servlet implementation class RequestExamServlet
 */
@WebServlet("/RequestExamServlet")
public class RequestExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public RequestExamServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		int reqId = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 5000; i++) {
			list.add(new Integer(i));
		}
		Collections.shuffle(list);
		for (int i = 1; i <= 3000; i++) {
			reqId = list.get(i);
		}
		String exam_code = request.getParameter("e_code");
		HttpSession session = request.getSession();
		ServletContext sc = request.getServletContext();
		Student s = (Student) sc.getAttribute("student-obj");
		int studId = s.getStudId();
		int facId = (int) sc.getAttribute("facid");
		RequestDAO red = new RequestDAO();
		boolean b = red.addRequest(exam_code, studId, facId, reqId);
		if(b)
		{
			session.setAttribute("request-success",true);
			response.sendRedirect("RequestExam.jsp");
		}
		else {
			session.setAttribute("request-fail", false);
			response.sendRedirect("RequestExam.jsp");
=======
		try {
			int reqId = 0;
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 1; i < 50000; i++) {
				list.add(new Integer(i));
			}
			Collections.shuffle(list);
			for (int i = 1; i <= 4000; i++) {
				reqId = list.get(i);
			}
			
			String exam_code = request.getParameter("e_code");
			
			String cName=null;
			int facId=0;
			
			examDAO ed=new examDAO();
			ResultSet rs=ed.getAllData();
			try {
				while(rs.next()) {
					if(exam_code.equals(rs.getString(1))) {
						cName=rs.getString(5);
						facId=rs.getInt(6);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			HttpSession session = request.getSession();
			ServletContext sc = request.getServletContext();
			
			Student s = (Student) sc.getAttribute("student-obj");
			
			int studId = s.getStudId();
			String studName=s.getfName()+" "+s.getlName();
			
			RequestDAO red = new RequestDAO();
			System.out.println(facId);
			System.out.println(exam_code);
			
			boolean b = red.addRequest(exam_code, studId, facId, reqId,studName,cName);
			
			if(b)
			{
				session.setAttribute("request-success",true);
				session.setAttribute("req-id", reqId);
				
				response.sendRedirect("RequestExam.jsp");
			}
			else {
				session.setAttribute("request-fail", false);
				response.sendRedirect("RequestExam.jsp");
			}
		} catch (IOException | NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
>>>>>>> abae294 (added code for rquest sent)
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}