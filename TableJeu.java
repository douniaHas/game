package fr.erdf.siae.business.a0x;

public class TableJeu {
    public static final char S_RETOUR_A_LA_LIGNE = '\n';
    private static final int DIM = 8;
    private String grilleLineaire;
    private char[][] grille2D;

    public TableJeu(String grilleLineaire) {
        if ("".equals(grilleLineaire) || grilleLineaire == null) {
            throw new IllegalArgumentException("La grille doit être initialisée");
        }
        this.grilleLineaire = grilleLineaire;
        this.grille2D = transformerListeEnGrille(grilleLineaire);
    }

    public TableJeu(TableJeu ancienneTableJeu) {
        this.grilleLineaire = ancienneTableJeu.getGrilleLineaire();
        char[][] copieGrille = new char[ancienneTableJeu.grille2D.length][];
        for (int i = 0; i < ancienneTableJeu.grille2D.length; i++) {
            copieGrille[i] = ancienneTableJeu.grille2D[i].clone();
        }
        this.grille2D = copieGrille;
    }

    private char[][] transformerListeEnGrille(String liste) {
        char[][] grille = new char[DIM][DIM];
        for (int i = 0; i < liste.length() - 1; i++) {
            if (liste.charAt(i) != S_RETOUR_A_LA_LIGNE) {
                grille[i / (DIM + 1)][i % (DIM + 1)] = liste.charAt(i);
            }
        }
        return grille;
    }

    public int getDim() {
        return DIM;
    }

    public String getGrilleLineaire() {
        return grilleLineaire;
    }

    public char[][] getGrille2D() {
        return grille2D;
    }
}
