package frontOffice.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import backOffice.dao.client.ClientDaoImpl;
import backOffice.dao.client.IClientDao;
import backOffice.metier.Client;
import frontOffice.PasswordUtils;
import backOffice.dao.Aes;

@WebServlet("/Registre")
public class Registre  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IClientDao metierC;
	
	  @Override
    public void init() throws ServletException 
      {
       metierC=new ClientDaoImpl();
      }
	
       
    
    public Registre() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	     
	    		String nomComlpet=request.getParameter("nomComplet");
	    		String email=request.getParameter("email");
	    		String numeroTelephone=request.getParameter("telephone");
	    		String adresse=request.getParameter("adresse");
	    		String password=request.getParameter("Password");
	    		String dateNaissance=request.getParameter("dateNaissance");
	    		String rapeatPassword=request.getParameter("repeatPassword");
	    		
	    		
	    		
	    		Client cl=new Client(nomComlpet,email,password,numeroTelephone,dateNaissance,adresse);
	    		
	    		//String passwordCrypter=password;
//	    		        try {
//	              Aes aes = new Aes();
//	              aes.init();
//	               passwordCrypter = aes.encrypt(password);
//	          
//
//	            
//	          } catch (Exception ignored) {
//
//	              }
	    		if(cl.checkinPassword(password, rapeatPassword)) 
	    		{
	    			if(cl.checkPassword(password))
	    			{
	    				String salt = PasswordUtils.getSalt(30);
	    				String passwordCrypted = PasswordUtils.generateSecurePassword(password, salt);
	    				 
	    				Client client=metierC.registreClient( new Client(nomComlpet,email,passwordCrypted,numeroTelephone,dateNaissance,adresse,salt));
	    			
	    				 
	    				//request.setAttribute("clients", client);
	    				request.getRequestDispatcher("frontOffice/jsp/login.jsp").forward(request,response);
	    			}
	    			else
	    			{
//	    				request.setAttribute("status","failed");
	    				response.sendRedirect("registre.co");
	    			}
	    		}
	    		else
	    		{
	    			response.sendRedirect("registre.co");
	    		}
	    		
	        
    }
       
		



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
