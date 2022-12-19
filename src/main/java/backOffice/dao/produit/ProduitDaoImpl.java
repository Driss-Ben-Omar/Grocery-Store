package backOffice.dao.produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import backOffice.metier.SingletonConnection;
import backOffice.metier.Produit;


public class ProduitDaoImpl implements IProduitDao
{

	@Override
	public List<Produit> produitsInCart(int idClient) {
		List<Produit> prods= new ArrayList<Produit>();
		 Connection conn=SingletonConnection.getConnection();
		 
		 try 
		    {
		        PreparedStatement ps= conn.prepareStatement("SELECT * FROM produits WHERE id_produit in (SELECT idProduit FROM panier WHERE idClient=?)");
		        ps.setInt(1, idClient);
		        ResultSet rs = ps.executeQuery();
		           while (rs.next()) 
		              {
		                 Produit p = new Produit();
		                 p.setIdProduit(rs.getLong("ID_PRODUIT"));
		                 p.setNomProduit(rs.getString("NOM_PRODUIT"));
		                 p.setPrix(rs.getDouble("PRIX"));
		                 p.setPrixAchat(rs.getDouble("prixAchat"));
		                 p.setProfit(rs.getDouble("profit"));
		                 p.setQuantite(rs.getDouble("quantite"));
		                 p.setQuantiteVendue(rs.getDouble("QuantiteVendue"));
		                 p.setRemise(rs.getDouble("Remis"));
		                 prods.add(p);
		              }
		    } 
		 catch (SQLException e) 
		    {
		      e.printStackTrace();
		    }
    return prods;
	}

	@Override
	public List<Produit> produitsCommands(int id) {
		List<Produit> prods= new ArrayList<Produit>();
		 Connection conn=SingletonConnection.getConnection();
		 
		 try 
		    {
		        PreparedStatement ps= conn.prepareStatement("SELECT * FROM produits WHERE id_produit in (SELECT idproduit FROM commendeproduit WHERE idcommende=?)");
		        ps.setInt(1, id);
		        ResultSet rs = ps.executeQuery();
		           while (rs.next()) 
		              {
		                 Produit p = new Produit();
		                 p.setIdProduit(rs.getLong("ID_PRODUIT"));
		                 p.setNomProduit(rs.getString("NOM_PRODUIT"));
		                 p.setPrix(rs.getDouble("PRIX"));
		                 p.setPrixAchat(rs.getDouble("prixAchat"));
		                 p.setProfit(rs.getDouble("profit"));
		                 p.setQuantite(rs.getDouble("quantite"));
		                 p.setQuantiteVendue(rs.getDouble("QuantiteVendue"));
		                 p.setRemise(rs.getDouble("Remis"));
		                 prods.add(p);
		              }
		    } 
		 catch (SQLException e) 
		    {
		      e.printStackTrace();
		    }
     return prods;
	}

	@Override
	public Produit save(Produit p) 
	{
		Connection conn=SingletonConnection.getConnection();
		 try {
		       PreparedStatement ps= conn.prepareStatement("INSERT INTO PRODUITS(NOM_PRODUIT,PRIX,Quantite,quantiteVendue,prixAchat,remis,profit) VALUES(?,?,?,?,?,?,?)");
		       ps.setString(1, p.getNomProduit());
		       ps.setDouble(2, p.getPrix());
		       ps.setDouble(3, p.getQuantite());
		       ps.setDouble(4, p.getQuantiteVendue());
		       ps.setDouble(5, p.getPrixAchat());
		       ps.setDouble(6, p.getRemise());
		       ps.setDouble(7,p.getPrix()-p.getPrixAchat()-p.getRemise());
		       ps.executeUpdate();
		       PreparedStatement ps2= conn.prepareStatement ("SELECT MAX(ID_PRODUIT) as MAX_ID FROM PRODUITS");
		       ResultSet rs =ps2.executeQuery();
		          
		       if (rs.next()) 
		           {
		             p.setIdProduit(rs.getLong("MAX_ID"));
		           }
		
		       ps.close();
		       ps2.close();
		     } 
		 catch (SQLException e) 
		     {
		      e.printStackTrace();
		     }
		return p;
	}

	@Override
	public List<Produit> produitsParMC(String mc) {
		 List<Produit> prods= new ArrayList<Produit>();
		 Connection conn=SingletonConnection.getConnection();
		 
		 try 
		    {
		        PreparedStatement ps= conn.prepareStatement("select * from PRODUITS where NOM_PRODUIT LIKE ?");
		        ps.setString(1, "%"+mc+"%");
		        ResultSet rs = ps.executeQuery();
		           while (rs.next()) 
		              {
		                 Produit p = new Produit();
		                 p.setIdProduit(rs.getLong("ID_PRODUIT"));
		                 p.setNomProduit(rs.getString("NOM_PRODUIT"));
		                 p.setPrix(rs.getDouble("PRIX"));
		                 p.setPrixAchat(rs.getDouble("prixAchat"));
		                 p.setProfit(rs.getDouble("profit"));
		                 p.setQuantite(rs.getDouble("quantite"));
		                 p.setQuantiteVendue(rs.getDouble("QuantiteVendue"));
		                 p.setRemise(rs.getDouble("Remis"));
		                 prods.add(p);
		              }
		    } 
		 catch (SQLException e) 
		    {
		      e.printStackTrace();
		    }
      return prods;
	}

	public Produit getProduit(Long id) 
	{

		 Connection conn=SingletonConnection.getConnection();
		 Produit p = new Produit();
		 try {
		        PreparedStatement ps= conn.prepareStatement("select * from PRODUITS where ID_PRODUIT = ?");
		        ps.setLong(1, id);
		        ResultSet rs = ps.executeQuery();
		        
		        if (rs.next()) 
		           {
		              p.setIdProduit(rs.getLong("ID_PRODUIT"));
		              p.setNomProduit(rs.getString("NOM_PRODUIT"));
		              p.setPrix(rs.getDouble("PRIX"));
		              p.setPrixAchat(rs.getDouble("prixAchat"));
		              p.setProfit(rs.getDouble("profit"));
		              p.setQuantite(rs.getDouble("quantite"));
		              p.setQuantiteVendue(rs.getDouble("QuantiteVendue"));
		              p.setRemise(rs.getDouble("Remis"));
		           }
		        
		      } catch (SQLException e) 
		            {
		              e.printStackTrace();
		            }
		return p;
		}
	
		@Override
		public Produit updateProduit(Produit p) 
		{
		Connection conn=SingletonConnection.getConnection();
		 try {
		        PreparedStatement ps= conn.prepareStatement("UPDATE PRODUITS SET NOM_PRODUIT=?, PRIX=?, prixAchat=?, Quantite=? ,QuantiteVendue=?,  remis=?,profit=? WHERE ID_PRODUIT=?");
		        ps.setString(1, p.getNomProduit());
		        ps.setDouble(2, p.getPrix());
		        ps.setDouble(3, p.getPrixAchat());
		        ps.setDouble(4, p.getQuantite());
		        ps.setDouble(5, p.getQuantiteVendue());
			    ps.setDouble(6, p.getRemise());
			    ps.setDouble(7, p.getPrix()-p.getPrixAchat()-p.getRemise());
		        ps.setLong(8, p.getIdProduit());
		        ps.executeUpdate();
		        ps.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return p;
		}
		@Override
		public void deleteProduit(Long id) 
		{
		Connection conn=SingletonConnection.getConnection();
		 try {
		PreparedStatement ps= conn.prepareStatement("DELETE FROM PRODUITS WHERE ID_PRODUIT = ?");
		ps.setLong(1, id);
		ps.executeUpdate();
		ps.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		}

}
