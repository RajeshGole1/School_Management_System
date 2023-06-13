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

@WebServlet("/dteacher")
public class deleteTeacher extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Rajesh");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		Teacher t=em.find(Teacher.class, id);
		et.begin();
		em.remove(t);
		et.commit();
		
		 PrintWriter pw=resp.getWriter();
		 pw.write("Teacher data is deleted.....");
		 RequestDispatcher rd=req.getRequestDispatcher("ManagementAdminPage.html");
		 rd.include(req, resp);
		 resp.setContentType("text/html");
	}
}
