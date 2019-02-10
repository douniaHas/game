package fr.erdf.siae.business.a0x;

public class TableJeu {
    private static final int DIM = 8;
    private String grilleLineaire;

    public TableJeu(String grilleLineaire) {
        if ("".equals(grilleLineaire) || grilleLineaire == null) {
            throw new IllegalArgumentException("La grille doit être initialisée");
        }
        this.grilleLineaire = grilleLineaire;
    }

    public int getDim() {
        return DIM;
    }

    public String getGrilleLineaire() {
        return grilleLineaire;
    }
}
