package sessions;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Exceptions.ErrorException;
import designPatterns.InterfaceOperation;
import designPatterns.ObservateurOperation;
import designPatterns.Observateurs;
import designPatterns.Observe;
import designPatterns.ObserveCompte;
import entity.Compte;
import entity.ComptePart;
import entity.ComptePro;
import entity.Compte_Client;

/**
 * Session Bean implementation class CompteSessionBean
 */
@Stateless
@LocalBean
public class CompteSessionBean implements CompteSessionBeanLocal, CompteSessionBeanRemote {

	@PersistenceContext
	private EntityManager em;

	public CompteSessionBean() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public void create(Compte c) {
		// TODO Auto-generated method stub
		em.persist(c);

	}

	@Override
	public void update(Compte c) {
		// TODO Auto-generated method stub
		em.merge(c);

	}

	@Override
	public void remove(Compte c) {
		// TODO Auto-generated method stub
		em.remove(c);
	}

	@Override
	public Compte find(long id) {
		// TODO Auto-generated method stub
		Compte c = em.find(Compte.class, id);
		if (c != null)
			return c;
		else
			throw new RuntimeException("Erreur!!");

	}

	@Override
	public List<Compte_Client> listerCompteClient_lakhdar(long id) {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select cc from Compte_Client cc where client.id = :id ");
		req.setParameter("id", id);
		return req.getResultList();
	}

	@Override
	public List<Compte_Client> listerCompteClient(long id) {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select cc from Compte_Client cc where id = :id ");
		req.setParameter("id", id);
		return req.getResultList();
	}

	@Override
	public List<Compte> listerCompteBanquier(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compte> listerComptenonBanquier(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compte> listerCompte() throws ErrorException {
		List<Compte> list = null;
		try {
			Query req = em.createQuery("select c from Compte c");
			list = req.getResultList();
		} catch (NoResultException e) {
		}

		if (list == null) {
			throw new ErrorException("pas de comptes");
		} else
			return list;
	}

	@Override
	public Compte findCompte(long code) {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select cc from Compte cc where code = :code ");
		req.setParameter("code", code);
		Compte c = (Compte) req.getSingleResult();
		return c;
	}

	/*
	 * @Override
	 * public void do_operate(Compte c, double montant ,InterfaceOperation op) {
	 * 
	 * Observateurs observateur = new ObservateurOperation();
	 * Observe observe = new ObserveCompte();
	 * observe.setSolde(c.getSolde());
	 * observe.addObservateur(observateur);
	 * c.setSolde(observe.do_op(op, montant));
	 * em.merge(c);
	 * }
	 */

}
