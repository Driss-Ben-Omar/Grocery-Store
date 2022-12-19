package frontOffice;

import backOffice.dao.client.ClientDaoImpl;
import backOffice.metier.Client;

public class Testtest {

	public static void main(String[] args) 
	{
		ClientDaoImpl a=new ClientDaoImpl();
		Client c=a.check("mouadbenthami@gmail.com", "343434");
		
		if(c!=null) 
		{
			System.out.print(c.getNomComplet());
		}
		else
		{
			System.out.print("erroor");
		}


	}

}
