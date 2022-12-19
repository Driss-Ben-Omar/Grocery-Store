package backOffice.web;

import java.util.ArrayList;
import java.util.List;

import backOffice.metier.Client;

public class ClientModele {


		
		List<Client> Clients = new ArrayList<>();
		

		public List<Client> getClients()
		{
		return Clients;
		}
		
		public void setClients(List<Client> Clients) 
		{
		this.Clients = Clients;
		}


	

}
