package backOffice.dao.commande;


import java.util.List;

import backOffice.metier.CommandeLivrer;




public interface ICommandeLivrerDao 
{
	public List<CommandeLivrer> commandesLivrerParId();
	public CommandeLivrer getCommandeLivrer(int id);
	public CommandeLivrer save(CommandeLivrer cl);
	public int commandePrixTotal();
	public int commandePrixTotalMonth();
	public int commandeEnAttente();
}