package sessions;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Exceptions.ErrorException;
import entity.Banquier;
import entity.Compte;
import entity.Compte_Client;

/**
 * Session Bean implementation class Banquier
 */
@Stateless
@LocalBean
public class BanquierSessionBean implements BanquierLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	private EntityManager em;

	public BanquierSessionBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Banquier seConnecter(String username, String pwd) throws ErrorException {
		Query req = em.createQuery("select b from Banquier b where b.username like :username and b.pwd like :pwd");
		req.setParameter("username", username);
		req.setParameter("pwd", pwd);
		Banquier bnq = null;
		try {
			bnq = (Banquier) req.getSingleResult();
		} catch (NoResultException e) {
		}

		if (bnq == null) {
			throw new ErrorException("username ou mot de passe incorrects");
		} else
			return bnq;

	}

	@Override
	public List<Compte> lister() {
		Query req = em.createQuery("select b from Compte b ");
		List<Compte> bnqs = req.getResultList();
		if (bnqs == null)
			throw new RuntimeException("banquier n'existe pas");
		else
			return bnqs;
	}

	@Override
	public List<Compte_Client> listerCompteBanquier(long id) throws ErrorException {
		Query req = em.createQuery("select  b from Compte_Client b where b.banquier.id_bnq = :id");
		req.setParameter("id", id);
		List<Compte_Client> cc = null;
		List<Compte_Client> comptes = new ArrayList<Compte_Client>();
		try {
			cc = (List<Compte_Client>) req.getResultList();
			for (int i = 0; i < cc.size(); i++) {
				int k = 0;
				for (int j = i + 1; j < cc.size(); j++) {
					if (cc.get(i).getCmpt().getId() == cc.get(j).getCmpt().getId()) {
						k++;
					}

				}
				if (k == 0)
					comptes.add(cc.get(i));
			}
		} catch (NoResultException e) {
		}

		if (cc == null) {
			throw new ErrorException("Aucun Compte trouv�");
		} else
			return comptes;
	}

}
