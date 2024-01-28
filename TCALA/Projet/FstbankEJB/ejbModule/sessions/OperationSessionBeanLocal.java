package sessions;

import javax.ejb.Local;

import entity.Operations;

@Local
public interface OperationSessionBeanLocal {
    public void create(Operations Op);

    public void find(long id);

}
