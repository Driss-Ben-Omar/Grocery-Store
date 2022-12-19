package backOffice.web;



import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import backOffice.dao.commande.CommandeDaoImpl;
import backOffice.dao.commande.CommandeLivrerDaoImpl;
import backOffice.dao.commande.ICommandeDao;
import backOffice.dao.commande.ICommandeLivrerDao;
import backOffice.dao.livreur.ILivreurDao;
import backOffice.dao.livreur.LivreurDaoImpl;
import backOffice.metier.Commande;




@WebServlet("/Confirmer")
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)
public class Confirmer extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Confirmer() {super();}
     
    ILivreurDao metierl;
	ICommandeDao metierC;
	ICommandeLivrerDao metierCL;
	
	  @Override
      public void init() throws ServletException 
        {
         metierl=new LivreurDaoImpl();
         metierC=new CommandeDaoImpl();
         metierCL=new CommandeLivrerDaoImpl();
        }
	
	  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    Part filePart = request.getPart("file");
		    
		    int id=Integer.parseInt(request.getParameter("id")) ;
	        Commande c=metierC.getCommande(id);
	        metierC.livrer(c);
	        //request.setAttribute("commandeLivrer", c);
	        //request.getRequestDispatcher("backOffice/jsp/commande/confirmationLivrer.jsp").forward(request,response);
	        metierC.deleteCommande(id);
		    
	        String fileName = id+".jpg";
		    String userDirectory ="C:\\Users\\pc\\eclipse-workspace\\versionFinal\\src\\main\\webapp\\frontOffice\\confermationPdf\\"+ fileName;
	
		    for (Part part : request.getParts()) {
		      part.write(userDirectory);
		    }
		  
		    response.sendRedirect("index.lo");;
		
	}

}
