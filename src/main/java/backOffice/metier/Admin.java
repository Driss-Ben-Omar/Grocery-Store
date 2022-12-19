package backOffice.metier;

import java.io.Serializable;

public class Admin implements Serializable
{
	 private String nomComplet,email,password,numeroTelephone;

	public String getNomComplet() {
		return nomComplet;
	}
	
	

	public Admin(String nomComplet, String email, String password, String numeroTelephone) {
		super();
		this.nomComplet = nomComplet;
		this.email = email;
		this.password = password;
		this.numeroTelephone = numeroTelephone;
	}



	public Admin() {
		super();
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

}
