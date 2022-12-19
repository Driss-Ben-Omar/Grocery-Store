package backOffice.web;

import java.util.ArrayList;
import java.util.List;
import backOffice.metier.Voiture;

public class VoitureModele 
{
	
	private String motCle;
	List<Voiture> voitures = new ArrayList<>();
	
	public String getMotCle() 
	{
	  return motCle;
	}
	
	public void setMotCle(String motCle) 
	{
	  this.motCle = motCle;
	}
	
	public List<Voiture> getVoitures()
	{
	return voitures;
	}
	
	public void setVoiture(List<Voiture> voitures) 
	{
	this.voitures = voitures;
	}

}
