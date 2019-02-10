package fr.erdf.siae.business.a06;

import org.junit.Assert;
import org.junit.Test;

import fr.erdf.siae.business.a0x.Reversi;

public class ReversiTest {
    @Test
    public void transformerListeEnGrille() {
        String etatJeuDepart = "........" + "\n" + "........" + "\n" + "........" + "\n" + "........" + "\n"
                + "........" + "\n" + ".B......" + "\n" + "....WB.." + "\n" + "........" + "\n" + "B";
        int dim = 8;
        char[][] grille = new char[dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                grille[i][j] = '.';
            }
        }
        grille[5][1] = 'B';
        grille[6][4] = 'W';
        grille[6][5] = 'B';
        Assert.assertArrayEquals(grille, Reversi.transformerListeEnGrille(etatJeuDepart));
    }
}