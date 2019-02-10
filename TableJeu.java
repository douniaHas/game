package fr.erdf.siae.business.a0x;

public class TableJeu {
    private static final int DIM = 8;
    private String grilleLineaire;

    public TableJeu(String grilleLineaire) {
        this.grilleLineaire = grilleLineaire;
    }

    public int getDim() {
        return DIM;
    }

    public String getGrilleLineaire() {
        return grilleLineaire;
    }
}
