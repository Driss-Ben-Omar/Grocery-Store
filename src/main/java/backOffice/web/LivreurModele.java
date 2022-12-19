package backOffice.web;

import java.util.ArrayList;
import java.util.List;
import backOffice.metier.Livreur;

public class LivreurModele 
{
	private String motCle;
	List<Livreur> livreurs = new ArrayList<>();
	
	public String getMotCle() 
	{
	  return motCle;
	}
	
	public void setMotCle(String motCle) 
	{
	  this.motCle = motCle;
	}
	
	public List<Livreur> getLivreurs()
	{
	return livreurs;
	}
	
	public void setLivreurs(List<Livreur> livreurs) 
	{
	this.livreurs = livreurs;
	}


}