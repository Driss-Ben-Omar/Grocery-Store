package backOffice.dao.client;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import backOffice.metier.Client;

public interface IClientDao 
{
	
		//public Client loginClient(String email,String password);
		public Client registreClient(Client client);
		public List<Client> ClientParMC();
		public Client getClient(int id);
		//public Client updateClient(Client c);
		public void deleteClient(int id);
		public int nombreClient();
		public Client check(String email,String passWord);
		public void addToCart(int idProduit,int idclient);
		public void removeFromCart(int idProduit,int idClient);
		public void updateQuantite(int quantiteProduit,int idProduit,int idClient);
		public int getQuantite(int idProduit,int idClient );
		public int getQuantiteProduit(int idProduit,int idClient );
		public int nombrePanier(int id);
		public void change(Client c);
		public ArrayList<Client> getClientParMail(String email);
		 
		
	


}
