package backOffice.dao.voiture;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import backOffice.metier.SingletonConnection;
import backOffice.metier.Voiture;

public class VoitureDaoImpl implements IVoitureDao {

	@Override
	public int nombreVoitureTotal() {
		 int n=0;
		 Connection conn=SingletonConnection.getConnection();
		 
		 try 
		    {
		        PreparedStatement ps= conn.prepareStatement("SELECT COUNT(*) FROM voitures");
		     
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
	public int nombreVoitureDisponible() {
		 int n=0;
		 Connection conn=SingletonConnection.getConnection();
		 
		 try 
		    {
		        PreparedStatement ps= conn.prepareStatement("SELECT count(*) FROM `voitures` WHERE matricule not in (SELECT matricule from `tache` as t WHERE t.matricule is not null)");
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
	public List<Voiture> voiturenotintache() 
	{
		List<Voiture> cars= new ArrayList<Voiture>();
		 Connection conn=SingletonConnection.getConnection();
		 
		 try 
		    {
		        PreparedStatement ps= conn.prepareStatement("SELECT * FROM `voitures` WHERE matricule not in (SELECT matricule from `tache` as t WHERE t.matricule is not null)");
		       
		        ResultSet rs = ps.executeQuery();
		           while (rs.next()) 
		              {
		                 Voiture v = new Voiture();
		                 v.setMarque(rs.getString("marque"));
		                 v.setMatricule(rs.getString("matricule"));
		                 cars.add(v);
		              }
		    } 
		 catch (SQLException e) 
		    {
		      e.printStackTrace();
		    }
     return cars;
	}

	@Override
	public Voiture save(Voiture v) 
	{
		
		Connection conn=SingletonConnection.getConnection();
		 try {
		       PreparedStatement ps= conn.prepareStatement("INSERT INTO voitures(matricule,marque) VALUES(?,?)");
		       
		       
		       
		       ps.setString(1, v.getMatricule());
		       ps.setString(2, v.getMarque());
		       ps.executeUpdate();
		        ps.close();
		     } 
		 catch (SQLException e) 
		     {
		      e.printStackTrace();
		     }
		return v;
	}

	@Override
	public List<Voiture> voitureParMC(String mc) 
	{
		 List<Voiture> cars= new ArrayList<Voiture>();
		 Connection conn=SingletonConnection.getConnection();
		 
		 try 
		    {
		        PreparedStatement ps= conn.prepareStatement("select * from voitures where marque LIKE ?");
		        ps.setString(1, "%"+mc+"%");
		        ResultSet rs = ps.executeQuery();
		           while (rs.next()) 
		              {
		                 Voiture v = new Voiture();
		                 v.setMarque(rs.getString("marque"));
		                 v.setMatricule(rs.getString("matricule"));
		                 cars.add(v);
		              }
		    } 
		 catch (SQLException e) 
		    {
		      e.printStackTrace();
		    }
      return cars;
	}

	@Override
	public Voiture getVoiture(String matricule) 
	{
		 Connection conn=SingletonConnection.getConnection();
		 Voiture v = new Voiture();
		 try {
		        PreparedStatement ps= conn.prepareStatement("select * from Voitures where matricule = ?");
		        ps.setString(1,matricule);
		        ResultSet rs = ps.executeQuery();
		        
		        if (rs.next()) 
		           {
		              v.setMarque(rs.getString("marque"));
		              v.setMatricule(rs.getString("matricule"));
		           }
		        
		      } catch (SQLException e) 
		            {
		              e.printStackTrace();
		            }
		return v;
	}

	@Override
	public Voiture updateVoiture(Voiture v) 
	{
		Connection conn=SingletonConnection.getConnection();
		 try {
		        PreparedStatement ps= conn.prepareStatement("UPDATE voitures SET marque=?  WHERE matricule=?");
		        ps.setString(1, v.getMarque());
		        ps.setString(2, v.getMatricule());
		        ps.executeUpdate();
		        ps.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return v;
		
	}

	@Override
	public void deleteVoiture(String matricule) 
	{
		Connection conn=SingletonConnection.getConnection();
		 try {
		        PreparedStatement ps= conn.prepareStatement("DELETE FROM VOITURES WHERE MATRICULE = ?");
		        ps.setString(1, matricule);
		        ps.executeUpdate();
		        ps.close();
		      } catch (SQLException e) 
		            {
		             e.printStackTrace();
		            }

	}

}
