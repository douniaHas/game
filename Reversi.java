package fr.erdf.siae.business.a0x;

public class Reversi {
    public static final char S_RETOUR_A_LA_LIGNE = '\n';

    public static char[][] transformerListeEnGrille(String liste) {
        TableJeu tableJeu = new TableJeu(liste);
        char[][] grille = new char[tableJeu.getDim()][tableJeu.getDim()];
        for (int i = 0; i < tableJeu.getGrilleLineaire().length() - 1; i++) {
            if (tableJeu.getGrilleLineaire().charAt(i) != S_RETOUR_A_LA_LIGNE) {
                grille[i / (tableJeu.getDim() + 1)][i % (tableJeu.getDim() + 1)] = tableJeu.getGrilleLineaire()
                        .charAt(i);
            }
        }
        return grille;
    }
}
