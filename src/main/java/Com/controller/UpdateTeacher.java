package Com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Com.dto.Teacher;
@WebServlet("/upteacher")
public class UpdateTeacher extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String id=req.getParameter("id");
	String name=req.getParameter("name");
	String subject=req.getParameter("subject");
	String age=req.getParameter("age");
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Rajesh");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	Teacher t=new Teacher();
	t.setId(Integer.parseInt(id));
	t.setName(name);
	t.setSubject(subject);
	t.setAge(Integer.parseInt(age));
	t.setEmail(email);
	t.setPassword(password);
	
	et.begin();
	em.merge(t);
	et.commit();
	
	PrintWriter pw=resp.getWriter();
	pw.write("teacher data is updated.......");
	
	RequestDispatcher rd=req.getRequestDispatcher("TeacherPage.html");
	rd.include(req, resp);
	resp.setContentType("text/html ");
}
}
