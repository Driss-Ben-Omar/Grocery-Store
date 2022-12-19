package backOffice.metier;


public class Commande extends CommandeLivrer
{
	private int idTache;
	//private int durre ;
	
	
	

	public Commande(int id,int idClient,String nomComplet,String numeroTelephone,String adresse, String dateLivraison, String dateCommande, double prixTotale) 
	{
		super(id,idClient,nomComplet,numeroTelephone,adresse, dateLivraison, dateCommande, prixTotale);
	}
	 String jourCommandeString,moisCommandeString,anneeCommandeString,jourLivraisonString,moisLivraisonString,anneeLivraisonString;
	 int jourCommande,moisCommande,anneeCommande,jourLivraison,moisLivraison,anneeLivraison;

	
	public int valeurDurre() 
	{
		int durre;
		
		try {
			// commande 
			 
			 jourCommandeString=this.getDateCommande().charAt(8)+""+this.getDateCommande().charAt(9);
			  jourCommande=Integer.parseInt(jourCommandeString);
			 
			 moisCommandeString=this.getDateCommande().charAt(5)+""+this.getDateCommande().charAt(6);
			 moisCommande=Integer.parseInt(moisCommandeString);
			 
			 anneeCommandeString=this.getDateCommande().charAt(0)+""+
					 this.getDateCommande().charAt(1)+""+this.getDateCommande().charAt(2)+""+
					 this.getDateCommande().charAt(3);
			 anneeCommande=Integer.parseInt(anneeCommandeString);
		
			 // livraison 
			 
			 jourLivraisonString=this.getDateLivraison().charAt(8)+""+this.getDateLivraison().charAt(9);
			 jourLivraison=Integer.parseInt(jourLivraisonString);
			 
			 moisLivraisonString=this.getDateLivraison().charAt(5)+""+this.getDateLivraison().charAt(6);
			 moisLivraison=Integer.parseInt(moisLivraisonString);
			 
			 anneeLivraisonString=this.getDateLivraison().charAt(0)+""+this.getDateLivraison().charAt(1)
					 +""+this.getDateLivraison().charAt(2)+""+this.getDateLivraison().charAt(3);
			 anneeLivraison=Integer.parseInt(anneeLivraisonString);
			 }catch(NumberFormatException e)
			 {
				 System.out.println("date livraison ou date de commande n'est pas correct");
			 }
	
	if(anneeCommande == anneeLivraison)
	{
		if(moisCommande == moisLivraison)
		{
			durre=jourLivraison-jourCommande;
		}
		else
		{
			if(moisCommande==1 || moisCommande==3 || moisCommande==5 || moisCommande==7 || 
				moisCommande==9 || moisCommande==10)
			{
				durre = 31 + jourLivraison - jourCommande;
			}
			else
			{
				if(moisCommande==2 && anneeCommande % 4 ==0)
				{
					durre=29+jourLivraison-jourCommande;
				}
				else
				{
					if(moisCommande==2 && anneeCommande % 4 !=0)
					{
						durre=28+jourLivraison-jourCommande;
					}
					else
					{
						durre=30+jourLivraison-jourCommande;
					}
				}
			}
		}
	}
	else 
	{
		durre =  31 + jourLivraison - jourCommande ;
	}
	return durre;
	}
	

	public int getIdTache() 
	{
		return idTache;
	}

	public void setIdTache(int idTache) 
	{
		this.idTache = idTache;
	}

	public Commande() 
	{
		super();
	}


	
}
