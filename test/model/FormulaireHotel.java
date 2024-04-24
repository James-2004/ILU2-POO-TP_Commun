package model;

public class FormulaireHotel extends Formulaire {
    private int nbLitSimple;
    private int nbLitDouble;

    public FormulaireHotel(int jour, int mois, int numeroChambre, int nbLitSimple, int nbLitDouble) {
        super(jour, mois, numeroChambre, nbLitDouble);
        this.nbLitSimple = nbLitSimple;
        this.nbLitDouble = nbLitDouble;
    }

    public int getNbLitSimple() {
        return nbLitSimple;
    }

    public int getNbLitDouble() {
        return nbLitDouble;
    }
}
