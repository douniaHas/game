package fr.erdf.siae.business.a06;

import org.junit.Assert;
import org.junit.Test;

import fr.erdf.siae.business.a0x.Reversi;
import fr.erdf.siae.business.a0x.TableJeu;

public class ReversiTest {
    @Test
    public void transformerListeEnGrilleNonVide() {
        String etatJeuDepart = "........" + "\n" + "........" + "\n" + "........" + "\n" + "........" + "\n"
                + "........" + "\n" + ".B......" + "\n" + "....WB.." + "\n" + "........" + "\n" + "B";
        TableJeu tableJeu = new TableJeu(etatJeuDepart);
        char[][] grille = new char[tableJeu.getDim()][tableJeu.getDim()];
        for (int i = 0; i < tableJeu.getDim(); i++) {
            for (int j = 0; j < tableJeu.getDim(); j++) {
                grille[i][j] = '.';
            }
        }
        grille[5][1] = 'B';
        grille[6][4] = 'W';
        grille[6][5] = 'B';
        Assert.assertArrayEquals(grille, Reversi.transformerListeEnGrille(tableJeu));
    }

    @Test(expected = IllegalArgumentException.class)
    public void transformerListeEnGrilleVide() {
        TableJeu tableJeu = new TableJeu("");
        Reversi.transformerListeEnGrille(tableJeu);
    }

    @Test(expected = IllegalArgumentException.class)
    public void transformerEnGrilleListeAbsente() {
        TableJeu tableJeu = new TableJeu(null);
        Reversi.transformerListeEnGrille(tableJeu);
    }
}