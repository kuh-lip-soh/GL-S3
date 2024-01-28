package designPatterns;

public abstract class Observe {

	// protected double solde = 1500;
	protected InterfaceOperation op;

	public Observe() {

	}
	/*
	 * public double getSolde() {
	 * return solde;
	 * }
	 */
	/*
	 * public void setSolde(double solde) {
	 * this.solde = solde;
	 * //this.notifyObservateur(montant);
	 * }
	 */

	/*
	 * public InterfaceOperation getOp() {
	 * return op;
	 * }
	 */

	/*
	 * public void setOp(InterfaceOperation op) {
	 * this.op = op;
	 * }
	 */
	public abstract void addObservateur(Observateurs o);

	public abstract void removeObservateur(Observateurs o);

	public abstract void notifyObservateur(InterfaceOperation op, long client_id, long compte_id, double montant);

	// public abstract void setSolde(double solde , double montant) ;
	public abstract void do_op(InterfaceOperation op, long client_id, long compte_id, double montant);
}
