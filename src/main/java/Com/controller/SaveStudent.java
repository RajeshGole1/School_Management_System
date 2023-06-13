package Com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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

import Com.dto.Student;
import Com.dto.management;

@WebServlet("/addstudent")
public class SaveStudent extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String id=req.getParameter("id");
	String name=req.getParameter("name");
	String dob=req.getParameter("dob");
	String cono=req.getParameter("cono");
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Rajesh");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	
	management m =em.find(management.class, 1);
	
	Student s=new Student();
	s.setId(Integer.parseInt(id));
	s.setName(name);
	s.setDateOfBirth(dob);
	s.setEmail(email);
	s.setPassword(password);
	
	List<Student> students=new ArrayList<Student>();
	students.add(s);
	m.setStudent(students);
	
	
	et.begin();
	em.merge(s);
	et.commit();
	
	PrintWriter pw=resp.getWriter();
	pw.write("Student record is added...");
	RequestDispatcher rd=req.getRequestDispatcher("management.html");
	resp.setContentType("text/html");
	rd.forward(req, resp);
	
}
}
