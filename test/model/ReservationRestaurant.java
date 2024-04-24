package model;

public class ReservationRestaurant extends Reservation {
    private int numeroTable;
    private int numeroService;

    public ReservationRestaurant(int jour, int mois, int numeroTable, int numeroService) {
        super(jour, mois);
        this.numeroTable = numeroTable;
        this.numeroService = numeroService;
    }

    @Override
    public String toString() {
        return "Le " + jour + "/" + mois + "\nTable " + numeroTable + " pour le " + ((numeroService == 1) ? "premier" : "deuxième") + " service.";
    }

    // Classe interne ReservationHotel
    public class ReservationHotel extends Reservation {
        private int nbLitSimple;
        private int nbLitDouble;
        private int numeroChambre;

        public ReservationHotel(int jour, int mois, int nbLitSimple, int nbLitDouble, int numeroChambre) {
            super(jour, mois);
            this.nbLitSimple = nbLitSimple;
            this.nbLitDouble = nbLitDouble;
            this.numeroChambre = numeroChambre;
        }

        @Override
        public String toString() {
            return "Le " + jour + "/" + mois + "\nChambre n°" + numeroChambre + " avec " + nbLitSimple + " lit(s) simple(s) et " + nbLitDouble + " lit(s) double(s).";
        }
    }

    // Classe interne ReservationSpectacle
    public class ReservationSpectacle extends Reservation {
        private int numeroZone;
        private int numeroChaise;

        public ReservationSpectacle(int jour, int mois, int numeroZone, int numeroChaise) {
            super(jour, mois);
            this.numeroZone = numeroZone;
            this.numeroChaise = numeroChaise;
        }

        @Override
        public String toString() {
            return "Le " + jour + "/" + mois + "\nPlace dans la zone n°" + numeroZone + ", chaise n°" + numeroChaise + ".";
        }
    }
}
