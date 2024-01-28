package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Virement
 *
 */
@Entity
@DiscriminatorValue("Vir")
public class Virement extends Operations implements Serializable {

	private static final long serialVersionUID = 1L;

	public Virement() {
		super();
	}

	public Virement(Client client, Compte compte, double montant) {
		super(client, compte, montant);
	}

}
