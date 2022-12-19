
package backOffice.dao.commande;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import backOffice.metier.SingletonConnection;
import backOffice.dao.client.ClientDaoImpl;
import backOffice.metier.CommandeLivrer;


public class CommandeLivrerDaoImpl implements ICommandeLivrerDao
{

		
		@Override
	public int commandePrixTotal() 
	{
		int total = 0;
		Connection conn=SingletonConnection.getConnection();
		try 
	    {
	        PreparedStatement ps= conn.prepareStatement("SELECT SUM(prixTotale) FROM commandelivrer");
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) 
            {
               total=rs.getInt("SUM(prixTotale)");
            }
	    } 
	 catch (SQLException e) 
	    {
	      e.printStackTrace();
	    }
		return total;
	}

		@Override
		public int commandeEnAttente() {
			int t = 0;
			Connection conn=SingletonConnection.getConnection();
			try 
		    {
		        PreparedStatement ps= conn.prepareStatement("SELECT COUNT(id) FROM `commande` WHERE idTache is null");
		        ResultSet rs = ps.executeQuery();
		        while (rs.next()) 
	            {
	               t=rs.getInt("COUNT(id)");
	            }
		    } 
		 catch (SQLException e) 
		    {
		      e.printStackTrace();
		    }
			return t;
		}

		@Override
		public int commandePrixTotalMonth() 
		{
			int total = 0;
			LocalDate today = LocalDate.now();
			int month = today.getMonthValue();
			Connection conn=SingletonConnection.getConnection();
			try 
		    {
		        PreparedStatement ps= conn.prepareStatement("SELECT sum(prixTotale) FROM commandelivrer WHERE MONTH(dateLivraison) = ?");
		        ps.setInt(1, month);
		        ResultSet rs = ps.executeQuery();
		        while (rs.next()) 
	            {
	               total=rs.getInt("SUM(prixTotale)");
	            }
		    } 
		 catch (SQLException e) 
		    {
		      e.printStackTrace();
		    }
			return total;
		}

		@Override
		public List<CommandeLivrer> commandesLivrerParId() 
		{
			 List<CommandeLivrer> cmdsl= new ArrayList<CommandeLivrer>();
			 Connection conn=SingletonConnection.getConnection();
			 
			 try 
			    {
			        PreparedStatement ps= conn.prepareStatement("select * from COMMaNDELIVRER ");
			        ResultSet rs = ps.executeQuery();
			           while (rs.next()) 
			              {
			                 CommandeLivrer c = new CommandeLivrer();
			                 ClientDaoImpl cli=new ClientDaoImpl();
			                 c.setId(rs.getInt("ID"));
			                 c.setIdClient(rs.getInt("IDCLIENT"));
			                 c.setAdresse(cli.getClient(c.getIdClient()).getAdresse());
			                 c.setNomComplet(cli.getClient(c.getIdClient()).getNomComplet());
			                 c.setNumeroTelephone(cli.getClient(c.getIdClient()).getNumeroTelephone());
			                 c.setDateLivraison(rs.getString("DATELIVRAISON"));
			                 c.setDateCommande(rs.getString("DATECOMMaNDE"));
			                 c.setPrixTotale(rs.getDouble("PRIXTOTALE"));
			                 cmdsl.add(c);
			              }
			    } 
			 catch (SQLException e) 
			    {
			      e.printStackTrace();
			    }
			 return cmdsl;
		}

		public CommandeLivrer getCommandeLivrer(int id) 
		{

			 Connection conn=SingletonConnection.getConnection();
			 CommandeLivrer c = new CommandeLivrer();
			 ClientDaoImpl cli=new ClientDaoImpl();
			 try {
			        PreparedStatement ps= conn.prepareStatement("select * from Commandelivrer");
			        ps.setInt(1, id);
			        ResultSet rs = ps.executeQuery();
			        
			        if (rs.next()) 
			           {
			        	c.setId(rs.getInt("ID"));
		                 c.setIdClient(rs.getInt("IDCLIENT"));
		                 c.setAdresse(cli.getClient(c.getIdClient()).getAdresse());
		                 c.setNomComplet(cli.getClient(c.getIdClient()).getNomComplet());
		                 c.setNumeroTelephone(cli.getClient(c.getIdClient()).getNumeroTelephone());
		                 c.setDateLivraison(rs.getString("DATELIVRAISON"));
		                 c.setDateCommande(rs.getString("DATECOMMENDE"));
		                 c.setPrixTotale(rs.getDouble("PRIXTOTALE"));
			           }
			        
			      } catch (SQLException e) 
			            {
			              e.printStackTrace();
			            }
			return c;
			}
		@Override
		public CommandeLivrer save(CommandeLivrer l) 
		{
			Connection conn=SingletonConnection.getConnection();
			 try {
			       PreparedStatement ps= conn.prepareStatement("INSERT INTO commandelivrer(id,idclient,datelivraison,datecommande,prixtotale) VALUES(?,?,?,?,?)");
			       ps.setInt(1,l.getId());
			       ps.setInt(2, l.getIdClient());
			       ps.setString(3, l.getDateLivraison());
			       ps.setString(4, l.getDateCommande());
			       ps.setDouble(5, l.getPrixTotale());
			       ps.executeUpdate();
			       PreparedStatement ps2= conn.prepareStatement ("SELECT MAX(id) as MAX_ID FROM commandelivrer");
			       ResultSet rs =ps2.executeQuery();
			          
			       if (rs.next()) 
			           {
			             l.setId(rs.getInt("MAX_ID"));
			           }
			
			       ps.close();
			       ps2.close();
			      
			     } 
			 catch (SQLException e) 
			     {
			      e.printStackTrace();
			     }
			return l;
		}

	}


