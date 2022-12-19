package backOffice.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import backOffice.metier.Commande;
import backOffice.metier.Livreur;
import backOffice.metier.Tache;
import backOffice.dao.commande.CommandeDaoImpl;
import backOffice.dao.commande.CommandeLivrerDaoImpl;
import backOffice.dao.commande.ICommandeDao;
import backOffice.dao.commande.ICommandeLivrerDao;
import backOffice.dao.livreur.ILivreurDao;
import backOffice.dao.livreur.LivreurDaoImpl;


@WebServlet (name="cs2",urlPatterns= {"/controleur2","*.lo"})
public class LivreurControleur extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
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
		String path=request.getServletPath();
		HttpSession session=request.getSession(false);
		
	if(session!=null && session.getAttribute("livreur")!=null ) 
	{
		if (path.equals("/index.lo"))
        {
			Livreur l=(Livreur) session.getAttribute("livreur");
			
			TacheModele model= new TacheModele();
	        List<Tache> taches = metierl.taches(l.getCin());
	        model.setTaches(taches);
	        request.setAttribute("model", model);
			request.setAttribute("liv", l);
        	request.getRequestDispatcher("backOffice/jsp/indexLivreur.jsp").forward(request,response);
        }  
	     else if (path.equals("/commandesinTache.lo"))
	      {
	         int idtache =Integer.parseInt(request.getParameter("id"));
	         CommandeModele model= new CommandeModele();
	         List<Commande> cmds = metierC.commandesInTache(idtache);
	         model.setCommandes(cmds);
	         request.setAttribute("model", model);
	         request.getRequestDispatcher("backOffice/jsp/commande/voireCommandeInTache.jsp").forward(request,response);
	     } 
	     else if (path.equals("/voireCommandesinTache.lo"))
	      {
	         int idtache =Integer.parseInt(request.getParameter("id"));
	         CommandeModele model= new CommandeModele();
	         List<Commande> cmds = metierC.commandesInTache(idtache);
	         model.setCommandes(cmds);
	         request.setAttribute("model", model);
	         request.getRequestDispatcher("backOffice/jsp/commande/voireCommandeInTache.jsp").forward(request,response);
	     }
	     
		else if(path.equals("/logout.lo")) 
		{  
		    session.invalidate();
		    request.getRequestDispatcher("backOffice/jsp/loginLivreur.jsp").forward(request,response);
			}
	}
	else
	{
		request.getRequestDispatcher("backOffice/jsp/loginLivreur.jsp").forward(request,response);
	}
		
      
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request,response);
	}

}