package frontOffice.web;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import backOffice.dao.CreatePdf;
import backOffice.metier.Admin;
import backOffice.metier.Client;
import backOffice.metier.Commande;
import backOffice.metier.Produit;
import backOffice.web.CommandeModele;
import backOffice.web.ProduitModele;
import frontOffice.PasswordUtils;
import backOffice.dao.client.*;
import backOffice.dao.commande.CommandeDaoImpl;
import backOffice.dao.commande.ICommandeDao;
import backOffice.dao.produit.IProduitDao;
import backOffice.dao.produit.ProduitDaoImpl;


@WebServlet (name="cs1",urlPatterns= {"/controleur1","*.co"})
public class Servlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	IClientDao metierC;
	IProduitDao metier;
	ICommandeDao metiercmd;
	
	  @Override
      public void init() throws ServletException 
        {
         metierC=new ClientDaoImpl();
         metier = new ProduitDaoImpl();
         metiercmd=new CommandeDaoImpl();
        }
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession(false);
		String path=request.getServletPath();
		
       
/*         if(path.equals("/registre.co") && request.getMethod().equals("POST"))
        {
    		String nomComlpet=request.getParameter("nomComplet");
    		String email=request.getParameter("email");
    		String numeroTelephone=request.getParameter("telephone");
    		String adresse=request.getParameter("adresse");
    		String password=request.getParameter("Password");
    		String dateNaissance=request.getParameter("dateNaissance");
    		String rapeatPassword=request.getParameter("repeatPassword");
    		
    		Client cl=new Client(nomComlpet,email,password,numeroTelephone,dateNaissance,adresse);
    		

    		if(cl.checkinPassword(password, rapeatPassword)) 
    		{
    			if(cl.checkPassword(password))
    			{
    				Client client=metierC.registreClient( new Client(nomComlpet,email,password,numeroTelephone,dateNaissance,adresse));
    				request.setAttribute("clients", client);
    				request.getRequestDispatcher("frontOffice/jsp/login.jsp").forward(request,response);
    			}
    			else
    			{
//    				request.setAttribute("status","failed");
    				response.sendRedirect("index.so");
    			}
    		}
    	}*/
        
         
    if(session!=null &&  session.getAttribute("client")!=null) 
    { 
    	session.setAttribute("metierC", metierC);
    	if(path.equals("/index.co")) 
    	{
    		request.getRequestDispatcher("frontOffice/index.jsp").forward(request,response);
    	}
       else if (path.equals("/produit.co"))
        { 
    	   String motCle="";
    	   ProduitModele model= new ProduitModele();
           model.setMotCle(motCle);
           List<Produit> prods = metier.produitsParMC(motCle);
           model.setProduits(prods);
           request.setAttribute("model", model);   
           request.getRequestDispatcher("frontOffice/shop.jsp").forward(request,response);  	
        } 
        else if(path.equals("/about.co")  && session!=null && session.getAttribute("client")!=null)
        {
        	request.getRequestDispatcher("frontOffice/about.jsp").forward(request,response);
        }
        else if(path.equals("/contact.co")  && session!=null && session.getAttribute("client")!=null)
        {
        	
        	request.getRequestDispatcher("frontOffice/contact.jsp").forward(request,response);
        }	
        else if(path.equals("/cart.co")  && session!=null && session.getAttribute("client")!=null)
        {
        	ProduitModele model= new ProduitModele();
        	Client c=(Client) session.getAttribute("client");
            List<Produit> prods = metier.produitsInCart(c.getId());
            model.setProduits(prods);
            //metierC.getQuantite(p, c.getId())
            request.setAttribute("model", model);
            request.setAttribute("metierC", metierC);
            request.setAttribute("c", c);
        	request.getRequestDispatcher("frontOffice/cart.jsp").forward(request,response);
        }
        else if(path.equals("/inc.co")  && session!=null && session.getAttribute("client")!=null)
        {
        	int idPrduit=Integer.parseInt(request.getParameter("id"));
        	Client c=(Client) session.getAttribute("client");
        	int quantiteProduit =metierC.getQuantite(idPrduit, c.getId())+1;
        	metierC.updateQuantite(quantiteProduit, idPrduit, c.getId());
        	response.sendRedirect("cart.co");
        } else if(path.equals("/dec.co")  && session!=null && session.getAttribute("client")!=null)
        {
        	int idPrduit=Integer.parseInt(request.getParameter("id"));
        	Client c=(Client) session.getAttribute("client");
        	int quantiteProduit =metierC.getQuantite(idPrduit, c.getId())-1;
        	metierC.updateQuantite(quantiteProduit, idPrduit, c.getId());
        	response.sendRedirect("cart.co");
  
        }
        else if(path.equals("/addToCart.co")  && session!=null && session.getAttribute("client")!=null)
        {
        	int idProduit=Integer.parseInt(request.getParameter("id"));
        	Client c=(Client) session.getAttribute("client");
        	metierC.addToCart(idProduit, c.getId());
        	//request.getRequestDispatcher("frontOffice/cart.jsp").forward(request,response);
        	response.sendRedirect("produit.co");
        }
        else if(path.equals("/removeFromCart.co")  && session!=null && session.getAttribute("client")!=null)
        {
        	int idProduit=Integer.parseInt(request.getParameter("id"));
        	Client c=(Client) session.getAttribute("client");
        	metierC.removeFromCart(idProduit, c.getId());
        	//request.getRequestDispatcher("frontOffice/cart.jsp").forward(request,response);
        	response.sendRedirect("cart.co");
        }
        else if(path.equals("/creeCommand.co")  && session!=null && session.getAttribute("client")!=null)
        {
        	
        	double prixTotal=Double.parseDouble(request.getParameter("prix"));
        	Client c=(Client) session.getAttribute("client");
        	
        	Commande cmd=new Commande();
        	cmd.setIdClient(c.getId());
        	
        	LocalDate date = LocalDate.now();
        	cmd.setDateCommande(date.toString());
        	cmd.setDateLivraison(date.toString());
        	cmd.setPrixTotale(prixTotal);
        	int id=metiercmd.creeCommande(cmd);
        	metiercmd.getPanier(c.getId(), id);
        	metiercmd.deletePanier(c.getId());
            
        	CreatePdf.creePdf(c.getNomComplet(),prixTotal,id);
        	//request.getRequestDispatcher("frontOffice/cart.jsp").forward(request,response);
        	response.sendRedirect("cart.co");
        }
        
        else if(path.equals("/logout.co") && session!=null && session.getAttribute("client")!=null) 
        {
        	 session.invalidate();
        	 request.getRequestDispatcher("frontOffice/jsp/login.jsp").forward(request,response);
        }
        else if(path.equals("/commandes.co") && session!=null && session.getAttribute("client")!=null) 
        {
        	Client c=(Client) session.getAttribute("client");
        	 CommandeModele model= new CommandeModele();
             List<Commande> cmds = metiercmd.commedesDeClient(c.getId());
             model.setCommandes(cmds);
             request.setAttribute("model", model);
        	 request.getRequestDispatcher("frontOffice/jsp/commandes.jsp").forward(request,response);
        }
        else if (path.equals("/voireProduits.co"))
        {
           int id =Integer.parseInt(request.getParameter("id"));
           ProduitModele model= new ProduitModele();
           List<Produit> prods = metier.produitsCommands(id);
           model.setProduits(prods);
           request.setAttribute("idcommande", id);
           request.setAttribute("model", model);
           request.getRequestDispatcher("frontOffice/jsp/produitCommande.jsp").forward(request,response);
        }
        else if(path.equals("/telecharger.co")) 
        {
        	int id=0;

        	try
        	{
        		id =Integer.parseInt(request.getParameter("id"));        


        	    String filepath ="C:\\Users\\pc\\eclipse-workspace\\versionFinal\\src\\main\\webapp\\frontOffice\\pdf\\"+ id+".pdf";   //change your directory path

        	    File file = new File(filepath);
        	    

        	   // response.setContentType("APPLICATION/OCTET-STREAM");
        	    //response.setHeader("Content-Disposition","attachment; filename=\"" + id + "\""); 

        	    java.io.FileInputStream fileInputStream = new java.io.FileInputStream(filepath);

        	    int i; 
        	    while ((i=fileInputStream.read()) != -1) 
        	    {
        	         response.getWriter().write(i); 
        	    } 
        	    fileInputStream.close();
        	}
        	catch(Exception e)
        	{
        	    System.err.println("Error while downloading file["+id+"]"+e);
        	}
        }
        else if(path.equals("/change.co") && session!=null && session.getAttribute("client")!=null) 
        {
        	Client c;
        	int id=Integer.parseInt(request.getParameter("id"));
        	String nomComplet=request.getParameter("nomComplet");
        	String email=request.getParameter("email");
        	String password=request.getParameter("passWord");
        	String newPassword=request.getParameter("newPassWord");
        	String numTele=request.getParameter("numTele");
        	String dateNaissance=request.getParameter("dateNaissance");
        	String adresse=request.getParameter("adresse");
        	
        	Client c1=metierC.check(email, password);
        	if(c1==null)
        	{
        		response.sendRedirect("logout.co");
        	}
        	else 
        	{
        		if(newPassword=="")
        		{
        			c=new Client(id, nomComplet,email,password,numTele,dateNaissance,adresse);
        		}
        		else
        		{
        			String salt = PasswordUtils.getSalt(30);
    				String passwordCrypted = PasswordUtils.generateSecurePassword(newPassword, salt);
    				
        			c=new Client(id, nomComplet,email,passwordCrypted,numTele,dateNaissance,adresse,salt);
        		}
        		metierC.change(c);
        		session.setAttribute("client", c);
        		response.sendRedirect("index.co");
        	}
        	
        	
        	
        	
        	
        
        	
       	 
       }
        	
      }else 
      {
    	  if(path.equals("/login.co") && request.getMethod().equals("POST"))
    	  {
    		  response.sendRedirect("Connexion");
    		  
    	  }
    	  else if(path.equals("/registre.co") && request.getMethod().equals("POST"))
    	  {
    		  response.sendRedirect("Registre");
    	  }
    	  else if(path.equals("/registre.co"))
    	  {
    		  request.getRequestDispatcher("frontOffice/jsp/registre.jsp").forward(request,response);
    	  }
    	  else
    	  {
    		  request.getRequestDispatcher("frontOffice/jsp/login.jsp").forward(request,response);
    	  }
      }
	} 
      
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request,response);
	}

}