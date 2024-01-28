package Exceptions;

public interface ValidationInput {
    public void validerCompteExiste(String a);

    public void validerCompteNonExiste(String code, String solde, String type, String typecc, String registre);

    public void validerClientExiste(String[] client_id);

    public void validerClientNonExiste(String code, String solde);

    public void validerTout(String a, int num) throws ErrorException;

    public int validerAssocier(String a, int num);
}