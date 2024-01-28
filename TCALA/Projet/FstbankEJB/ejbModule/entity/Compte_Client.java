package entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Compte_Client
 *
 */
@Entity

public class Compte_Client implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	@JoinColumn(name = "code")
	Compte cmpt;
	@ManyToOne
	@JoinColumn(name = "id_cli")
	Client client;

	@ManyToOne
	@JoinColumn(name = "id_bnq")
	Banquier banquier;

	private String type_cc;
	private static final long serialVersionUID = 1L;

	public Compte_Client() {
		super();
	}

	public Compte_Client(String type_cc, Compte cmpt, Client client, Banquier bnq) {
		this.banquier = bnq;
		this.client = client;
		this.cmpt = cmpt;
		this.type_cc = type_cc;
	}

	public String getType_cc() {
		return this.type_cc;
	}

	public void setType_cc(String type_cc) {
		this.type_cc = type_cc;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Compte getCmpt() {
		return cmpt;
	}

	public void setCmpt(Compte cmpt) {
		this.cmpt = cmpt;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
