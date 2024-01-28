package designPatterns;

import entity.Compte;

public class AbstractFactoryCompte {
	public AbstractFactoryCompte() {
	}

	public Compte getCompte(CompteAbstract factoryProf) {
		return factoryProf.createCompte();
	}

}
