package backOffice.dao.livreur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import backOffice.metier.SingletonConnection;
import backOffice.metier.Tache;
import backOffice.dao.voiture.VoitureDaoImpl;
import backOffice.metier.Admin;
import backOffice.metier.Livreur;


public class LivreurDaoImpl implements ILivreurDao
{

	@Override
	public List<Tache> taches(String cin) {
		 List<Tache> taches= new ArrayList<Tache>();
         VoitureDaoImpl v=new VoitureDaoImpl();
		 Connection conn=SingletonConnection.getConnection();
		 
		 try 
		    {
		        PreparedStatement ps= conn.prepareStatement("select * from Tache where cin=?");
		        ps.setString(1, cin);
		        ResultSet rs = ps.executeQuery();
		           while (rs.next()) 
		              {
		                 Tache t = new Tache();
		                 t.setId(rs.getInt("ID"));
		                 t.setMatricule(rs.getString("MATRICULE"));
		                 t.setMarque(v.getVoiture(t.getMatricule()).getMarque());
		                 taches.add(t);
		              }
		    } 
		 catch (SQLException e) 
		    {
		      e.printStackTrace();
		    }
    return taches;
	
	}

	@Override
	public int nombreLivreurDisponible() {
		 int n=0;
		 Connection conn=SingletonConnection.getConnection();
		 
		 try 
		    {
		        PreparedStatement ps= conn.prepareStatement("SELECT count(*) FROM `livreurs` WHERE cin not in (SELECT cin from `tache` as t WHERE t.cin is not null)");
		        ResultSet rs = ps.executeQuery();
		           while (rs.next()) 
		              {
		        	   n=rs.getInt("COUNT(*)");
		                 
		              }
		    } 
		 catch (SQLException e) 
		    {
		      e.printStackTrace();
		    }
    
		return n;
	}

	@Override
	public Livreur check(String nomComplet, String cin) {
		Livreur l=null;
		Connection connection=SingletonConnection.getConnection();
		try 
		{
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM livreurs WHERE nomcomplet = ? and cin = ?");
			statement.setString(1, nomComplet);
		    statement.setString(2, cin);
		    ResultSet result = statement.executeQuery();
		    
		    if (result.next()) {
	            l = new Livreur();
	            l.setNomComplet(result.getString("nomComplet"));
	            l.setCin(result.getString("cin"));
	            l.setDateNaissance(result.getString("DateNaissance"));
	            l.setAdresse(result.getString("adresse"));
	            l.setNumeroTelephone(result.getString("numeroTelephone"));
	        }
		  
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		
		
		
		return l;
	}

	@Override
	public int nombreLivreurTotal() {
		 int n=0;
		 Connection conn=SingletonConnection.getConnection();
		 
		 try 
		    {
		        PreparedStatement ps= conn.prepareStatement("SELECT COUNT(cin) FROM livreurs");
		     
		        ResultSet rs = ps.executeQuery();
		           while (rs.next()) 
		              {
		        	   n=rs.getInt("COUNT(cin)");
		                 
		              }
		    } 
		 catch (SQLException e) 
		    {
		      e.printStackTrace();
		    }
    
		return n;
	}

	@Override
	public List<Livreur> livreursInTache() {
		List<Livreur> livs= new ArrayList<Livreur>();
		 Connection conn=SingletonConnection.getConnection();
		 
		 try 
		    {
		        PreparedStatement ps= conn.prepareStatement("SELECT * FROM `livreurs` WHERE cin not in (SELECT cin from `tache` as t WHERE t.cin is not null)");
		     
		        ResultSet rs = ps.executeQuery();
		           while (rs.next()) 
		              {
		        	     Livreur l=new Livreur();
		                 
		                 l.setCin(rs.getString("CIN"));
		                 l.setNomComplet(rs.getString("NOMCOMPLET"));
		                 l.setDateNaissance(rs.getString("DATENAISSANCE"));
		                 l.setAdresse(rs.getString("ADRESSE"));
		                 l.setNumeroTelephone(rs.getString("NUMEROTELEPHONE"));
		        
		                 livs.add(l);
		              }
		    } 
		 catch (SQLException e) 
		    {
		      e.printStackTrace();
		    }
     return livs;
	}

	@Override
	public Livreur save(Livreur l) 
	{
		Connection conn=SingletonConnection.getConnection();
		 try {
		       PreparedStatement ps= conn.prepareStatement("INSERT INTO Livreurs(CIN,NOMCOMPLET,DATENAISSANCE,ADRESSE,NUMEROTELEPHONE) VALUES(?,?,?,?,?)");
		       ps.setString(1, l.getCin());
		       ps.setString(2, l.getNomComplet());
		       ps.setString(3, l.getDateNaissance());
		       ps.setString(4, l.getAdresse());
		       ps.setString(5, l.getNumeroTelephone());
		       ps.executeUpdate();
		       
		       ps.close();
		     } 
		 catch (SQLException e) 
		     {
		      e.printStackTrace();
		     }
		return l;
	}

	@Override
	public List<Livreur> livreursParMC(String mc) {
		 List<Livreur> livs= new ArrayList<Livreur>();
		 Connection conn=SingletonConnection.getConnection();
		 
		 try 
		    {
		        PreparedStatement ps= conn.prepareStatement("select * from LIVREURS where NOMCOMPLET LIKE ?");
		        ps.setString(1, "%"+mc+"%");
		        ResultSet rs = ps.executeQuery();
		           while (rs.next()) 
		              {
		        	     Livreur l=new Livreur();
		                 
		                 l.setCin(rs.getString("CIN"));
		                 l.setNomComplet(rs.getString("NOMCOMPLET"));
		                 l.setDateNaissance(rs.getString("DATENAISSANCE"));
		                 l.setAdresse(rs.getString("ADRESSE"));
		                 l.setNumeroTelephone(rs.getString("NUMEROTELEPHONE"));
		        
		                 livs.add(l);
		              }
		    } 
		 catch (SQLException e) 
		    {
		      e.printStackTrace();
		    }
      return livs;
	}

	public Livreur getLivreur(String cin) 
	{

		 Connection conn=SingletonConnection.getConnection();
		 Livreur l = new Livreur();
		 try {
		        PreparedStatement ps= conn.prepareStatement("select * from LIVREURS where CIN = ?");
		        ps.setString(1, cin);
		        ResultSet rs = ps.executeQuery();
		        
		        if (rs.next()) 
		           {
		        	
		        	 l.setCin(rs.getString("CIN"));
	                 l.setNomComplet(rs.getString("NOMCOMPLET"));
	                 l.setDateNaissance(rs.getString("DATENAISSANCE"));
	                 l.setAdresse(rs.getString("ADRESSE"));
	                 l.setNumeroTelephone(rs.getString("NUMEROTELEPHONE"));
		           }
		        
		      } catch (SQLException e) 
		            {
		              e.printStackTrace();
		            }
		return l;
		}
	
		@Override
		public Livreur updateLivreur(Livreur l) 
		{
		Connection conn=SingletonConnection.getConnection();
		 try {
		        PreparedStatement ps= conn.prepareStatement("UPDATE LIVREURS SET NOMCOMPLET=?, DATENAISSANCE=?, ADRESSE=?, NumeroTelephone=?  WHERE CIN=?");
		         
			       ps.setString(1, l.getNomComplet());
			       ps.setString(2, l.getDateNaissance());
			       ps.setString(3, l.getAdresse());
			       ps.setString(4, l.getNumeroTelephone());
			       ps.setString(5, l.getCin());
		           ps.executeUpdate();
		           ps.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return l;
		}
		@Override
		public void deleteLivreur(String cin) 
		{
		Connection conn=SingletonConnection.getConnection();
		 try {
		PreparedStatement ps= conn.prepareStatement("DELETE FROM LIVREURS WHERE CIN = ?");
		ps.setString(1, cin);
		ps.executeUpdate();
		ps.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		}

}
