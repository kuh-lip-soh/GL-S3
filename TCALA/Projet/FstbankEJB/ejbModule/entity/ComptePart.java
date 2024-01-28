package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ComptePart
 *
 */

@Entity
@DiscriminatorValue("PARTICULIER")
public class ComptePart extends Compte implements Serializable {

	@Transient
	public String getDecriminatorValue() {
		return this.getClass().getAnnotation(DiscriminatorValue.class).value();
	}

	private static final long serialVersionUID = 1L;

	public ComptePart() {
		super();
	}

	public ComptePart(long code, double solde) {
		super(code, solde);
	}
}
