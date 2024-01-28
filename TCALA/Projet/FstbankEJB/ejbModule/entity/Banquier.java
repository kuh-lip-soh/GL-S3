package entity;

import java.io.Serializable;
import java.lang.String;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name = "banquier")
public class Banquier extends Utilisateur implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long id_bnq;
	private String guichet;
	private String username;
	private String pwd;
	private String Nom;
	private String prenom;

	@OneToMany(mappedBy = "banquier", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private Collection<Compte_Client> banquiers;

	private static final long serialVersionUID = 1L;

	public Banquier() {
		super();
	}

	public String getGuichet() {
		return this.guichet;
	}

	public void setGuichet(String guichet) {
		this.guichet = guichet;
	}

	public long getIdBnq() {
		return this.id_bnq;
	}

	public void setIdBnq(long id_bnq) {
		this.id_bnq = id_bnq;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNom() {
		return this.Nom;
	}

	public void setNom(String Nom) {
		this.Nom = Nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
