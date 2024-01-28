package designPatterns;

public class RetraitOp implements InterfaceOperation {

	private String type;

	public RetraitOp() {
		this.type = "retrait";
	}

	public String getType() {
		return type;
	}

	@Override
	public double operate(double solde, double montant) {
		// TODO Auto-generated method stub
		return solde - montant;
	}

}
