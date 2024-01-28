package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Compte
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING, length = 20)

public class Compte implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = true)
	private long code;
	private double solde;

	@Temporal(TemporalType.TIMESTAMP)

	@Column(name = "myDate", nullable = false)

	private Date myDate;
	private static final long serialVersionUID = 1L;

	@PrePersist
	protected void onCreate() {
		myDate = new Date();

	}

	@OneToMany(mappedBy = "compte")
	private Collection<Operations> operations = new LinkedHashSet<Operations>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "cmpt")
	private Collection<Compte_Client> cm = new LinkedHashSet<Compte_Client>();

	public Compte() {
		super();
	}

	public Compte(long code, double solde) {
		super();
		this.code = code;
		this.solde = solde;
	}

	public long getCode() {
		return this.code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public double getSolde() {
		return this.solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Date getDate() {
		return this.myDate;
	}

	public void setDate(Date date) {
		this.myDate = date;
	}

	public Collection<Compte_Client> getCm() {
		return cm;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Collection<Operations> getOperations() {
		return operations;
	}

	public void setOperations(Collection<Operations> operations) {
		this.operations = operations;
	}

	public void setCm(Collection<Compte_Client> cm) {
		this.cm = cm;
	}
}
