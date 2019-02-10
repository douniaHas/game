package fr.erdf.siae.business.a0x;

public class Reversi {
    public static char[][] positionnerNoir(String grilleLineaire) {
        TableJeu tableJeu = new TableJeu(grilleLineaire);
        TableJeu tableJeuCopie = new TableJeu(tableJeu);
        for (int i = 0; i < tableJeu.getGrille2D().length; i++) {
            for (int j = 0; j < tableJeu.getGrille2D().length; j++) {
                // i,j-1
                positionnerDirectionGauche(tableJeu.getGrille2D(), tableJeuCopie.getGrille2D(), i, j);
            }
        }
        return tableJeuCopie.getGrille2D();
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
}
