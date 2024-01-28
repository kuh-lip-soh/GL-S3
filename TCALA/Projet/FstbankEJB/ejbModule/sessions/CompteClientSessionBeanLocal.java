package sessions;

import javax.ejb.Local;

import Exceptions.ErrorException;
import entity.Compte_Client;

@Local
public interface CompteClientSessionBeanLocal {
    public void add(Compte_Client a);

    public String getType(Long id) throws ErrorException;

    public int getNumber(long id) throws ErrorException;
}
