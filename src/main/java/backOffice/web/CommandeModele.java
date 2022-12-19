package backOffice.web;

import java.util.ArrayList;
import java.util.List;
import backOffice.metier.Commande;

public class CommandeModele 
{
	
	List<Commande> commandes = new ArrayList<>();
	

	
	public List<Commande> getcommandes()
	{
	return commandes;
	}
	
	public void setCommandes(List<Commande> commandes) 
	{
	this.commandes = commandes;
	}


}