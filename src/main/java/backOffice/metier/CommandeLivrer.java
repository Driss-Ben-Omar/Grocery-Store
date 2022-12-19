package backOffice.metier;

import java.io.Serializable; 

public class CommandeLivrer implements Serializable
{
	private int id;
	private int idClient ;
	private String dateLivraison;
	private String dateCommande;
	private double prixTotale;
	private String nomComplet;
	private String numeroTelephone;
	private String adresse;
	
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNomComplet() {
		return nomComplet;
	}
	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}
	public String getNumeroTelephone() {
		return numeroTelephone;
	}
	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}
	public CommandeLivrer() 
	{
		super();
	}
	public CommandeLivrer( int id,int idClient,String nomComplet,String numeroTelephone,String adresse, String dateLivraison, String dateCommande, double prixTotale) 
	{
		super();
		this.id=id;
		this.idClient = idClient;
		this.dateLivraison = dateLivraison;
		this.dateCommande = dateCommande;
		this.prixTotale = prixTotale;
		this.nomComplet=nomComplet;
		this.numeroTelephone=numeroTelephone;
		this.adresse=adresse;
	}
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public int getIdClient() 
	{
		return idClient;
	}
	public void setIdClient(int idClient) 
	{
		this.idClient = idClient;
	}
	public String getDateLivraison() 
	{
		return dateLivraison;
	}
	public void setDateLivraison(String dateLivraison) 
	{
		this.dateLivraison = dateLivraison;
	}
	public String getDateCommande() 
	{
		return dateCommande;
	}
	public void setDateCommande(String dateCommande) 
	{
		this.dateCommande = dateCommande;
	}
	public double getPrixTotale() 
	{
		return prixTotale;
	}
	public void setPrixTotale(double prixTotale) 
	{
		this.prixTotale = prixTotale;
	}
	
}
