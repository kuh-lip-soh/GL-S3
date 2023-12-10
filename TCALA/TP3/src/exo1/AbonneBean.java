package exo1;

import java.beans.*;

public class AbonneBean implements java.io.Serializable {
    private String nom;
    private String prenom;
    private String email;
    private String centreInteret;

    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public AbonneBean() {
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        String oldNom = this.nom;
        this.nom = nom;
        pcs.firePropertyChange("nom", oldNom, nom);
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        String oldPrenom = this.prenom;
        this.prenom = prenom;
        pcs.firePropertyChange("prenom", oldPrenom, prenom);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        pcs.firePropertyChange("email", oldEmail, email);
    }

    public String getCentreInteret() {
        return centreInteret;
    }

    public void setCentreInteret(String centreInteret) {
        String oldCentreInteret = this.centreInteret;
        this.centreInteret = centreInteret;
        pcs.firePropertyChange("centreInteret", oldCentreInteret, centreInteret);
    }


    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }
}
