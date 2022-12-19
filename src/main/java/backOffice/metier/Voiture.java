package backOffice.metier;

import java.io.Serializable;

public class Voiture implements Serializable
{
	
	private String matricule;
	private String marque;
	
	public Voiture() 
	{
		super();
	}
	public Voiture(String matricule, String marque) 
	{
		super();
		this.matricule = matricule;
		this.marque = marque;
	}

	public String getMatricule() 
	{
		return matricule;
	}
	public void setMatricule(String matricule) 
	{
		this.matricule = matricule;
	}


	public String getMarque() 
	{
		return marque;
	}
	public void setMarque(String marque) 
	{
		this.marque = marque;
	}
}
