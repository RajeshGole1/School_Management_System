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

import com.mysql.cj.x.protobuf.MysqlxCrud.Find;

import Com.dto.Teacher;
import Com.dto.management;

@WebServlet("/teacherADD")
public class SaveTeacher extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String id=req.getParameter("id");
	String name=req.getParameter("name");
	String subject= req.getParameter("subject");
	String age=req.getParameter("age");
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	
	
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Rajesh");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	
	
	management m=em.find(management.class ,1);
	System.out.println(m.getId());
	System.out.println(m.getEmail());
	System.out.println(m.getPassword());
	
	
	Teacher t=new Teacher();
	t.setId(Integer.parseInt(id));
	t.setName(name);
	t.setSubject(subject);
	t.setAge(Integer.parseInt(age));
	t.setEmail(email);
	t.setPassword(password);
	
	
	List<Teacher> teacher=new ArrayList<Teacher>();
	teacher.add(t);
	m.setTeacher(teacher);
	
	et.begin();
	
	em.persist(m);
	em.persist(t);
	et.commit();
	
	PrintWriter pw=resp.getWriter();
	pw.write("teacher record is added");
	
	RequestDispatcher rd=req.getRequestDispatcher("management.html");
	rd.forward(req, resp);
	resp.setContentType("text/html");
	
	
}

private management Find(Class<management> class1, int i) {
	// TODO Auto-generated method stub
	return null;
}
}
