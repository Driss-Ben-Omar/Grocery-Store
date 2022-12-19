package backOffice.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import backOffice.dao.admin.AdminDaoImpl;
import backOffice.metier.Admin;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
     
         
       	 String email=request.getParameter("email");
       	 String passWord=request.getParameter("passWord");
       	 
       	 AdminDaoImpl adi=  new AdminDaoImpl(); 
       	 Admin a=adi.check(email, passWord);
       	 
       	 if(a!=null) 
       	 {
       		 HttpSession session=request.getSession();
       		 session.setAttribute("admin", a);
       		 
       		 response.sendRedirect("index.do");
       		 
       	 }
       	 else 
       	 {
       		 request.getRequestDispatcher("backOffice/jsp/login.jsp").forward(request,response);
       	 }
        }
        
       
       	 
       	 	
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
