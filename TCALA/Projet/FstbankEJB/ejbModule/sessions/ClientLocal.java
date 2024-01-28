package sessions;

import java.util.List;

import javax.ejb.Local;

import Exceptions.ErrorException;
import entity.Client;
import entity.Compte;
import entity.Compte_Client;

@Local
public interface ClientLocal {
	public List<Client> seConnecter(String username, String pwd);

	// public void virement (Compte c , double montant);
	// public void retrait(Compte c , double montant);
	public List<Compte> listerCompte(long id);

	public List<Compte_Client> getCompte_client_all_lakhdar(long id);

	public List<Compte_Client> getCompte_client_all(long id);

	public Client getClient(Long id);

	public List<Client> listerClient() throws ErrorException;

	public void addClient(Client a);

	public Client findClient(String id) throws ErrorException;
}
