package fr.erdf.siae.business.a0x;

public class Reversi {
    public static char[][] positionnerNoir(String grilleLineaire) {
        TableJeu tableJeu = new TableJeu(grilleLineaire);
        tableJeu.copierGrille2DDepartVersArrivee();
        for (int i = 0; i < tableJeu.getGrille2DDepart().length; i++) {
            for (int j = 0; j < tableJeu.getGrille2DDepart().length; j++) {
                positionnerDirectionGauche(tableJeu, i, j);
                positionnerDirectionHautGauche(tableJeu, i, j);
                positionnerDirectionHaut(tableJeu, i, j);
                positionnerDirectionHautDroite(tableJeu, i, j);
                positionnerDirectionDroite(tableJeu, i, j);
                positionnerDirectionBasDroite(tableJeu, i, j);
                positionnerDirectionBas(tableJeu, i, j);
                positionnerDirectionBasGauche(tableJeu, i, j);
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

    private static void positionnerDirectionHautGauche(TableJeu tableJeu, int i, int j) {
        if (tableJeu.getGrille2DDepart()[i][j] == '.') {
            int iLocal = i;
            int jLocal = j;
            boolean haveW = false;
            while (jLocal > 0 && iLocal > 0 && tableJeu.getGrille2DDepart()[iLocal - 1][jLocal - 1] == 'W') {
                iLocal = iLocal - 1;
                jLocal = jLocal - 1;
                haveW = true;
            }
            if (haveW && jLocal > 0 && iLocal > 0 && tableJeu.getGrille2DDepart()[iLocal - 1][jLocal - 1] == 'B') {
                tableJeu.getGrille2DArrivee()[i][j] = 'B';
            }
        }
    }

    private static void positionnerDirectionDroite(TableJeu tableJeu, int i, int j) {
        if (tableJeu.getGrille2DDepart()[i][j] == '.' && j < tableJeu.getGrille2DDepart().length - 1) {
            int i_local = i;
            int j_local = j;
            boolean haveW = false;
            while (j_local < tableJeu.getGrille2DDepart().length - 1
                    && tableJeu.getGrille2DDepart()[i_local][j_local + 1] == 'W') {
                j_local = j_local + 1;
                haveW = true;
            }
            if (haveW && j_local > 0 && i_local < (tableJeu.getGrille2DDepart().length - 1)
                    && tableJeu.getGrille2DDepart()[i_local][j_local + 1] == 'B') {
                tableJeu.getGrille2DArrivee()[i][j] = 'B';
            }
        }
    }

    private static void positionnerDirectionBasDroite(TableJeu tableJeu, int i, int j) {
        if (tableJeu.getGrille2DDepart()[i][j] == '.' && i < tableJeu.getGrille2DDepart().length - 1
                && j < tableJeu.getGrille2DDepart().length - 1) {
            int i_local = i;
            int j_local = j;
            boolean haveW = false;
            while (i_local < tableJeu.getGrille2DDepart().length - 1
                    && j_local < tableJeu.getGrille2DDepart().length - 1
                    && tableJeu.getGrille2DDepart()[i_local + 1][j_local + 1] == 'W') {
                i_local = i_local + 1;
                j_local = j_local + 1;
                haveW = true;
            }
            if (haveW && i_local < (tableJeu.getGrille2DDepart().length - 1)
                    && j_local < (tableJeu.getGrille2DDepart().length - 1)
                    && tableJeu.getGrille2DDepart()[i_local + 1][j_local + 1] == 'B') {
                tableJeu.getGrille2DArrivee()[i][j] = 'B';
            }
        }
    }

    private static void positionnerDirectionBas(TableJeu tableJeu, int i, int j) {
        if (tableJeu.getGrille2DDepart()[i][j] == '.' && i < tableJeu.getGrille2DDepart().length - 1) {
            int i_local = i;
            int j_local = j;
            boolean haveW = false;
            while (i_local < tableJeu.getGrille2DDepart().length - 1
                    && tableJeu.getGrille2DDepart()[i_local + 1][j_local] == 'W') {
                i_local = i_local + 1;
                haveW = true;
            }
            if (haveW && i_local < (tableJeu.getGrille2DDepart().length - 1)
                    && tableJeu.getGrille2DDepart()[i_local + 1][j_local] == 'B') {
                tableJeu.getGrille2DArrivee()[i][j] = 'B';
            }
        }
    }

    private static void positionnerDirectionHautDroite(TableJeu tableJeu, int i, int j) {
        if (tableJeu.getGrille2DDepart()[i][j] == '.' && i > 0 && j < tableJeu.getGrille2DDepart().length - 1) {
            int i_local = i;
            int j_local = j;
            boolean haveW = false;
            while (i_local > 0 && j_local < tableJeu.getGrille2DDepart().length - 1
                    && tableJeu.getGrille2DDepart()[i_local - 1][j_local + 1] == 'W') {
                i_local = i_local - 1;
                j_local = j_local + 1;
                haveW = true;
            }
            if (haveW && i_local > 0 && j_local < (tableJeu.getGrille2DDepart().length - 1)
                    && tableJeu.getGrille2DDepart()[i_local - 1][j_local + 1] == 'B') {
                tableJeu.getGrille2DArrivee()[i][j] = 'B';
            }
        }
    }

    private static void positionnerDirectionHaut(TableJeu tableJeu, int i, int j) {
        if (tableJeu.getGrille2DDepart()[i][j] == '.') {
            int i_local = i;
            int j_local = j;
            boolean haveW = false;
            while (i_local > 0 && tableJeu.getGrille2DDepart()[i_local - 1][j_local] == 'W') {
                i_local = i_local - 1;
                haveW = true;
            }
            if (haveW && i_local > 0 && tableJeu.getGrille2DDepart()[i_local - 1][j_local] == 'B') {
                tableJeu.getGrille2DArrivee()[i][j] = 'B';
            }
        }
    }

    private static void positionnerDirectionBasGauche(TableJeu tableJeu, int i, int j) {
        if (tableJeu.getGrille2DDepart()[i][j] == '.' && i < tableJeu.getGrille2DDepart().length - 1) {
            int i_local = i;
            int j_local = j;
            boolean haveW = false;
            while (j_local > 0 && i_local < tableJeu.getGrille2DDepart().length - 1
                    && tableJeu.getGrille2DDepart()[i_local + 1][j_local - 1] == 'W') {
                i_local = i_local + 1;
                j_local = j_local - 1;
                haveW = true;
            }
            if (haveW && j_local > 0 && i_local < (tableJeu.getGrille2DDepart().length - 1)
                    && tableJeu.getGrille2DDepart()[i_local + 1][j_local - 1] == 'B') {
                tableJeu.getGrille2DArrivee()[i][j] = 'B';
            }
        }
    }
}
