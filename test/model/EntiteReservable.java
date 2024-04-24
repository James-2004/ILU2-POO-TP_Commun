package model;

public abstract class EntiteReservable {
    protected Calendrier calendrier;
    protected int numero;

    public EntiteReservable(int numero) {
        this.calendrier = new Calendrier();
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    // Vérifie si l'entité est libre pour le jour et le mois donnés
    public abstract boolean estLibre(int jour, int mois);

    // Vérifie si l'entité est compatible avec le formulaire de réservation donné
    public abstract boolean compatible(Formulaire formulaire);

    // Réserve l'entité en fonction des données du formulaire de réservation
    // Retourne une nouvelle réservation si la réservation est réussie, sinon retourne null
    public abstract Reservation reserver(Formulaire formulaire);
}
