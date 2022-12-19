package backOffice.dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import backOffice.metier.Admin;
import backOffice.metier.Client;
import backOffice.metier.SingletonConnection;

public class AdminDaoImpl implements IAdminDao {





	@Override
	public void change(Admin a) {
		//UPDATE `admin` SET nomComplet='reda' , email='reda@faiml.com' , passWord='admin123', numTele='33333333333'
		Connection connection=SingletonConnection.getConnection();
		try 
		{
			PreparedStatement statement = connection.prepareStatement("UPDATE `admin` SET nomComplet=? , email=? , passWord=?, numTele=?");
			statement.setString(1, a.getNomComplet());
		    statement.setString(2, a.getEmail());
		    statement.setString(3, a.getPassword());
		    statement.setString(4, a.getNumeroTelephone());
		    statement.executeUpdate();
		    statement.close();

		} catch (Exception e) {
			 e.printStackTrace();
		}

	}

	

	@Override
	public Admin check(String email, String passWord) 
	{
		Admin a=null;
		Connection connection=SingletonConnection.getConnection();
		try 
		{
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM admin WHERE email = ? and password = ?");
			statement.setString(1, email);
		    statement.setString(2, passWord);
		    ResultSet result = statement.executeQuery();
		    
		    if (result.next()) {
	            a = new Admin();
	            a.setNomComplet(result.getString("nomComplet"));
	            a.setPassword(result.getString("passWord"));
	            a.setEmail(result.getString("email"));
	            a.setNumeroTelephone(result.getString("numTele"));
	        }
		  
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return a;
	}

}
