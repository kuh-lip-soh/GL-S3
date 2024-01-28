package designPatterns;

public interface Observateurs {
    public void updateObserve(InterfaceOperation op, long client_id, long compte_id, double montant);
}
