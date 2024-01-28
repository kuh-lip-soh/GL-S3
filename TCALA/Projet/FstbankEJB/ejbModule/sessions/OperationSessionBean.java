package sessions;

import designPatterns.ObservateurOperation;
import designPatterns.Observateurs;
import entity.Operations;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class OperationSessionBean
 */

@Stateless
public class OperationSessionBean implements OperationSessionBeanLocal, OperationSessionBeanRemote {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * @see Observateurs#update()
	 */

	public void create(Operations Op) {
		// TODO Auto-generated method stub
		em.persist(Op);
	}

	@Override
	public void find(long id) {
		// TODO Auto-generated method stub

	}

}
