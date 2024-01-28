package sessions;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import designPatterns.InterfaceOperation;
import entity.Compte;
import entity.Compte_Client;

@Remote
public interface CompteSessionBeanRemote {

	public void create(Compte c);

	public void update(Compte c);

	public void remove(Compte c);

	public Compte find(long id);

	public List<Compte_Client> listerCompteClient_lakhdar(long id);

	public List<Compte_Client> listerCompteClient(long id);

	public List<Compte> listerCompteBanquier(long id);

	public List<Compte> listerComptenonBanquier(long id);
	// public void do_operate(Compte c,double montant ,InterfaceOperation op);
}
