package entity;

import java.io.Serializable;
import javax.persistence.*;

import entity.Operations;

/**
 * Entity implementation class for Entity: Retrait
 *
 */
@Entity
@DiscriminatorValue("Ret")
public class Retrait extends Operations implements Serializable {

	private static final long serialVersionUID = 1L;

	public Retrait() {
		super();
	}

	public Retrait(Client client, Compte compte, double montant) {
		super(client, compte, montant);
	}

}
