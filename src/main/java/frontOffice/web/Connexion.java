package frontOffice.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import backOffice.dao.client.ClientDaoImpl;
import backOffice.metier.Client;

@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Connexion() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 String email=request.getParameter("email");
      	 String passWord=request.getParameter("password");
      	 ClientDaoImpl adi=  new ClientDaoImpl(); 
      	 Client c=adi.check(email, passWord);
      	 
      	 if(c!=null) 
      	 {
      		 HttpSession session=request.getSession();
      		 session.setAttribute("client", c);
      		 response.sendRedirect("index.co");
      	 }
      	 else 
      	 {
      		 request.getRequestDispatcher("frontOffice/jsp/login.jsp").forward(request,response);
      	 }
    }
       
		



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
