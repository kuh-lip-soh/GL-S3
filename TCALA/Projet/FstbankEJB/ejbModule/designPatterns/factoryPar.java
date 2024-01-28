package designPatterns;

import entity.Compte;
import entity.ComptePart;

public class factoryPar implements CompteAbstract {
	private long code;
	private double solde;

	// private Date date;
	// private final String type ="PARTICULIER";
	public factoryPar(long code, double solde) {
		this.code = code;
		this.solde = solde;
		// this.type=type;
	}

	public Compte createCompte() {
		return new ComptePart(this.code, this.solde);
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}
}
