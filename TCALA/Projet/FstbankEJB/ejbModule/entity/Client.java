package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Client
 *
 */
@Entity
@Table(name = "client")
public class Client extends Utilisateur implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nom;
	private String prenom;
	// private String auth;
	private static final long serialVersionUID = 1L;
	@Basic
	private String username;
	@Basic
	private String pwd;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "client")
	private Collection<Operations> operations = new LinkedHashSet<Operations>();

	public Client() {
		super();
	}

	public Client(String nom, String prenom, String username, String pwd) {
		super();
		this.nom = nom;
		this.username = username;
		this.pwd = pwd;
		this.prenom = prenom;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Collection<Operations> getOperations() {
		return operations;
	}
	/*
	 * public String getAuth() {
	 * return auth;
	 * }
	 * public void setAuth(String auth) {
	 * this.auth = auth;
	 * }
	 */

}
