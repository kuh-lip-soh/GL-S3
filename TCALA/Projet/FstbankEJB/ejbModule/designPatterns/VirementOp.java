package designPatterns;

public class VirementOp implements InterfaceOperation {

	private String type;

	public VirementOp() {
		this.type = "virement";
	}

	public String getType() {
		return type;
	}

	@Override
	public double operate(double solde, double montant) {
		// TODO Auto-generated method stub
		return solde + montant;
	}

}
