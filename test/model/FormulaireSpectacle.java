package model;

public class FormulaireSpectacle extends Formulaire {
    private int numeroZone;

    public FormulaireSpectacle(int jour, int mois, int numeroPlace, int numeroZone) {
        super(jour, mois, numeroPlace);
        this.numeroZone = numeroZone;
    }

    public int getNumeroZone() {
        return numeroZone;
    }
}
