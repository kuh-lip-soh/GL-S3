package sessions;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.NoResultException;

import Exceptions.ErrorException;
import entity.Banquier;
import entity.Compte;
import entity.Compte_Client;

@Local
public interface BanquierLocal {
    public Banquier seConnecter(String username, String pwd) throws ErrorException;

    public List<Compte> lister();

    public List<Compte_Client> listerCompteBanquier(long id) throws ErrorException;
}
