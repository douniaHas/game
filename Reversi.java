package fr.erdf.siae.business.a0x;

public class Reversi {
    public static char joueurActuel = 'B';
    public static char joueurOppose = 'W';

    public static char[][] positionnerNoir(String grilleLineaire) {
        TableJeu tableJeu = new TableJeu(grilleLineaire);
        tableJeu.copierGrille2DDepartVersArrivee();
        for (int i = 0; i < tableJeu.getGrille2DDepart().length; i++) {
            for (int j = 0; j < tableJeu.getGrille2DDepart().length; j++) {
                if (tableJeu.getGrille2DDepart()[i][j] == '.') {
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
        }
        return tableJeu.getGrille2DArrivee();
    }

    private static void positionnerDirectionGauche(TableJeu tableJeu, int i, int j) {
        int iLocal = i;
        int jLocal = j;
        boolean haveW = false;
        while (jLocal > 0 && tableJeu.getGrille2DDepart()[iLocal][jLocal - 1] == joueurOppose) {
            jLocal = jLocal - 1;
            haveW = true;
        }
        if (haveW && jLocal > 0 && tableJeu.getGrille2DDepart()[iLocal][jLocal - 1] == joueurActuel) {
            tableJeu.getGrille2DArrivee()[i][j] = joueurActuel;
        }
    }

    private static void positionnerDirectionHautGauche(TableJeu tableJeu, int i, int j) {
        int iLocal = i;
        int jLocal = j;
        boolean haveW = false;
        while (jLocal > 0 && iLocal > 0 && tableJeu.getGrille2DDepart()[iLocal - 1][jLocal - 1] == joueurOppose) {
            iLocal = iLocal - 1;
            jLocal = jLocal - 1;
            haveW = true;
        }
        if (haveW && jLocal > 0 && iLocal > 0 && tableJeu.getGrille2DDepart()[iLocal - 1][jLocal - 1] == joueurActuel) {
            tableJeu.getGrille2DArrivee()[i][j] = joueurActuel;
        }
    }

    private static void positionnerDirectionDroite(TableJeu tableJeu, int i, int j) {
        if (j < tableJeu.getGrille2DDepart().length - 1) {
            int iLocal = i;
            int jLocal = j;
            boolean haveW = false;
            while (jLocal < tableJeu.getGrille2DDepart().length - 1
                    && tableJeu.getGrille2DDepart()[iLocal][jLocal + 1] == joueurOppose) {
                jLocal = jLocal + 1;
                haveW = true;
            }
            if (haveW && jLocal > 0 && iLocal < (tableJeu.getGrille2DDepart().length - 1)
                    && tableJeu.getGrille2DDepart()[iLocal][jLocal + 1] == joueurActuel) {
                tableJeu.getGrille2DArrivee()[i][j] = joueurActuel;
            }
        }
    }

    private static void positionnerDirectionBasDroite(TableJeu tableJeu, int i, int j) {
        if (i < tableJeu.getGrille2DDepart().length - 1 && j < tableJeu.getGrille2DDepart().length - 1) {
            int iLocal = i;
            int jLocal = j;
            boolean haveW = false;
            while (iLocal < tableJeu.getGrille2DDepart().length - 1 && jLocal < tableJeu.getGrille2DDepart().length - 1
                    && tableJeu.getGrille2DDepart()[iLocal + 1][jLocal + 1] == 'W') {
                iLocal = iLocal + 1;
                jLocal = jLocal + 1;
                haveW = true;
            }
            if (haveW && iLocal < (tableJeu.getGrille2DDepart().length - 1)
                    && jLocal < (tableJeu.getGrille2DDepart().length - 1)
                    && tableJeu.getGrille2DDepart()[iLocal + 1][jLocal + 1] == joueurActuel) {
                tableJeu.getGrille2DArrivee()[i][j] = joueurActuel;
            }
        }
    }

    private static void positionnerDirectionBas(TableJeu tableJeu, int i, int j) {
        if (i < tableJeu.getGrille2DDepart().length - 1) {
            int iLocal = i;
            int jLocal = j;
            boolean haveW = false;
            while (iLocal < tableJeu.getGrille2DDepart().length - 1
                    && tableJeu.getGrille2DDepart()[iLocal + 1][jLocal] == joueurOppose) {
                iLocal = iLocal + 1;
                haveW = true;
            }
            if (haveW && iLocal < (tableJeu.getGrille2DDepart().length - 1)
                    && tableJeu.getGrille2DDepart()[iLocal + 1][jLocal] == joueurActuel) {
                tableJeu.getGrille2DArrivee()[i][j] = joueurActuel;
            }
        }
    }

    private static void positionnerDirectionHautDroite(TableJeu tableJeu, int i, int j) {
        if (i > 0 && j < tableJeu.getGrille2DDepart().length - 1) {
            int iLocal = i;
            int jLocal = j;
            boolean haveW = false;
            while (iLocal > 0 && jLocal < tableJeu.getGrille2DDepart().length - 1
                    && tableJeu.getGrille2DDepart()[iLocal - 1][jLocal + 1] == joueurOppose) {
                iLocal = iLocal - 1;
                jLocal = jLocal + 1;
                haveW = true;
            }
            if (haveW && iLocal > 0 && jLocal < (tableJeu.getGrille2DDepart().length - 1)
                    && tableJeu.getGrille2DDepart()[iLocal - 1][jLocal + 1] == joueurActuel) {
                tableJeu.getGrille2DArrivee()[i][j] = joueurActuel;
            }
        }
    }

    private static void positionnerDirectionHaut(TableJeu tableJeu, int i, int j) {
        int iLocal = i;
        int jLocal = j;
        boolean haveW = false;
        while (iLocal > 0 && tableJeu.getGrille2DDepart()[iLocal - 1][jLocal] == joueurOppose) {
            iLocal = iLocal - 1;
            haveW = true;
        }
        if (haveW && iLocal > 0 && tableJeu.getGrille2DDepart()[iLocal - 1][jLocal] == joueurActuel) {
            tableJeu.getGrille2DArrivee()[i][j] = joueurActuel;
        }
    }

    private static void positionnerDirectionBasGauche(TableJeu tableJeu, int i, int j) {
        if (i < tableJeu.getGrille2DDepart().length - 1) {
            int iLocal = i;
            int jLocal = j;
            boolean haveW = false;
            while (jLocal > 0 && iLocal < tableJeu.getGrille2DDepart().length - 1
                    && tableJeu.getGrille2DDepart()[iLocal + 1][jLocal - 1] == joueurOppose) {
                iLocal = iLocal + 1;
                jLocal = jLocal - 1;
                haveW = true;
            }
            if (haveW && jLocal > 0 && iLocal < (tableJeu.getGrille2DDepart().length - 1)
                    && tableJeu.getGrille2DDepart()[iLocal + 1][jLocal - 1] == joueurActuel) {
                tableJeu.getGrille2DArrivee()[i][j] = joueurActuel;
            }
        }
    }
}
