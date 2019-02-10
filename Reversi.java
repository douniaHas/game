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

    public static char[][] positionnerNoir(String grilleLineaire) {
        char[][] grille = transformerListeEnGrille(grilleLineaire);
        char[][] grilleRes = copier(grille);
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille.length; j++) {
                // i,j-1
                positionnerDirectionGauche(grille, grilleRes, i, j);
            }
        }
        return grilleRes;
    }

    private static void positionnerDirectionGauche(char[][] grille, char[][] grilleRes, int i, int j) {
        if (grille[i][j] == '.') {
            int i_local = i;
            int j_local = j;
            boolean haveW = false;
            while (j_local > 0 && grille[i_local][j_local - 1] == 'W') {
                j_local = j_local - 1;
                haveW = true;
            }
            if (haveW && j_local > 0 && grille[i_local][j_local - 1] == 'B') {
                grilleRes[i][j] = 'B';
            }
        }
    }

    private static char[][] copier(char[][] grille) {
        char[][] copie = new char[grille.length][];
        for (int i = 0; i < grille.length; i++) {
            copie[i] = grille[i].clone();
        }
        return copie;
    }
}
