package backOffice.metier;

import java.io.Serializable;

//import org.eclipse.jdt.internal.compiler.env.AccessRestriction;

public class Tache implements Serializable
{
	private int id;
	
	private String cin;
	private String matricule;
	private String nomComplet;
	private String marque;
	public Tache( String cin, String matricule,String nomComplet,String  marque) 
	{
		super();
		
		
		this.cin = cin;
		this.matricule = matricule;
		this.marque=marque;
		this.nomComplet=nomComplet;
		
	}
	 
	public String getNomComplet() {
		return nomComplet;
	}

	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public Tache() 
	{
		super();
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	
}
