package Com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.dto.Student;
import Com.dto.Teacher;

@WebServlet("/StudentLogin")
public class ValidateStudent extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Rajesh");
		EntityManager em=emf.createEntityManager();
		
		Query q=em.createQuery("select a from Student a where a.email=?1 and a.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		
		List<Student> student=q.getResultList();
		
		
		Student s=student.get(0);
		
		HttpSession hs=req.getSession();
		hs.setAttribute("student", s);
		
		if(student.size()>0)
		 {
			 RequestDispatcher rd=req.getRequestDispatcher("StudentPage.html");
			 rd.forward(req, resp);
		 }
		 else
		 {
			 PrintWriter pw=resp.getWriter();
			 pw.write("invalid credential");
			 RequestDispatcher rd=req.getRequestDispatcher("login.html");
			 rd.include(req, resp);
			 resp.setContentType("text/html");
		 }
	}
	}

