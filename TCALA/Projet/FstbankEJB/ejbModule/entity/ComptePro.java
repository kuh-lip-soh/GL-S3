package entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ComptePro
 *
 */
@Entity
@DiscriminatorValue("PROFESSIONEL")
public class ComptePro extends Compte implements Serializable {

	private String registre_com;
	private static final long serialVersionUID = 1L;

	@Transient
	public String getDecriminatorValue() {
		return this.getClass().getAnnotation(DiscriminatorValue.class).value();
	}

	public ComptePro() {
		super();
	}

	public ComptePro(long code, double solde, String registre_com) {
		super(code, solde);
		this.registre_com = registre_com;
	}

	public String getRegistre_com() {
		return this.registre_com;
	}

	public void setRegistre_com(String registre_com) {
		this.registre_com = registre_com;
	}

}
