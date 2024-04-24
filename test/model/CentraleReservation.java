package model;

public class CentraleReservation<T extends EntiteReservable> {
    private T[] entites;
    private int nombreEntites;

    public CentraleReservation(int tailleMax) {
        this.entites = (T[]) new EntiteReservable[tailleMax];
        this.nombreEntites = 0;
    }

    public int ajouterEntite(T entite) {
        if (nombreEntites < entites.length) {
            entites[nombreEntites] = entite;
            return ++nombreEntites;
        } else {
            return 0;
        }
    }

    public int getNombreEntites() {
        return nombreEntites;
    }

    public T getEntite(int index) {
        return entites[index];
    }

    public int[] donnerPossibilites(Formulaire formulaire) {
        int[] possibilites = new int[nombreEntites];
        for (int i = 0; i < nombreEntites; i++) {
            if (entites[i].compatible(formulaire) && entites[i].estLibre(formulaire.getJour(), formulaire.getMois())) {
                possibilites[i] = entites[i].getNumero();
            } else {
                possibilites[i] = 0;
            }
        }
        return possibilites;
    }

    public Reservation reserver(int numeroEntite, int jour, int numeroService, T entite, Formulaire formulaire) {
        if (entite.compatible(formulaire) && entite.estLibre(jour, formulaire.getMois())) {
            formulaire.setNumeroEntite(entite.getNumero());
            return entite.reserver(formulaire);
        } else {
            return null;
        }
    }
}
