package model;

public class FormulaireRestaurant extends Formulaire {
    private int nombrePersonnes;
    private int numeroService;

    public FormulaireRestaurant(int jour, int mois, int numeroTable, int nombrePersonnes, int numeroService) {
        super(jour, mois, numeroTable,0);
        this.nombrePersonnes = nombrePersonnes;
        this.numeroService = numeroService;
    }

    public int getNombrePersonnes() {
        return nombrePersonnes;
    }

    public int getNumeroService() {
        return numeroService;
    }
    
    

}
