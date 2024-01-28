package designPatterns;

import java.util.ArrayList;

public class ObserveCompte extends Observe {
	public ArrayList<Observateurs> obs = new ArrayList<Observateurs>();

	@Override
	public void addObservateur(Observateurs o) {
		// TODO Auto-generated method stub
		obs.add(o);
	}

	@Override
	public void removeObservateur(Observateurs o) {
		// TODO Auto-generated method stub
		obs.remove(o);
	}

	@Override
	public void notifyObservateur(InterfaceOperation op, long client_id, long compte_id, double montant) {
		// TODO Auto-generated method stub
		for (Observateurs observateurs : getObs()) {
			observateurs.updateObserve(op, client_id, compte_id, montant);
		}

	}

	/*
	 * public void setSolde(double solde , double montant) {
	 * this.setSolde(solde);
	 * this.notifyObservateur(montant);
	 * }
	 */
	public void do_op(InterfaceOperation op, long client_id, long compte_id, double montant) {
		// this.setOp(op);
		// this.setSolde(op.operate(solde, montant));
		this.notifyObservateur(op, client_id, compte_id, montant);

		// return this.getSolde();
	}

	public ArrayList<Observateurs> getObs() {
		return obs;
	}

}
