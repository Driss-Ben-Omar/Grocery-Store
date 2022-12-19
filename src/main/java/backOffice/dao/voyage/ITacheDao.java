package backOffice.dao.voyage;

import java.util.List;
import backOffice.metier.Tache;

public interface ITacheDao 
{
	public Tache save(Tache t);
	public List<Tache> tachesParId();
	public Tache getTache(int id);
	public Tache updateTache(Tache t);
	public void deleteTache(int id);
}