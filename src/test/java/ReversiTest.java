package reversi;

import org.junit.Assert;
import org.junit.Test;

import Reversi;
import TableJeu;

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
        TableJeu tableJeu = new TableJeu(etatJeuDepart);
        Assert.assertArrayEquals(grille, tableJeu.getGrille2DDepart());
    }

    @Test
    public void getProchainsMvmtsPossiblesWScenario1() {
        String etatJeuDepart = "........" + "\n" + "........" + "\n" + "........" + "\n" + "...BW..." + "\n"
                + "...WB..." + "\n" + "........" + "\n" + "........" + "\n" + "........" + "\n" + "W";
        String etatWJoue = "........" + "\n" + "........" + "\n" + "...W...." + "\n" + "..WBW..." + "\n" + "...WBW.."
                + "\n" + "....W..." + "\n" + "........" + "\n" + "........" + "\n" + "W";
        Assert.assertArrayEquals(new TableJeu(etatWJoue).getGrille2DDepart(), Reversi.positionnerJoueur(etatJeuDepart));
    }

    @Test
    public void getProchainsMvmtsPossiblesBScenario1() {
        String etatJeuDepart = "........" + "\n" + "........" + "\n" + "........" + "\n" + "...BW..." + "\n"
                + "...WB..." + "\n" + "........" + "\n" + "........" + "\n" + "........" + "\n" + "B";
        String etatBJoue = "........" + "\n" + "........" + "\n" + "....B..." + "\n" + "...BWB.." + "\n" + "..BWB..."
                + "\n" + "...B...." + "\n" + "........" + "\n" + "........" + "\n" + "B";
        Assert.assertArrayEquals(new TableJeu(etatBJoue).getGrille2DDepart(), Reversi.positionnerJoueur(etatJeuDepart));
    }

    @Test
    public void getProchainsMvmtsPossiblesBScenario2() {
        String etatJeuDepart = "........" + "\n" + "....W..." + "\n" + "..BBWW.." + "\n" + "..BBWW.." + "\n"
                + "..BWWW.." + "\n" + ".B.WWWW." + "\n" + "....WB.." + "\n" + "........" + "\n" + "B";
        String etatBJoue = ".....B.." + "\n" + "....WB.." + "\n" + "..BBWWB." + "\n" + "..BBWWB." + "\n" + "..BWWWBB"
                + "\n" + ".B.WWWW." + "\n" + "...BWBBB" + "\n" + ".....B.." + "\n" + "B";
        Assert.assertArrayEquals(new TableJeu(etatBJoue).getGrille2DDepart(), Reversi.positionnerJoueur(etatJeuDepart));
    }
}
