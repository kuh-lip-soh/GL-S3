package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * Entity implementation class for Entity: Operations
 *
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING, length = 20)
@Table(name = "operations")
public class Operations implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private double Montant;
	private Date op_date;

	@ManyToOne
	@JoinColumn(name = "NUM_CPTE")
	Compte compte;
	@ManyToOne
	@JoinColumn(name = "NUM_cli")
	Client client;

	public Operations() {
		super();
	}

	public Operations(Client client, Compte compte, double montant) {
		super();
		this.op_date = new Date();
		this.Montant = montant;
		this.compte = compte;
		this.client = client;

	}

	public long getId_op() {
		return this.id;
	}

	public void setId_op(long id_op) {
		this.id = id_op;
	}

	public double getMontant() {
		return this.Montant;
	}

	public void setMontant(double Montant) {
		this.Montant = Montant;
	}

	public Date getOp_date() {
		return this.op_date;
	}

	public void setOp_date(Date op_date) {
		this.op_date = op_date;
	}

	public Client getClient() {
		return client;
	}

	@Column(name = "type", insertable = false, updatable = false)
	private String type;

	public String getType() {
		return this.type;
	}

}
