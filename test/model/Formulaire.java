package model;

public abstract class Formulaire {
    protected int jour;
    protected int mois;
    protected int numeroEntite;

    public Formulaire(int jour, int mois, int numeroEntite) {
        this.jour = jour;
        this.mois = mois;
        this.numeroEntite = numeroEntite;
    }

    public int getJour() {
        return jour;
    }

    public int getMois() {
        return mois;
    }

    public int getNumeroEntite() {
        return numeroEntite;
    }

    public void setNumeroEntite(int numeroEntite) {
        this.numeroEntite = numeroEntite;
    }
}
