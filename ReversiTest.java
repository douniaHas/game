package fr.erdf.siae.business.a06;

import org.junit.Assert;
import org.junit.Test;

import fr.erdf.siae.business.a0x.Reversi;

public class ReversiTest {
    @Test
    public void transformerListeEnGrilleNonVide() {
        String etatJeuDepart = "........" + "\n" + "........" + "\n" + "........" + "\n" + "........" + "\n"
                + "........" + "\n" + ".B......" + "\n" + "....WB.." + "\n" + "........" + "\n" + "B";
        final int dim = 8;
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

    @Test(expected = IllegalArgumentException.class)
    public void transformerListeEnGrilleVide() {
        Reversi.transformerListeEnGrille("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void transformerEnGrilleListeAbsente() {
        Reversi.transformerListeEnGrille(null);
    }

    @Test
    public void getProchainsMouvementsPossiblesNoirDirectionGauche() {
        String etatJeuDepart = "........" + "\n" + "........" + "\n" + "........" + "\n" + "...BW..." + "\n"
                + "...WB..." + "\n" + "........" + "\n" + "........" + "\n" + "........" + "\n" + "B";
        String etatJeuB = "........" + "\n" + "........" + "\n" + "........" + "\n" + "...BWB.." + "\n" + "...WB..."
                + "\n" + "........" + "\n" + "........" + "\n" + "........" + "\n" + "B";
        Assert.assertArrayEquals(Reversi.transformerListeEnGrille(etatJeuB), Reversi.positionnerNoir(etatJeuDepart));
    }
}