package backOffice.dao.voyage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backOffice.dao.livreur.LivreurDaoImpl;
import backOffice.dao.voiture.VoitureDaoImpl;
import backOffice.metier.SingletonConnection;
import backOffice.metier.Tache;

public class TacheDaoImpl implements ITacheDao
{

	@Override
	public Tache save(Tache t) 
	{
		Connection conn=SingletonConnection.getConnection();
		 try {
		       PreparedStatement ps= conn.prepareStatement("INSERT INTO TACHE(CIN,MATRICULE) VALUES(?,?)");
		       ps.setString(1, t.getCin());
		       ps.setString(2, t.getMatricule());
		       ps.executeUpdate();
		       PreparedStatement ps2= conn.prepareStatement ("SELECT MAX(id) as id FROM tache");
		       ResultSet rs =ps2.executeQuery();
		          
		       if (rs.next()) 
		           {
		             t.setId(rs.getInt("id"));
		           }
		
		       ps.close();
		       ps2.close();
		     } 
		 catch (SQLException e) 
		     {
		      e.printStackTrace();
		     }
		return t;
	}

	@Override
	public List<Tache> tachesParId() 
	{
		List<Tache> taches= new ArrayList<Tache>();
		 Connection conn=SingletonConnection.getConnection();
		 
		 try 
		    {
		        PreparedStatement ps= conn.prepareStatement("select * from Tache");
		        ResultSet rs = ps.executeQuery();
		           while (rs.next()) 
		              {
		                 Tache t = new Tache();
		                 LivreurDaoImpl l=new LivreurDaoImpl();
		                 VoitureDaoImpl v=new VoitureDaoImpl();
		                 t.setId(rs.getInt("ID"));
		                 t.setCin(rs.getString("CIN"));
		                 t.setMatricule(rs.getString("MATRICULE"));
		                 t.setNomComplet(l.getLivreur(t.getCin()).getNomComplet());
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
	public Tache getTache(int id) 
	{
		Connection conn=SingletonConnection.getConnection();
		 Tache t = new Tache();
		 LivreurDaoImpl l=new LivreurDaoImpl();
         VoitureDaoImpl v=new VoitureDaoImpl();
		 try {
		        PreparedStatement ps= conn.prepareStatement("select * from TACHe where id=?");
		        ps.setInt(1,id);
		        ResultSet rs = ps.executeQuery();
		        
		        if (rs.next()) 
		           {
		              t.setId(rs.getInt("ID"));
		              t.setCin(rs.getString("CIN"));
		              t.setMatricule(rs.getString("MATRICULE"));
		              t.setNomComplet(l.getLivreur(t.getCin()).getNomComplet());
		        	  t.setMarque(v.getVoiture(t.getMatricule()).getMarque());
		           }
		        
		      } catch (SQLException e) 
		            {
		              e.printStackTrace();
		            }
		return t;
	}

	@Override
	public Tache updateTache(Tache t) 
	{
		Connection conn=SingletonConnection.getConnection();
		 try {
		        PreparedStatement ps= conn.prepareStatement("UPDATE TACHE SET CIN=?, MATRICULE=? where id=? ");
		        ps.setString(1, t.getCin());
		        ps.setString(2, t.getMatricule());
		        ps.setInt(3, t.getId());
		        ps.executeUpdate();
		        ps.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return t;
	}

	@Override
	public void deleteTache(int id) 
	{
		Connection conn=SingletonConnection.getConnection();
		 try {
		PreparedStatement ps= conn.prepareStatement("DELETE FROM TACHE WHERE ID= ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
		} catch (SQLException e) 
		 {
		e.printStackTrace();
		}

		
	}

}
