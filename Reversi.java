package fr.erdf.siae.business.a0x;

public class Reversi {
    public static char[][] transformerListeEnGrille(String grilleLineaire) {
        int dim = 8;
        char[][] grille = new char[dim][dim];
        for (int i = 0; i < grilleLineaire.length() - 1; i++) {
            if (grilleLineaire.charAt(i) != '\n') {
                grille[i / (dim + 1)][i % (dim + 1)] = grilleLineaire.charAt(i);
            }
        }
        return grille;
    }
}
