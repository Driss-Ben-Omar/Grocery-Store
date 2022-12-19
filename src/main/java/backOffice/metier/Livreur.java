package backOffice.metier;

import java.io.Serializable; 

public class Livreur implements Serializable
{
	private String nomComplet,cin,dateNaissance,numeroTelephone,adresse;

	public Livreur() 
	{
		super();
	}

	public Livreur( String cin,String nomComplet , String dateNaissance, String adresse,String numeroTelephone )
	{
		super();
		this.nomComplet = nomComplet;
		this.cin = cin;
		this.dateNaissance = dateNaissance;
		this.numeroTelephone = numeroTelephone;
		this.adresse = adresse;
	}


	public String getNomComplet() {
		return nomComplet;
	}

	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getNumeroTelephone() {
		return numeroTelephone;
	}

	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
}
