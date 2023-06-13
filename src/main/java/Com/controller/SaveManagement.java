package Com.controller;

import java.io.IOException;
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
import Com.dto.Teacher;
import Com.dto.management;
@WebServlet("/am")
public class SaveManagement extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String id=req.getParameter("id");
	int id1=Integer.parseInt(id);
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	//int password1=Integer.parseInt(password);
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Rajesh");
	EntityManager em=emf.createEntityManager();
	EntityTransaction  et=em.getTransaction();
	
	management m=new management();
	m.setId(id1);
	m.setEmail(email);
	m.setPassword(password);
	
     List<Teacher> t1=m.getTeacher();
     m.setTeacher(t1);
     
     List<Student> s1=m.getStudent();
     m.setStudent(s1);
     
     et.begin();
     em.merge(m);
  
     
     et.commit();
     
     RequestDispatcher rd=req.getRequestDispatcher("Login.html");
     rd.forward(req, resp);
}
}
