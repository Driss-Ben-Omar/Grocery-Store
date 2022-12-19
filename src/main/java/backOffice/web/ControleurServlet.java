package backOffice.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

import backOffice.dao.admin.AdminDaoImpl;
import backOffice.dao.admin.IAdminDao;
import backOffice.dao.client.*;
import backOffice.dao.commande.*;
import backOffice.dao.livreur.*;
import backOffice.dao.produit.*;
import backOffice.dao.voiture.*;
import backOffice.dao.voyage.*;

import backOffice.metier.*;

@WebServlet (name="cs",urlPatterns= {"/controleur","*.do"})
public class ControleurServlet extends HttpServlet 
 {
       IProduitDao metier;
       IVoitureDao metierV;
       ILivreurDao metierL;
     //IDemandLivreurDao metierdl;
       ICommandeDao metierC;
       ICommandeLivrerDao metierCL;
       IClientDao metierCLN;
       ITacheDao metierT;
       IAdminDao metierA;
   
              @Override
              public void init() throws ServletException 
                {
                 metier = new ProduitDaoImpl();
                 metierV= new VoitureDaoImpl();
                 metierL=new LivreurDaoImpl();
               //metierdl=new DemandLivreurDaoImpl();
                 metierC=new CommandeDaoImpl();
                 metierCL=new CommandeLivrerDaoImpl();
                 metierCLN=new ClientDaoImpl();
                 metierT=new TacheDaoImpl();
                 metierA=new AdminDaoImpl();
                }

              @Override 
              protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
              {
            	  HttpSession session=request.getSession(false);
                  String path=request.getServletPath();
                  
                    if(session!=null && session.getAttribute("admin")!=null ) { 
                    	
                     if (path.equals("/index.do"))
                        {
                    	  int t=metierCL.commandePrixTotal();
                    	  int tm=metierCL.commandePrixTotalMonth();
                    	  int nc=metierCL.commandeEnAttente();
                    	  int nbrCl=metierCLN.nombreClient();
                  		  int d=metierL.nombreLivreurDisponible();
                		  int lt=metierL.nombreLivreurTotal();
                		  int p=(d*100)/lt;
                		  int vd=metierV.nombreVoitureDisponible();
                		  int vlt=metierV.nombreVoitureTotal();
                		  int vp=(vd*100)/vlt;
                    	  request.setAttribute("t", t);
                    	  request.setAttribute("tm", tm);
                    	  request.setAttribute("nc", nc);
                    	  request.setAttribute("nbrcl", nbrCl);
                    	  request.setAttribute("livr", p);
                    	  request.setAttribute("disp", d);
                    	  request.setAttribute("livt", lt);
                    	  request.setAttribute("vp", vp);
                    	  request.setAttribute("Vdisp", vd);
                    	  request.setAttribute("vlt", vlt);
                    	  request.setAttribute("admin",session.getAttribute("admin"));
                          request.getRequestDispatcher("backOffice/jsp/dashboard.jsp").forward(request,response);
                        }
                     
                     else if (path.equals("/chercher.do"))
                        {
                           String motCle=request.getParameter("motCle");
                           ProduitModele model= new ProduitModele();
                           model.setMotCle(motCle);
                           List<Produit> prods = metier.produitsParMC(motCle);
                           model.setProduits(prods);
                           request.setAttribute("model", model);
                           request.getRequestDispatcher("backOffice/jsp/produit/produits.jsp").forward(request,response);
                        }
                     
                    else if (path.equals("/saisie.do") )
                        {
                          request.getRequestDispatcher("backOffice/jsp/produit/saisieProduit.jsp").forward(request,response);
                        }
                     
                   else if (path.equals("/save.do") && request.getMethod().equals("POST"))
                        {
                            String nom=request.getParameter("nom");
                            double prix=Double.parseDouble(request.getParameter("prix"));
                            double prixAchat=Double.parseDouble(request.getParameter("prixAchat"));
                            double quantite=Double.parseDouble(request.getParameter("quantite"));
                            double quantiteVendue=Double.parseDouble(request.getParameter("quantiteVendue"));
                            double remis=Double.parseDouble(request.getParameter("remis"));
                            Produit p = metier.save(new Produit(nom,prix,prixAchat,quantite,quantiteVendue,remis));
                            request.setAttribute("produit", p);
                            request.getRequestDispatcher("backOffice/jsp/produit/confirmation.jsp").forward(request,response);
                        }
                     
                  else if (path.equals("/supprimer.do"))
                       {
                          Long id= Long.parseLong(request.getParameter("id"));
                          metier.deleteProduit(id);
                          response.sendRedirect("chercher.do?motCle=");
                       }
                     
                 else if (path.equals("/editer.do") )
                       {
                          Long id= Long.parseLong(request.getParameter("id"));
                          Produit p = metier.getProduit(id);
                          request.setAttribute("produit", p);
                          request.getRequestDispatcher("backOffice/jsp/produit/editerProduit.jsp").forward(request,response);
                       }
                      
                else if (path.equals("/update.do") )
                        {
                           Long id = Long.parseLong(request.getParameter("id"));
                           String nom=request.getParameter("nom");
                           double prix =Double.parseDouble(request.getParameter("prix")); 
                           double prixAchat=Double.parseDouble(request.getParameter("prixAchat"));
                           double quantite=Double.parseDouble(request.getParameter("quantite"));
                           double quantiteVendue=Double.parseDouble(request.getParameter("quantiteVendue"));
                           double remis=Double.parseDouble(request.getParameter("remise"));
                           Produit p = new Produit(nom,prix,prixAchat,quantite,quantiteVendue,remis);
                           p.setIdProduit(id);
                           metier.updateProduit(p);
                           request.setAttribute("produit", p);
                           request.getRequestDispatcher("backOffice/jsp/produit/confirmation.jsp").forward(request,response);
                         }
                     
                else if (path.equals("/voireProduits.do"))
                {
                   int id =Integer.parseInt(request.getParameter("id"));
                   ProduitModele model= new ProduitModele();
                   List<Produit> prods = metier.produitsCommands(id);
                   model.setProduits(prods);
                   request.setAttribute("model", model);
                   request.getRequestDispatcher("backOffice/jsp/produit/produitCommande.jsp").forward(request,response);
                }
                 
                else if (path.equals("/chercherVoiture.do"))
                {
                   String motCle=request.getParameter("motCle");
                   VoitureModele model= new VoitureModele();
                   model.setMotCle(motCle);
                   List<Voiture> cars = metierV.voitureParMC(motCle);
                   model.setVoiture(cars);
                   request.setAttribute("model", model);
                   request.getRequestDispatcher("backOffice/jsp/voiture/voitures.jsp").forward(request,response);
                }     
                     
                else if (path.equals("/saisieVoiture.do") )
                {
                  request.getRequestDispatcher("backOffice/jsp/voiture/saisieVoiture.jsp").forward(request,response);
                } 
                 
                else if (path.equals("/saveVoiture.do") && request.getMethod().equals("POST"))
                {
                    String matricule=request.getParameter("matricule");
                    String marque=request.getParameter("marque");
                    
                    Voiture v = metierV.save(new Voiture(matricule,marque));
                    request.setAttribute("voiture", v);
                    request.getRequestDispatcher("backOffice/jsp/voiture/confirmationVoiture.jsp").forward(request,response);
                } 
                else if (path.equals("/voireCommandesinTache.do"))
                {
                   int idtache =Integer.parseInt(request.getParameter("id"));
                   CommandeModele model= new CommandeModele();
                   List<Commande> cmds = metierC.commandesInTache(idtache);
                   model.setCommandes(cmds);
                   request.setAttribute("model", model);
                   request.getRequestDispatcher("backOffice/jsp/commande/commandeInTache.jsp").forward(request,response);
               } 
                else if (path.equals("/supprimerVoiture.do"))
                {
                   String matricule=request.getParameter("id");
                   metierV.deleteVoiture(matricule);
                   response.sendRedirect("chercherVoiture.do?motCle=");
                }
                 
                else if (path.equals("/editerVoiture.do") )
                {
                   String matricule=request.getParameter("matricule");
                   
                   Voiture v = metierV.getVoiture(matricule);
                   request.setAttribute("voiture", v);
                   request.getRequestDispatcher("backOffice/jsp/voiture/editerVoiture.jsp").forward(request,response);
                }
                     
                else if (path.equals("/updateVoiture.do") )
                {
                   String matricule=request.getParameter("matricule");
                   String marque=request.getParameter("marque");
                   
                   Voiture v = new Voiture();
                   v.setMatricule(matricule);
                   v.setMarque(marque);
                   metierV.updateVoiture(v);
                   request.setAttribute("voiture", v);
                   request.getRequestDispatcher("backOffice/jsp/voiture/confirmationVoiture.jsp").forward(request,response);
                 }
                  
                
                  
                  else if (path.equals("/chercherLivreur.do"))
                     {
                        String motCle=request.getParameter("motCle");
                        LivreurModele model= new LivreurModele();
                        model.setMotCle(motCle);
                        List<Livreur> livs = metierL.livreursParMC(motCle);
                        model.setLivreurs(livs);
                        request.setAttribute("model", model);
                        request.getRequestDispatcher("backOffice/jsp/livreur/livreurs.jsp").forward(request,response);
                     }
                     
                  else if (path.equals("/saisieLivreur.do") )
                      {
                        request.getRequestDispatcher("backOffice/jsp/livreur/saisieLivreur.jsp").forward(request,response);
                      }
                  else if (path.equals("/saveLivreur.do") && request.getMethod().equals("POST"))
                  {
                      String cin=request.getParameter("cin");
                      String nomComplet=request.getParameter("nomComplet");
                      String dateNaissance=request.getParameter("dateNaissance");
                      String adresse=request.getParameter("adresse");
                      String numeroTelephone=request.getParameter("numeroTelephone");
                     
                      Livreur l = metierL.save(new Livreur(cin,nomComplet,dateNaissance,adresse,numeroTelephone));
                      request.setAttribute("livreur", l);
                      request.getRequestDispatcher("backOffice/jsp/livreur/confirmationLivreur.jsp").forward(request,response);
                  }
                    
                  else if (path.equals("/supprimerLivreur.do"))
                  {
                	 String cin=request.getParameter("id");
                     metierL.deleteLivreur(cin);
                     response.sendRedirect("chercherLivreur.do?motCle=");
                  }
                
            else if (path.equals("/editerLivreur.do") )
                  {
            	     String cin=request.getParameter("cin");
                     
                     Livreur l = metierL.getLivreur(cin);
                     request.setAttribute("livreur", l);
                     request.getRequestDispatcher("backOffice/jsp/livreur/editerLivreur.jsp").forward(request,response);
                  }
                     
            else if (path.equals("/updateLivreur.do") )
            {
               String cin=request.getParameter("cin");
               String nomComplet=request.getParameter("nomComplet");
               String dateNaissance=request.getParameter("dateNaissance");
               String adresse=request.getParameter("adresse");
               String numeroTelephone=request.getParameter("numeroTelephone");
              
               Livreur l=new Livreur(cin,nomComplet,dateNaissance,adresse,numeroTelephone);
               
              
               metierL.updateLivreur(l);
               request.setAttribute("livreur", l);
               request.getRequestDispatcher("backOffice/jsp/livreur/confirmationLivreur.jsp").forward(request,response);
             } 
                
           
         
//           else if (path.equals("/chercherDemandLivreur.do"))
//            {
//               String motCle=request.getParameter("motCle");
//               DemandLivreurModele model= new DemandLivreurModele();
//               model.setMotCle(motCle);
//               List<demandLivreur> demlivs = metierdl.demandlivreursParMC(motCle);
//               model.setdemandLivreurs(demlivs);
//               request.setAttribute("model", model);
//               request.getRequestDispatcher("demandlivreurs.jsp").forward(request,response);
//            }
//           
//         else if (path.equals("/supprimerDemandLivreur.do"))
//         {
//       	    String cin=request.getParameter("cin");
//            metierdl.deletedemandLivreur(cin);
//            response.sendRedirect("chercherDemandLivreur.do?motCle=");
//         }  
//         
//         else if (path.equals("/acceptdemandLivreur.do"))  
//         {
//        	 String cin=request.getParameter("cin");
//             demandLivreur l=metierdl.getdemandLivreur(cin);
//             metierdl.acceptdemandLivreur(l);
//             request.setAttribute("livreur", l);
//             request.getRequestDispatcher("confirmationLivreur.jsp").forward(request,response);
//             metierdl.deletedemandLivreur(cin);
//             
//         }     
         
      else if (path.equals("/chercherCommande.do"))
         {
           
            CommandeModele model= new CommandeModele();
            List<Commande> cmds = metierC.commandesParId();
            model.setCommandes(cmds);
            request.setAttribute("model", model);
            request.getRequestDispatcher("backOffice/jsp/commande/commande.jsp").forward(request,response);
     }   
         else if (path.equals("/supprimerCommande.do"))
         {
            int id= Integer.parseInt(request.getParameter("id"));
            metierC.deleteCommande(id);
            response.sendRedirect("chercherCommande.do");
         }
         
      else if (path.equals("/chercherCommandeLivrer.do"))
         {
           
            CommandeLivrerModele model= new CommandeLivrerModele();
            List<CommandeLivrer> cmdsl = metierCL.commandesLivrerParId();
            model.setCommandesLivrer(cmdsl);
            request.setAttribute("model", model);
            request.getRequestDispatcher("backOffice/jsp/commande/commandeLivrer.jsp").forward(request,response);
     }   
      else if (path.equals("/livrer.do"))  
      {
    	 int id=Integer.parseInt(request.getParameter("id")) ;
          Commande c=metierC.getCommande(id);
         metierC.livrer(c);
         request.setAttribute("commandeLivrer", c);
         request.getRequestDispatcher("backOffice/jsp/commande/confirmationLivrer.jsp").forward(request,response);
         metierC.deleteCommande(id);
         
     } 
         
                     
      else if (path.equals("/chercherClient.do"))
      {
        
        ClientModele model= new ClientModele();
         List<Client> clns = metierCLN.ClientParMC();
         model.setClients(clns);
         request.setAttribute("model", model);
         request.getRequestDispatcher("backOffice/jsp/client/client.jsp").forward(request,response);
  }       
      else if (path.equals("/supprimerClient.do"))
      {
         int id= Integer.parseInt(request.getParameter("id"));
         metierCLN.deleteClient(id);
         response.sendRedirect("chercherClient.do");
      }
      
      else if (path.equals("/voireCommandesClient.do"))
      {
         int id= Integer.parseInt(request.getParameter("id"));
         CommandeModele model= new CommandeModele();
         List<Commande> cmds = metierC.commedesDeClient(id);
         model.setCommandes(cmds);
         request.setAttribute("model", model);
         request.getRequestDispatcher("backOffice/jsp/commande/commande.jsp").forward(request,response);
      }
      else if (path.equals("/chercherTache.do"))
      {
        
         TacheModele model= new TacheModele();
         List<Tache> taches = metierT.tachesParId();
         model.setTaches(taches);
         request.setAttribute("model", model);
         request.getRequestDispatcher("backOffice/jsp/voyage/tache.jsp").forward(request,response);
  }        
      else if (path.equals("/saveTache.do") )
      {
    	      Tache t = metierT.save(new Tache());
			  String idCommends[] = request.getParameterValues("creeTache"); 
			  for(int i=0;i<idCommends.length;i++) 
			  {
			     metierC.tacher(Integer.parseInt(idCommends[i]),t.getId()); 
			  }
	    	  VoitureModele model= new VoitureModele();
	    	  List<Voiture> cars=metierV.voiturenotintache();
	    	  model.setVoiture(cars);
	    	  request.setAttribute("model", model);
	    	  request.setAttribute("idtache", t.getId());
	    	  request.getRequestDispatcher("backOffice/jsp/voiture/choisireVoiture.jsp").forward(request,response);
			/*
			 * String cin=request.getParameter("cin"); String
			 * matricule=request.getParameter("matricule"); Tache t = metierT.save(new
			 * Tache(cin,matricule)); request.setAttribute("tache", t);
			 * request.getRequestDispatcher("dashboard.jsp").forward(request,response);
			 */
    	  
      }
      else if (path.equals("/choisireVoiture.do")) 
      {
    	  String matricule= request.getParameter("matricule");
    	  int id= Integer.parseInt(request.getParameter("idtache"));
    	  Tache t =metierT.getTache(id);
    	  t.setMatricule(matricule);
    	  metierT.updateTache(t);
    	  LivreurModele model=new LivreurModele();
    	  List<Livreur> livs=metierL.livreursInTache();
    	  model.setLivreurs(livs);
    	  request.setAttribute("model", model);
    	  request.setAttribute("idtache", t.getId());
    	  request.getRequestDispatcher("backOffice/jsp/livreur/choisireLivreur.jsp").forward(request,response);
    	  
      }
      else if (path.equals("/choisireLivreur.do")) 
      {
    	  String cin= request.getParameter("cin");
    	  int id= Integer.parseInt(request.getParameter("idtache"));
    	  Tache t =metierT.getTache(id);
    	  t.setCin(cin);
    	  metierT.updateTache(t);
    	  response.sendRedirect("chercherTache.do");
    	 
    	  
    	  
    	  
      }
      else if (path.equals("/commandesinTache.do"))
      {
         int idtache =Integer.parseInt(request.getParameter("id"));
         CommandeModele model= new CommandeModele();
         List<Commande> cmds = metierC.commandesInTache(idtache);
         model.setCommandes(cmds);
         request.setAttribute("model", model);
         request.getRequestDispatcher("backOffice/jsp/commande/commandeInTache.jsp").forward(request,response);
     } 
      else if (path.equals("/supprimerTache.do"))
      {
         int id= Integer.parseInt(request.getParameter("id"));
         metierT.deleteTache(id);
         response.sendRedirect("chercherTache.do");
      }
                     
      else if (path.equals("/editerTache.do") )
      {
         int id= Integer.parseInt(request.getParameter("id"));
         Tache t = metierT.getTache(id);
         request.setAttribute("tache", t);
         request.getRequestDispatcher("backOffice/jsp/voyage/editerTache.jsp").forward(request,response);
      }
     
else if (path.equals("/updateTache.do") )
       {
		  LivreurDaoImpl l=new LivreurDaoImpl();
		  VoitureDaoImpl v=new VoitureDaoImpl();
	      int id = Integer.parseInt(request.getParameter("id"));
	      String cin=request.getParameter("cin");
	      String matricule=request.getParameter("matricule");
	      String nomComplet=l.getLivreur(cin).getNomComplet();
	      String marque=v.getVoiture(matricule).getMarque();
	      Tache t = new Tache(cin,matricule,nomComplet,marque);
          t.setId(id);
          metierT.updateTache(t);
          request.setAttribute("tache", t);
          request.getRequestDispatcher("backOffice/jsp/voyage/confirmationTache.jsp").forward(request,response);
        }
else if (path.equals("/supprimerCommandeInTache.do") )
{
   int id = Integer.parseInt(request.getParameter("id"));
   Commande c=metierC.getCommande(id);
   int idTache = c.getIdTache(); 
   metierC.deleteCommandeInTache(id);
   
   //request.getRequestDispatcher("commendesinTache.do?id="+idTache).forward(request,response);
   response.sendRedirect("commandesinTache.do?id="+idTache);
 }
else if(path.equals("/logout.do")) 
{  
    session.invalidate();
    request.getRequestDispatcher("backOffice/jsp/login.jsp").forward(request,response);
	}
else if(path.equals("/change.do")) 
{
	String nomComplet=request.getParameter("nomComplet");
	String email=request.getParameter("email");
	String passWord=request.getParameter("passWord");
	String numTele=request.getParameter("numTele");
	Admin a=new Admin(nomComplet,email,passWord,numTele);
	
	metierA.change(a);
	session.setAttribute("admin", a);
	
	response.sendRedirect("index.do");
	
	
}

                                               
                     
      else
                      {
                          response.sendError(Response.SC_NOT_FOUND);
                       }
                     }
                    
                    else{request.getRequestDispatcher("backOffice/jsp/login.jsp").forward(request,response);}
                           
              
              }

                       
                     
             

              @Override
               protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
              {
                      doGet(request,response);
              }
 }