package backOffice.dao.voiture;

import java.util.List;
import backOffice.metier.Voiture;

public interface IVoitureDao 
{
	public Voiture save(Voiture v);
	public List<Voiture> voitureParMC(String mc);
	public List<Voiture> voiturenotintache();
	public Voiture getVoiture(String matricule);
	public Voiture updateVoiture(Voiture v);
	public void deleteVoiture(String matricule);
	public int nombreVoitureTotal();
	public int nombreVoitureDisponible();
}
