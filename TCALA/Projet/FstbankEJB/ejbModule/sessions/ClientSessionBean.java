package sessions;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Exceptions.ErrorException;
import designPatterns.RetraitOp;
import designPatterns.VirementOp;
import entity.Client;
import entity.Compte;
import entity.Compte_Client;

/**
 * Session Bean implementation class Client
 */
@Stateless
@LocalBean
public class ClientSessionBean implements ClientLocal, ClientRemote {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	private EntityManager em;
	@EJB
	private CompteSessionBeanLocal csb;

	public ClientSessionBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Client getClient(Long id) {
		Client client = em.find(Client.class, id);
		if (client == null)
			throw new RuntimeException("Client introuvable");
		return client;
	}

	@Override
	public List<Client> seConnecter(String username, String pwd) {
		Query req = em.createQuery("select b from Client b where b.username like :username and b.pwd like :pwd");
		req.setParameter("username", username);
		req.setParameter("pwd", pwd);
		List<Client> clients = req.getResultList();

		if (clients == null)
			return null;// throw new RuntimeException("client n'existe pas");
		else
			return clients;
	}
	/*
	 * @Override
	 * public void virement(Compte c, double montant) {
	 * 
	 * csb.do_operate(c, montant, new VirementOp());
	 * }
	 */
	/*
	 * @Override
	 * public void retrait(Compte c, double montant) {
	 * // TODO Auto-generated method stub
	 * csb.do_operate(c, montant, new RetraitOp());
	 * }
	 */

	// srali prbleme fi hadi rani khdemte b getCompte_client_all()
	@Override
	public List<Compte> listerCompte(long id) {
		// TODO Auto-generated method stub
		List<Compte> liste = null;
		for (Compte_Client res : csb.listerCompteClient(id)) {
			// Compte a= csb.find(res.getCmpt().getCode());
			Compte a = res.getCmpt();
			liste.add(a);
		}
		return liste;
	}

	@Override
	public List<Compte_Client> getCompte_client_all_lakhdar(long id) {
		// TODO Auto-generated method stub
		return csb.listerCompteClient_lakhdar(id);
	}

	@Override
	public List<Compte_Client> getCompte_client_all(long id) {
		// TODO Auto-generated method stub
		return csb.listerCompteClient(id);
	}

	public List<Client> listerClient() throws ErrorException {
		List<Client> list = null;
		try {
			Query req = em.createQuery("select c from Client c");
			list = req.getResultList();
		} catch (NoResultException e) {
		}

		if (list == null) {
			throw new ErrorException("pas de clients");
		} else
			return list;
	}

	@Override
	public void addClient(Client a) {
		// TODO Auto-generated method stub
		em.persist(a);
	}

	@Override
	public Client findClient(String id) throws ErrorException {
		Client list = null;
		try {
			Query req = em.createQuery("select c from Client c where c.username like :username");
			req.setParameter("username", id);
			list = (Client) req.getSingleResult();
		} catch (NoResultException e) {
		}

		if (list == null) {
			throw new ErrorException("pas de clients");
		} else
			return list;
	}

}
