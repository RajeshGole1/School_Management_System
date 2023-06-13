package Com.controller;

import java.io.IOException;
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

import Com.dto.Assignmment;
import Com.dto.Student;
@WebServlet("/assignment")
public class SaveAssignment extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	String id=req.getParameter("sid");
	int sid=Integer.parseInt(id);
	String aid=req.getParameter("aid");
	String name=req.getParameter("name");
	String marks=req.getParameter("marks");

	
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Rajesh");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	Student s=em.find(Student.class, sid);
	
	Assignmment a= new Assignmment();
	a.setId(Integer.parseInt(aid));
	a.setName(name);
	a.setMarks(Integer.parseInt(marks));
	
	List<Assignmment> assingment=new ArrayList<Assignmment>(); 
	assingment.add(a);
	s.setAssignment(assingment);
	
//	Student s1=em.find(Student.class, sid);
//	s1.setAssignment(assingment);
//	
	et.begin();
	em.persist(a);
	em.persist(s);
	et.commit();
	
	RequestDispatcher rd= req.getRequestDispatcher("TeacherPage.html");
	rd.forward(req, resp);
}
}
