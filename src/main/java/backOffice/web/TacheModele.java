package backOffice.web;
import java.util.ArrayList;
import java.util.List;
import backOffice.metier.Tache;

public class TacheModele 
{
	List<Tache> taches = new ArrayList<>();
	public List<Tache> getTaches()
	{
	return taches;
	}
	
	public void setTaches(List<Tache> taches) 
	{
	this.taches = taches;
	}
}
