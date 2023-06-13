package Com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/joye")
public class SelectRole extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String role=req.getParameter("role");
	
	if(role.equals("management")){
		RequestDispatcher rd=req.getRequestDispatcher("ManagementLogin");
		rd.forward(req, resp);
	}
	else if (role.equals("teacher"))
	{
		RequestDispatcher rd=req.getRequestDispatcher("TeacherLogin");
		rd.forward(req, resp);
	}
	else if(role.equals("student"))
	{
		RequestDispatcher rd=req.getRequestDispatcher("StudentLogin");
		rd.forward(req, resp);
	}
}
}
