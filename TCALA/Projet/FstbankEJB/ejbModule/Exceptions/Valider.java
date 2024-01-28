package Exceptions;

import java.util.ArrayList;

public class Valider implements ValidationInput {
	private ArrayList<String> errors;

	public Valider() {
		// TODO Auto-generated constructor stub
		errors = new ArrayList<String>();
	}

	@Override
	public void validerCompteExiste(String a) {
		// TODO Auto-generated method stub
		if (a == null) {
			errors.add("compte");
		}
	}

	@Override
	public void validerCompteNonExiste(String code, String solde, String type, String typecc, String registre) {
		if (code == null) {
			errors.add("code");
		}
		if (solde == null) {
			errors.add("solde");
		}
		if (type == null) {
			errors.add("type");
		} else {
			if (type.equals("1") && registre == null)
				errors.add("registre commercial");
			if (type.equals("2") && typecc == null)
				errors.add("compte privé ou partagé");
		}

	}

	@Override
	public void validerClientExiste(String[] client_id) {
		// TODO Auto-generated method stub
		if (client_id == null) {
			errors.add("client");
		}
	}

	@Override
	public void validerClientNonExiste(String nom, String prenom) {
		// TODO Auto-generated method stub
		if (nom == null) {
			errors.add("nom");
		}
		if (prenom == null) {
			errors.add("prenom");
		}
	}

	@Override
	public void validerTout(String b, int num) throws ErrorException {
		// TODO Auto-generated method stub
		String a = " ";
		if (this.getErrors().size() > 0) {
			for (int i = 0; i < this.getErrors().size(); i++) {
				a = a + this.getErrors().get(i) + " ";
			}

			throw new ErrorException("Vous devez remplir les champs : " + a);
		} else {
			if (validerAssocier(b, num) == -1) {
				throw new ErrorException("Vous n'avez pas le droit d'association");
			}
		}
	}

	public ArrayList<String> getErrors() {
		return errors;
	}

	public void setErrors(ArrayList<String> errors) {
		this.errors = errors;
	}

	@Override
	public int validerAssocier(String a, int num) {
		// TODO Auto-generated method stub
		if (a.equals("Partag�") && num >= 10)
			return -1;
		else if (a.equals("Priv�") && num >= 1)
			return -1;
		else
			return 1;
	}

}
