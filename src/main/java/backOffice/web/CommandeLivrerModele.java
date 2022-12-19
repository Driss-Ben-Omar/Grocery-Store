package backOffice.web;

import java.util.ArrayList;
import java.util.List;
import backOffice.metier.CommandeLivrer;

public class CommandeLivrerModele 
{
	
	List<CommandeLivrer> commandesLivrer = new ArrayList<>();
	

	
	public List<CommandeLivrer> getcommandesLivrer()
	{
	return commandesLivrer;
	}
	
	public void setCommandesLivrer(List<CommandeLivrer> commandesLivrer) 
	{
	this.commandesLivrer = commandesLivrer;
	}


}