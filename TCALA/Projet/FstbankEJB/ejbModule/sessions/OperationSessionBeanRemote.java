package sessions;

import javax.ejb.Remote;

import entity.Operations;

@Remote
public interface OperationSessionBeanRemote {
    public void create(Operations Op);

    public void find(long id);
}
