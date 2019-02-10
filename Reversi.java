package fr.erdf.siae.business.a0x;

public class Reversi {
    public static final int S_DIM = 8;
    public static final char S_RETOUR_A_LA_LIGNE = '\n';

    public static char[][] transformerListeEnGrille(String grilleLineaire) {
        char[][] grille = new char[S_DIM][S_DIM];
        for (int i = 0; i < grilleLineaire.length() - 1; i++) {
            if (grilleLineaire.charAt(i) != S_RETOUR_A_LA_LIGNE) {
                grille[i / (S_DIM + 1)][i % (S_DIM + 1)] = grilleLineaire.charAt(i);
            }
        }
        return grille;
    }
}
