package designPatterns;

import entity.Compte;
import entity.ComptePro;

public class FactoryProf implements CompteAbstract {
	private long code;
	private double solde;
	private String reg_com;

	// private final String type ="PARTICULIER";
	public FactoryProf(long code, double solde, String reg_com) {
		this.code = code;
		this.solde = solde;
		this.reg_com = reg_com;
		// this.type=type;
	}

	public Compte createCompte() {

		return new ComptePro(this.code, this.solde, this.reg_com);
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

	public String getReg_com() {
		return reg_com;
	}

	public void setReg_com(String reg_com) {
		this.reg_com = reg_com;
	}
}
