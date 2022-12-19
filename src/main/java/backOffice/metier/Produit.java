package backOffice.metier;

import java.io.Serializable; 

public class Produit implements Serializable 
{
	private long idProduit;
	private String nomProduit;
	private double prixAchat;
	private double prix;
	private double remise;
	private double profit;
	private double quantite;
	private double QuantiteVendue;
	
	
	public Produit () {super();}
	
	public Produit(String nomProduit ,double prix,double prixAchat,double quantite,double quantiteVendue,double remise) 
	{
		super();
		this.nomProduit=nomProduit;
		this.prix=prix;
		this.prixAchat=prixAchat;
		this.quantite=quantite;
		this.QuantiteVendue=quantiteVendue;
		this.remise=remise;
		this.profit=prix-prixAchat-remise;
		
	}

	
	public double getQuantiteVendue() {
		return QuantiteVendue;
	}

	public void setQuantiteVendue(double quantiteVendue) {
		this.QuantiteVendue = quantiteVendue;
	}

	public double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}

	public double getQuantite() {
		return quantite;
	}

	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}

	public double getRemise() {
		return remise;
	}

	public void setRemise(double remise) {
		this.remise = remise;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}


	

	public long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	

}
