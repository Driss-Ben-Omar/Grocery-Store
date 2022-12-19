package backOffice.dao.produit;

import java.util.List;
import backOffice.metier.Produit;

public interface IProduitDao 
{
	public Produit save(Produit p);
	public List<Produit> produitsParMC(String mc);
	public List<Produit> produitsCommands(int id);
	public Produit getProduit(Long id);
	public Produit updateProduit(Produit p);
	public void deleteProduit(Long id);
	public List<Produit> produitsInCart(int idClient);
}
