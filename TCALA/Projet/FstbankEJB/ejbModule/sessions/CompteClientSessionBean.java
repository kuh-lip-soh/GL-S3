package sessions;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Exceptions.ErrorException;
import entity.Banquier;
import entity.Compte_Client;

/**
 * Session Bean implementation class CompteClientSessionBean
 */
@Stateless
@LocalBean
public class CompteClientSessionBean implements CompteClientSessionBeanLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	private EntityManager em;

	public CompteClientSessionBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(Compte_Client a) {
		// TODO Auto-generated method stub
		em.persist(a);
	}

	@Override
	public String getType(Long id) throws ErrorException {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select b from Compte_Client b where b.cmpt.id = :id");
		req.setParameter("id", id);
		List<Compte_Client> liste = null;
		String type = null;
		try {
			liste = req.getResultList();
		} catch (NoResultException e) {
		}

		if (liste == null) {
			throw new ErrorException("pas de compte");
		} else {
			return liste.get(0).getType_cc();
		}

	}

	@Override
	public int getNumber(long id) throws ErrorException {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select b from Compte_Client b where b.cmpt.id = :id");
		req.setParameter("id", id);
		List<Compte_Client> cc = null;
		int liste = 0;

		try {

			cc = req.getResultList();
			liste = cc.size();
		} catch (NoResultException e) {
		}

		if (cc == null) {
			throw new ErrorException("pas de comptes");
		} else {
			return liste;
		}

	}

}
