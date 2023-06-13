package Com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.dto.management;

@WebServlet("/ManagementLogin")
public class LoginManagement extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Rajesh");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	Query q=em.createQuery("select a from management a where a.email=?1 and a.password=?2");
	q.setParameter(1, email);
	q.setParameter(2, password);
	
	List<management> management=q.getResultList();
	
	if(management.size()>0)
	{
		 HttpSession s1=req.getSession();
		  s1.setAttribute("management", management);
		RequestDispatcher rd=req.getRequestDispatcher("management.html");
		rd.forward(req, resp);
	}
	else
	{
		PrintWriter pw=resp.getWriter();
		 pw.write("invalid credential..");
		 pw.write("=============================================================");
		 RequestDispatcher rd=req.getRequestDispatcher("Login.html");
		 rd.include(req, resp);
		 resp.setContentType("text/html");
	}
	
}
}
