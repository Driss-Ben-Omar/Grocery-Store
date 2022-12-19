package backOffice.dao.livreur;

import java.util.List;
import backOffice.metier.Livreur;
import backOffice.metier.Tache;

public interface ILivreurDao 
{
	public Livreur save(Livreur l);
	public List<Livreur> livreursParMC(String mc);
	public List<Livreur> livreursInTache();
	public Livreur getLivreur(String cin);
	public Livreur updateLivreur(Livreur l);
	public void deleteLivreur(String cin);
	public int nombreLivreurTotal();
	public int nombreLivreurDisponible();
	public Livreur check(String nomComplet,String cin);
	public List<Tache> taches(String cin);
}
