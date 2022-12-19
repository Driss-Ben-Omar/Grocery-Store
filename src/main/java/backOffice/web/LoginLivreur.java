package backOffice.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import backOffice.dao.livreur.LivreurDaoImpl;
import backOffice.metier.Livreur;


@WebServlet("/LoginLivreur")
public class LoginLivreur extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      	 String nomComplet=request.getParameter("nomComplet");
      	 String cin=request.getParameter("cin");
      	 
      	 
      	 
      	 LivreurDaoImpl liv=  new LivreurDaoImpl();
      	 Livreur l=liv.check(nomComplet,cin);
      	 
      	
      	 
      	 
      	 if(l!=null) 
      	 {
      		 HttpSession session=request.getSession();
      		 session.setAttribute("livreur", l);
      		 
      		 response.sendRedirect("index.lo");
      		 
      	 }
      	 else 
      	 {
      		 request.getRequestDispatcher("backOffice/jsp/loginLivreur.jsp").forward(request,response);
      	 }
       }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
