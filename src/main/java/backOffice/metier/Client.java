package backOffice.metier;

import java.io.Serializable;

public class Client implements Serializable
{
    private int id ;
    private String nomComplet,email,password,numeroTelephone,dateNaissance,adresse,salt;
    
    
    
    public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public  boolean valPassword(String password) 
	{
		if(password.length()>7)
		{
			return checkPassword(password);
			
		}
		else
		{
			return false;
		}
		
	}
	
	public boolean checkPassword(String password)
	{
		boolean hasNumber=false,hasCap=false,hasLow=false;
		for(int i=0;i<password.length();i++)
		{
			char c=password.charAt(i);
			if(Character.isDigit(c))
			{
				hasNumber=true;
			}
			else if(Character.isUpperCase(c))
			{
				hasCap=true;
			}
			else if(Character.isLowerCase(c))
			{
				hasLow=true;
			}
		}
		if(hasCap && hasNumber && hasLow)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean checkinPassword(String password,String repeatPassword) 
	{
		int count =0;
		if(password.length()==repeatPassword.length())
		{
			for(int i=0;i<password.length();i++)
			{
				if(password.charAt(i)!=repeatPassword.charAt(i))
				{
					count++;
				}
			}
			if(count==0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		
	}
	
    
	public Client() 
	{
		super();
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNomComplet() {
		return nomComplet;
	}



	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getNumeroTelephone() {
		return numeroTelephone;
	}



	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}



	public String getDateNaissance() {
		return dateNaissance;
	}



	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}



	public String getAdresse() {
		return adresse;
	}



	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public Client(int id, String nomComplet, String email, String password, String numeroTelephone,String dateNaissance, String adresse) 
	{
		super();
		this.id = id;
		this.nomComplet = nomComplet;
		this.email = email;
		this.password = password;
		this.numeroTelephone = numeroTelephone;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
	}
	public Client(String nomComplet,String email,String password,String numeroTelephone,String dateNaissance,String adresse) 
	{
		super();
		this.nomComplet=nomComplet;
		this.password = password;
		this.dateNaissance=dateNaissance;
		this.numeroTelephone=numeroTelephone;
		this.adresse=adresse;
		this.email=email;
	}
	public Client(String nomComplet,String email,String password,String numeroTelephone,String dateNaissance,String adresse,String salt) 
	{
		super();
		this.nomComplet=nomComplet;
		this.password = password;
		this.dateNaissance=dateNaissance;
		this.numeroTelephone=numeroTelephone;
		this.adresse=adresse;
		this.email=email;
		this.salt=salt;
	}
	public Client(int id,String nomComplet,String email,String password,String numeroTelephone,String dateNaissance,String adresse,String salt) 
	{
		super();
		this.nomComplet=nomComplet;
		this.password = password;
		this.dateNaissance=dateNaissance;
		this.numeroTelephone=numeroTelephone;
		this.adresse=adresse;
		this.email=email;
		this.salt=salt;
		this.id=id;
	}
}
