package fr.erdf.siae.business.a0x;

public class Reversi {
    public static char[][] positionnerNoir(String grilleLineaire) {
        TableJeu tableJeu = new TableJeu(grilleLineaire);
        tableJeu.copierGrille2DDepartVersArrivee();
        for (int i = 0; i < tableJeu.getGrille2DDepart().length; i++) {
            for (int j = 0; j < tableJeu.getGrille2DDepart().length; j++) {
                // i,j-1
                positionnerDirectionGauche(tableJeu, i, j);
            }
        }
        return tableJeu.getGrille2DArrivee();
    }

    private static void positionnerDirectionGauche(TableJeu tableJeu, int i, int j) {
        if (tableJeu.getGrille2DDepart()[i][j] == '.') {
            int iLocal = i;
            int jLocal = j;
            boolean haveW = false;
            while (jLocal > 0 && tableJeu.getGrille2DDepart()[iLocal][jLocal - 1] == 'W') {
                jLocal = jLocal - 1;
                haveW = true;
            }
            if (haveW && jLocal > 0 && tableJeu.getGrille2DDepart()[iLocal][jLocal - 1] == 'B') {
                tableJeu.getGrille2DArrivee()[i][j] = 'B';
            }
        }
    }
}
