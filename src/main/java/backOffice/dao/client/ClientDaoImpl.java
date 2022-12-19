
package backOffice.dao.client;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import backOffice.metier.Admin;
import backOffice.dao.Aes;
import backOffice.metier.Client;

import backOffice.metier.SingletonConnection;
import frontOffice.PasswordUtils;

public class ClientDaoImpl implements IClientDao {

	
		
	

	public void change(Client c) {
		//UPDATE `admin` SET nomComplet='reda' , email='reda@faiml.com' , passWord='admin123', numTele='33333333333'
		Connection connection=SingletonConnection.getConnection();
		try 
		{
			PreparedStatement statement = connection.prepareStatement("UPDATE `clients` SET nomComplet=? , email=? , password=?, NumeroTelephone=? ,datenaissance=? ,adresse=? ,salt=? where id=?");
			statement.setString(1, c.getNomComplet());
            statement.setString(2, c.getEmail());
            statement.setString(3, c.getPassword());
            statement.setString(4, c.getNumeroTelephone());
            statement.setString(5, c.getDateNaissance());
            statement.setString(6, c.getAdresse());
            statement.setString(7, c.getSalt());
            statement.setInt(8, c.getId());
		    statement.executeUpdate();
		    statement.close();

		} catch (Exception e) {
			 e.printStackTrace();
		}

	}

	@Override
	public void addToCart(int idProduit, int idclient) 
	{
		 Connection connection=SingletonConnection.getConnection();
	        try {
	           
				PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO panier(idClient,idProduit,quantiteProduit) VALUES  (?,?,1)");
	            preparedStatement.setInt(1, idclient);
	            preparedStatement.setInt(2, idProduit);
	            
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
		        } 
		 catch (SQLException e) 
		     {
		      e.printStackTrace();
		     }
		
	}

	@Override
	public int nombrePanier(int id) 
	{
		int p = 0;
		Connection connection=SingletonConnection.getConnection();
        try 
        {
        	PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(idproduit) FROM `panier` WHERE idclient=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
	           while (rs.next()) 
	              {
	                p=rs.getInt("COUNT(idproduit)");
	              }
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (SQLException e) 
	     {
  	      e.printStackTrace();
  	     }
  	
		return p;
	}

	@Override
	public void removeFromCart(int idProduit, int idClient) {
		// DELETE FROM panier WHERE idclient= 4
		Connection connection=SingletonConnection.getConnection();
        try {
           
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM panier WHERE idclient= ? and idProduit=?");
            preparedStatement.setInt(1, idClient);
            preparedStatement.setInt(2, idProduit);
            preparedStatement.executeUpdate();
            preparedStatement.close();
	        } 
	 catch (SQLException e) 
	     {
	      e.printStackTrace();
	     }
	
		
	}

	@Override
	public void updateQuantite(int quantiteProduit,int idProduit, int idClient) {
		Connection connection=SingletonConnection.getConnection();
        try {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE panier SET quantiteProduit=? WHERE idClient=? and idProduit=?");
			preparedStatement.setInt(1, quantiteProduit);
			preparedStatement.setInt(2, idClient);
            preparedStatement.setInt(3, idProduit);
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
	        } 
	 catch (SQLException e) 
	     {
	      e.printStackTrace();
	     }
	
		
	}
	@Override
	public int getQuantiteProduit(int idProduit, int idCommande) {
		int quantite = 1;
        Connection conn=SingletonConnection.getConnection();
		 try 
		    {
		        PreparedStatement ps= conn.prepareStatement("SELECT quantiteProduit FROM `commendeproduit` WHERE idCommende=? and idProduit=?");
		        ps.setInt(1, idCommande);
	            ps.setInt(2, idProduit);
		        ResultSet rs = ps.executeQuery();
		           while (rs.next()) 
		              {
		                quantite=rs.getInt("quantiteProduit");
		              }
		    } 
		 catch (SQLException e) 
		    {
		      e.printStackTrace();
		    }
		 
		return quantite;

	}
    
	@Override
	public int getQuantite(int idProduit, int idClient) {
		int quantite = 1;
        Connection conn=SingletonConnection.getConnection();
		 try 
		    {
		        PreparedStatement ps= conn.prepareStatement("SELECT quantiteProduit FROM `panier` WHERE idClient=? and idProduit=?");
		        ps.setInt(1, idClient);
	            ps.setInt(2, idProduit);
		        ResultSet rs = ps.executeQuery();
		           while (rs.next()) 
		              {
		                quantite=rs.getInt("quantiteProduit");
		              }
		    } 
		 catch (SQLException e) 
		    {
		      e.printStackTrace();
		    }
		 
		return quantite;

	}

	public ClientDaoImpl() 
	{
	}
	
	public Client check(String email, String passWord) 
	{
		Client a=null;
		
		ClientDaoImpl cls=new ClientDaoImpl();
		ArrayList <Client> cl=new ArrayList<Client>();
		cl=cls.getClientParMail(email);
		for(int i=0;i<cl.size();i++)
		{
			 String securePassword = cl.get(i).getPassword();
		        
		        // Salt value stored in database 
		        String salt = cl.get(i).getSalt();
		        
		    
		        boolean passwordMatch = PasswordUtils.verifyUserPassword(passWord , securePassword, salt);
		        
		        if(passwordMatch) 
		        {
		            a=new Client();
		            a.setAdresse(cl.get(i).getAdresse());
		            a.setDateNaissance(cl.get(i).getDateNaissance());
		            a.setEmail(cl.get(i).getEmail());
		            a.setId(cl.get(i).getId());
		            a.setNomComplet(cl.get(i).getNomComplet());
		            a.setNumeroTelephone(cl.get(i).getNumeroTelephone());
		            a.setPassword(cl.get(i).getPassword());
		            a.setSalt(cl.get(i).getSalt());
		        } 
		}
		
		return a;
		
//		Connection connection=SingletonConnection.getConnection();
//		try 
//		{
//			PreparedStatement statement = connection.prepareStatement("SELECT * FROM clients WHERE email = ? and password = ?");
//			statement.setString(1, email);
//		    statement.setString(2, passWord);
//		    
//		    ResultSet result = statement.executeQuery();
//		    
//		    if (result.next()) 
//		    {
//	            a = new Client();
//	            a.setId(Integer.parseInt(result.getString("id")));
//	            a.setNomComplet(result.getString("nomComplet"));
//	            a.setPassword(result.getString("passWord"));
//	            a.setEmail(result.getString("email"));
//	            a.setNumeroTelephone(result.getString("Numerotelephone"));
//	            a.setDateNaissance(result.getString("dateNaissance"));
//	            a.setAdresse(result.getString("adresse"));
//	            a.setSalt(result.getString("salt"));
//	        }
//		} catch (Exception e) 
//		  {
//			 e.printStackTrace();
//		  }
		
	}


	
	@Override
	public ArrayList<Client> getClientParMail(String email)
	{

		ArrayList<Client> cls= new ArrayList<Client>();
		 Connection conn=SingletonConnection.getConnection();
		 
		 try 
		    {
			 
			/*
			  PreparedStatement ps= conn.prepareStatement("select * from CLIENTS where id = ?");
		        ps.setInt(1, id);
		        ResultSet rs = ps.executeQuery();
		        
			 */
		        PreparedStatement ps= conn.prepareStatement("select * from Clients where email=? ");
		        ps.setString(1, email);
		        ResultSet rs = ps.executeQuery();
		           while (rs.next()) 
		              {
		                 Client c = new Client();
		                 c.setId(rs.getInt("ID"));
		                 c.setNomComplet(rs.getString("NOMCOMPLET"));
		                 c.setEmail(rs.getString("EMAIL"));
		                 c.setPassword(rs.getString("PASSWORD"));
		                 c.setNumeroTelephone(rs.getString("NUMEROTELEPHONE"));
		                 c.setDateNaissance(rs.getString("DATENAISSANCE"));
		                 c.setAdresse(rs.getString("ADRESSE"));
		                 c.setSalt(rs.getString("salt"));
		                
		                 
		                 cls.add(c);
		              }
		    } 
		 catch (SQLException e) 
		    {
		      e.printStackTrace();
		    }
		 return cls;
	}
	
	
	@Override
	public Client registreClient(Client client){

        Connection connection=SingletonConnection.getConnection();
        try {
           
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO clients(nomcomplet,email,password,numerotelephone,datenaissance,adresse,salt) VALUES  (?, ?, ?, ?, ?, ?,?)");
            preparedStatement.setString(1, client.getNomComplet());
            preparedStatement.setString(2, client.getEmail());
            preparedStatement.setString(3, client.getPassword());
            preparedStatement.setString(4, client.getNumeroTelephone());
            preparedStatement.setString(5, client.getDateNaissance());
            preparedStatement.setString(6, client.getAdresse());
            preparedStatement.setString(7, client.getSalt());
            
            
            preparedStatement.executeUpdate();
            
            PreparedStatement preparedStatement2= connection.prepareStatement ("SELECT MAX(ID) as ID FROM CLIENTS");
		       ResultSet rs =preparedStatement2.executeQuery();
		       if (rs.next()) 
	           {
	             client.setId(rs.getInt("ID"));
	           }
	
		       preparedStatement.close();
		       preparedStatement2.close();
	     } 
	 catch (SQLException e) 
	     {
	      e.printStackTrace();
	     }
        return client;
	}
	
	@Override
	public int nombreClient() {
		 int nbr=0;
		 Connection conn=SingletonConnection.getConnection();
		 
		 try 
		    {
		        PreparedStatement ps= conn.prepareStatement("SELECT COUNT(id) FROM `clients`");
		        ResultSet rs = ps.executeQuery();
		           while (rs.next()) 
		              {
		                nbr=rs.getInt("COUNT(id)");
		              }
		    } 
		 catch (SQLException e) 
		    {
		      e.printStackTrace();
		    }
		 
		return nbr;
	}

	@Override
	public List<Client> ClientParMC() 
	{
		List<Client> cls= new ArrayList<Client>();
		 Connection conn=SingletonConnection.getConnection();
		 
		 try 
		    {
		        PreparedStatement ps= conn.prepareStatement("select * from Clients ");
		        ResultSet rs = ps.executeQuery();
		           while (rs.next()) 
		              {
		                 Client c = new Client();
		                 c.setId(rs.getInt("ID"));
		                 c.setNomComplet(rs.getString("NOMCOMPLET"));
		                 c.setEmail(rs.getString("EMAIL"));
		                 c.setPassword(rs.getString("PASSWORD"));
		                 c.setNumeroTelephone(rs.getString("NUMEROTELEPHONE"));
		                 c.setDateNaissance(rs.getString("DATENAISSANCE"));
		                 c.setAdresse(rs.getString("ADRESSE"));
		                
		                 
		                 cls.add(c);
		              }
		    } 
		 catch (SQLException e) 
		    {
		      e.printStackTrace();
		    }
		 return cls;
	}

	@Override
	public Client getClient(int id) {
		Connection conn=SingletonConnection.getConnection();
		 Client c = new Client();
		 try {
		        PreparedStatement ps= conn.prepareStatement("select * from CLIENTS where id = ?");
		        ps.setInt(1, id);
		        ResultSet rs = ps.executeQuery();
		        
		        if (rs.next()) 
		           {
		        	
		        	 c.setId(rs.getInt("id"));
	                 c.setNomComplet(rs.getString("NOMCOMPLET"));
	                 c.setEmail(rs.getString("EMAIL"));
	                 c.setPassword(rs.getString("PASSWORD"));
	                 c.setNumeroTelephone(rs.getString("NUMEROTELEPHONE"));
	                 c.setDateNaissance(rs.getString("DATENAISSANCE"));
	                 c.setAdresse(rs.getString("ADRESSE"));
	                 
		           }
		        
		      } catch (SQLException e) 
		            {
		              e.printStackTrace();
		            }
		return c;
	}

	@Override
	public void deleteClient(int id) 
	{
		Connection conn=SingletonConnection.getConnection();
		 try {
		PreparedStatement ps= conn.prepareStatement("DELETE FROM CLIENTS WHERE ID = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

}
