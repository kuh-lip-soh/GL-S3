package designPatterns;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entity.Client;
import entity.Compte;
import entity.Retrait;
import entity.Virement;
import sessions.ClientRemote;
import sessions.CompteSessionBeanRemote;
import sessions.OperationSessionBeanRemote;

public class ObservateurOperation implements Observateurs {
	Context ctx;

	@Override
	public void updateObserve(InterfaceOperation op, long client_id, long compte_id, double montant) {

		try {
			Properties jnd = new Properties();

			jnd.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
			jnd.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
			ctx = new InitialContext(jnd);
			OperationSessionBeanRemote operation_remote = (OperationSessionBeanRemote) ctx
					.lookup("ejb:/BankEAR/fstbankEJB/OperationSessionBean!sessions.OperationSessionBeanRemote");
			CompteSessionBeanRemote compte_remote = (CompteSessionBeanRemote) ctx
					.lookup("ejb:/BankEAR/fstbankEJB/CompteSessionBean!sessions.CompteSessionBeanRemote");
			ClientRemote client_remote = (ClientRemote) ctx
					.lookup("ejb:/BankEAR/fstbankEJB/ClientSessionBean!sessions.ClientRemote");

			Client client = client_remote.getClient(client_id);

			Compte compte = compte_remote.find(compte_id);
			compte.setSolde(op.operate(compte.getSolde(), montant));
			compte_remote.update(compte);

			if (op.getType().equals("retrait")) {
				operation_remote.create(new Retrait(client, compte, montant));
			} else {
				operation_remote.create(new Virement(client, compte, montant));
			}

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
