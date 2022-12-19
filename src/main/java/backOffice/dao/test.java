package backOffice.dao;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import javax.crypto.KeyGenerator;

import backOffice.dao.admin.AdminDaoImpl;
import backOffice.dao.client.ClientDaoImpl;
import backOffice.dao.client.IClientDao;
import backOffice.dao.commande.CommandeLivrerDaoImpl;
import backOffice.dao.livreur.LivreurDaoImpl;
import backOffice.dao.produit.ProduitDaoImpl;
import backOffice.dao.voiture.IVoitureDao;
import backOffice.dao.voiture.VoitureDaoImpl;
//
//import java.util.List;
//
//import metier.Client;
//import metier.Commende;
//import metier.Commande;
//import metier.Produit;
//import web.ProduitModele;
import backOffice.metier.*;

public class test {

	public static void main(String[] args) throws Exception 
	{


	IClientDao v=new ClientDaoImpl();
    int t=v.getQuantite(30,31);
    System.out.println(t);
	}
	}
