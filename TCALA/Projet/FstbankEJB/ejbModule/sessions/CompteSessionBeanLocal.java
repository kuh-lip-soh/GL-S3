package sessions;

import java.util.List;

import javax.ejb.Local;

import Exceptions.ErrorException;
import designPatterns.InterfaceOperation;
import entity.Compte;
import entity.Compte_Client;

@Local
public interface CompteSessionBeanLocal {

	public void create(Compte c);

	public void update(Compte c);

	public void remove(Compte c);

	public Compte find(long id);

	public List<Compte_Client> listerCompteClient_lakhdar(long id);

	public List<Compte_Client> listerCompteClient(long id);

	public List<Compte> listerCompteBanquier(long id);

	public List<Compte> listerCompte() throws ErrorException;

	public Compte findCompte(long code);
	// public void do_operate(Compte c,double montant ,InterfaceOperation op);
}
