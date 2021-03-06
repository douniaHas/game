package reversi;

public class TableJeu {
    public static final char S_RETOUR_A_LA_LIGNE = '\n';
    private static final int DIM = 8;
    private String grilleLineaire;
    private char[][] grille2DDepart;
    private char[][] grille2DArrivee;
    private char joueurActuel;
    private char joueurOppose;

    public TableJeu(String grilleLineaire) {
        if ("".equals(grilleLineaire) || grilleLineaire == null) {
            throw new IllegalArgumentException("La grille doit être initialisée");
        }
        this.grilleLineaire = grilleLineaire;
        this.grille2DDepart = transformerListeEnGrille(grilleLineaire);
        this.joueurActuel = construireJoueurActuel();
        this.joueurOppose = getOppose(joueurActuel);
    }

    public void copierGrille2DDepartVersArrivee() {
        char[][] copieGrille = new char[this.grille2DDepart.length][];
        for (int i = 0; i < this.grille2DDepart.length; i++) {
            copieGrille[i] = this.grille2DDepart[i].clone();
        }
        this.grille2DArrivee = copieGrille;
    }

    private char getOppose(char c) {
        return c == 'W' ? 'B' : 'W';
    }

    private char construireJoueurActuel() {
        return grilleLineaire.charAt(grilleLineaire.length() - 1);
    }

    private char[][] transformerListeEnGrille(String liste) {
        char[][] grille = new char[DIM][DIM];
        for (int i = 0; i < liste.length() - 1; i++) {
            if (liste.charAt(i) != S_RETOUR_A_LA_LIGNE) {
                grille[i / (DIM + 1)][i % (DIM + 1)] = liste.charAt(i);
            }
        }
        return grille;
    }

    public int getDim() {
        return DIM;
    }

    public String getGrilleLineaire() {
        return grilleLineaire;
    }

    public char[][] getGrille2DDepart() {
        return grille2DDepart;
    }

    public char[][] getGrille2DArrivee() {
        return grille2DArrivee;
    }

    public void setGrille2DArrivee(char[][] grille) {
        this.grille2DArrivee = grille;
    }

    public char getJoueurActuel() {
        return joueurActuel;
    }

    public char getJoueurOppose() {
        return joueurOppose;
    }
}
