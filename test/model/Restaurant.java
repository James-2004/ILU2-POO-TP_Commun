package model;

public class Restaurant {
    private CentraleReservation<Table> centraleReservation;

    public Restaurant() {
        centraleReservation = new CentraleReservation<>(50);
    }

    public void ajouterTable(int nombreChaises) {
        int numeroTable = centraleReservation.ajouterEntite(new Table(nombreChaises));
        System.out.println("Table ajoutée avec succès. Numéro de la table : " + numeroTable);
    }

    public int[] donnerPossibilites(FormulaireRestaurant formulaire) {
        int[] possibilites = new int[centraleReservation.getNombreEntites()];
        for (int i = 0; i < centraleReservation.getNombreEntites(); i++) {
            Table table = centraleReservation.getEntite(i);
            if (table.compatible(formulaire) && table.estLibre(formulaire.getJour(), formulaire.getMois())) {
                possibilites[i] = table.getNumero();
            }
        }
        return possibilites;
    }

    public Reservation reserver(int numeroTable, FormulaireRestaurant formulaire) {
        Table table = centraleReservation.getEntite(numeroTable - 1);
        if (table != null) {
            return table.reserver(formulaire);
        } else {
            System.out.println("La table numéro " + numeroTable + " n'existe pas.");
            return null;
        }
    }

    private class Table extends EntiteReservable {
        private int nombreChaises;
        private boolean[] disponibilites;

        public Table(int nombreChaises) {
            super(0);
            this.nombreChaises = nombreChaises;
            this.disponibilites = new boolean[31]; // 31 jours dans un mois
        }

        @Override
        public boolean estLibre(int jour, int mois) {
            return disponibilites[jour - 1];
        }

        @Override
        public boolean compatible(Formulaire formulaire) {
            FormulaireRestaurant formulaireRestaurant = (FormulaireRestaurant) formulaire;
            return nombreChaises >= formulaireRestaurant.getNombrePersonnes();
        }

        @Override
        public Reservation reserver(Formulaire formulaire) {
            FormulaireRestaurant formulaireRestaurant = (FormulaireRestaurant) formulaire;
            int jour = formulaireRestaurant.getJour();

            if (estLibre(jour, formulaire.getMois()) && compatible(formulaire)) {
                disponibilites[jour - 1] = true; // Marquer la table comme réservée
                return new ReservationRestaurant(jour, formulaireRestaurant.getMois(), getNumero(), formulaireRestaurant.getNumeroService());
            } else {
                return null;
            }
        }

    }
}

