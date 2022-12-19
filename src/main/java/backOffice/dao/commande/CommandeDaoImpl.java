package backOffice.dao.commande;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import backOffice.metier.SingletonConnection;
import backOffice.dao.client.ClientDaoImpl;
import backOffice.metier.Commande;
import backOffice.metier.CommandeLivrer;


public class CommandeDaoImpl implements ICommandeDao
{

	
	@Override
	public void CommandeProduit(int idProduit, int idCommande, int quantite) {
       Connection conn=SingletonConnection.getConnection();
		 try 
		    {
		        PreparedStatement ps= conn.prepareStatement("INSERT INTO commendeproduit(idProduit,idcommende,quantiteProduit) VALUES(?,?,?) ");
		        ps.setInt(1, idProduit);
		        ps.setInt(2, idCommande);
		        ps.setInt(3, quantite);
		        ps.executeUpdate();
		        ps.close();
		    } 
		 catch (SQLException e) 
		    {
		      e.printStackTrace();
		    }

		
		
	}
		


	@Override
	public void deletePanier(int idClient) 
	{
		Connection conn=SingletonConnection.getConnection();
		 try {
		PreparedStatement ps= conn.prepareStatement("DELETE FROM panier WHERE idClient = ?");
		ps.setInt(1, idClient);
		ps.executeUpdate();
		ps.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		
	}



	@Override
	public void getPanier(int idClient,int idCommande) 
	{
		 Connection conn=SingletonConnection.getConnection();
		 
		 try 
		    {
		        PreparedStatement ps= conn.prepareStatement("select * from panier where idclient = ? ");
		        ps.setInt(1, idClient);
		        ResultSet rs = ps.executeQuery();
		           while (rs.next()) 
		              {
		        	   CommandeProduit(rs.getInt("idProduit"),idCommande,rs.getInt("quantiteProduit"));
		                
		              }
		    } 
		 catch (SQLException e) 
		    {
		      e.printStackTrace();
		    }

		
		
	}

	@Override
	public int creeCommande(Commande c) {
		Connection conn=SingletonConnection.getConnection();
		 try {
		       PreparedStatement ps= conn.prepareStatement("INSERT INTO commande(idclient,datelivraison,datecommande,prixtotale) VALUES(?,?,?,?)");
				
				  ps.setInt(1,c.getIdClient()); 
				  ps.setString(2, c.getDateLivraison()); 
				  ps.setString(3, c.getDateCommande()); 
				  ps.setDouble(4,c.getPrixTotale()); 
				  ps.executeUpdate(); 
				  PreparedStatement ps2=conn.prepareStatement ("SELECT MAX(id) as MAX_ID FROM commande");
				  ResultSet rs =ps2.executeQuery();
				  
				  if (rs.next()) { c.setId(rs.getInt("MAX_ID")); }

		           ps.close();
		           ps2.close();
		      
		     } 
		 catch (SQLException e) 
		     {
		      e.printStackTrace();
		     }

		return c.getId();
	}

	@Override
	public List<Commande> commandesInTache(int idtache) 
	{
		List<Commande> cmds= new ArrayList<Commande>();
		 Connection conn=SingletonConnection.getConnection();
		 
		 try 
		    {
		        PreparedStatement ps= conn.prepareStatement("select * from commande where idTache = ? ");
		        ps.setInt(1, idtache);
		        ResultSet rs = ps.executeQuery();
		           while (rs.next()) 
		              {
		                 Commande c = new Commande();
		                 ClientDaoImpl cli=new ClientDaoImpl();
		                 c.setId(rs.getInt("ID"));
		                 c.setIdClient(rs.getInt("IDCLIENT"));
		                 c.setNomComplet(cli.getClient(c.getIdClient()).getNomComplet());
		                 c.setNumeroTelephone(cli.getClient(c.getIdClient()).getNumeroTelephone());
		                 c.setAdresse(cli.getClient(c.getIdClient()).getAdresse());
		                 c.setDateLivraison(rs.getString("DATELIVRAISON"));
		                 c.setDateCommande(rs.getString("DATEcommande"));
		                 c.setPrixTotale(rs.getDouble("PRIXTOTALE"));
		                 cmds.add(c);
		              }
		    } 
		 catch (SQLException e) 
		    {
		      e.printStackTrace();
		    }
		 return cmds;
	}

	@Override
	public List<Commande> commandesParId() 
	{
		 List<Commande> cmds= new ArrayList<Commande>();
		 Connection conn=SingletonConnection.getConnection();
		 
		 try 
		    {
		        PreparedStatement ps= conn.prepareStatement("select * from commande where idTache is null ");
		        ResultSet rs = ps.executeQuery();
		           while (rs.next()) 
		              {
		                 Commande c = new Commande();
		                 ClientDaoImpl cli=new ClientDaoImpl();
		                 c.setId(rs.getInt("ID"));
		                 c.setIdClient(rs.getInt("IDCLIENT"));
		                 c.setNomComplet(cli.getClient(c.getIdClient()).getNomComplet());
		                 c.setNumeroTelephone(cli.getClient(c.getIdClient()).getNumeroTelephone());
		                 c.setAdresse(cli.getClient(c.getIdClient()).getAdresse());
		                 c.setDateLivraison(rs.getString("DATELIVRAISON"));
		                 c.setDateCommande(rs.getString("DATEcommande"));
		                 c.setPrixTotale(rs.getDouble("PRIXTOTALE"));
		                 cmds.add(c);
		              }
		    } 
		 catch (SQLException e) 
		    {
		      e.printStackTrace();
		    }
		 return cmds;
	}

	public Commande getCommande(int id) 
	{

		 Connection conn=SingletonConnection.getConnection();
		 Commande c = new Commande();
		 try {
		        PreparedStatement ps= conn.prepareStatement("select * from commande where ID = ?");
		        ps.setInt(1, id);
		        ResultSet rs = ps.executeQuery();
		        
		        if (rs.next()) 
		           {
		        	c.setId(rs.getInt("ID"));
	                 c.setIdClient(rs.getInt("IDCLIENT"));
	                 c.setDateLivraison(rs.getString("DATELIVRAISON"));
	                 c.setDateCommande(rs.getString("DATEcommande"));
	                 c.setPrixTotale(rs.getDouble("PRIXTOTALE"));
	                 c.setIdTache(rs.getInt("idTache"));
		           }
		        
		      } catch (SQLException e) 
		            {
		              e.printStackTrace();
		            }
		return c;
		}
		@Override
	public void deleteCommandeInTache(int id) 
			{
				Connection conn=SingletonConnection.getConnection();
				 try {
				        PreparedStatement ps= conn.prepareStatement("UPDATE commande SET idtache=null WHERE ID=?");
				        ps.setInt(1, id);
				        ps.executeUpdate();
				        ps.close();
				} catch (SQLException e) 
				   {
				     e.printStackTrace();
				   }

	         }

		@Override
		public void deleteCommande(int id) 
		{
		Connection conn=SingletonConnection.getConnection();
		 try {
		PreparedStatement ps= conn.prepareStatement("DELETE FROM commande WHERE ID = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		}
		@Override
		public void livrer(Commande c) 
		{
			ICommandeLivrerDao metierL;
			metierL=new CommandeLivrerDaoImpl();
			metierL.save(new CommandeLivrer(c.getId(),c.getIdClient(),c.getNomComplet(),c.getNumeroTelephone(),c.getAdresse(),c.getDateLivraison(),c.getDateCommande(),c.getPrixTotale()));
			//CommandeLivrer v=
		}

		@Override
		public List<Commande> commedesDeClient(int id) {
			List<Commande> cmds= new ArrayList<Commande>();
			 Connection conn=SingletonConnection.getConnection();
			 
			 try 
			    {
			        PreparedStatement ps= conn.prepareStatement("select * from commande where idclient =? ");
			        ps.setInt(1, id);
			        ResultSet rs = ps.executeQuery();
			           while (rs.next()) 
			              {
			                 Commande c = new Commande();
			                 c.setId(rs.getInt("ID"));
			                 c.setIdClient(rs.getInt("IDCLIENT"));
			                 c.setDateLivraison(rs.getString("DATELIVRAISON"));
			                 c.setDateCommande(rs.getString("DATEcommande"));
			                 c.setPrixTotale(rs.getDouble("PRIXTOTALE"));
			                 cmds.add(c);
			              }
			    } 
			 catch (SQLException e) 
			    {
			      e.printStackTrace();
			    }
			 return cmds;
		}

		@Override
		public void tacher(int id,int idtache) 
		{
			Connection conn=SingletonConnection.getConnection();
			 try {
			        PreparedStatement ps= conn.prepareStatement("UPDATE commande SET idTache=? WHERE ID=?");
			        ps.setInt(1, idtache);
			        ps.setInt(2, id);
			        ps.executeUpdate();
			        ps.close();
			        
			      } catch (SQLException e) 
			            {
			              e.printStackTrace();
			            }
			


			
		}
		
		

}
