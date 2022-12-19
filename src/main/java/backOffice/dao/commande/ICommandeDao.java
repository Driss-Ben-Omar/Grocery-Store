package backOffice.dao.commande;


import java.util.List;

import backOffice.metier.Commande;




public interface ICommandeDao 
{
	public int creeCommande(Commande c);
	public List<Commande> commandesParId();
	public List<Commande> commedesDeClient(int id);
	public Commande getCommande(int id);
	public void deleteCommande(int id);
	public void livrer(Commande l);
	public void tacher(int id,int idtache);
	public List<Commande> commandesInTache(int idtache);
	public void deleteCommandeInTache(int id);
	public void CommandeProduit(int idProduit,int idCommande,int quantite);
	public void getPanier(int idClient,int idCommande);
	public void deletePanier(int idClient);
}
