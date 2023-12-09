class Carte {
    private Case[][] cases;
    private static final int TAILLE_CASE = 2;  // Taille de chaque case en mètres
    public Carte(int largeur, int hauteur) {
        cases = new Case[hauteur][largeur];
        // Initialiser les cases de la carte
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                cases[i][j] = new Case("Forêt", TAILLE_CASE);  // Exemple : chaque case est initialement une partie de la forêt
            }
        }
        // Exemple : Ajouter des éléments spécifiques à certaines cases
        cases[1][1] = new Case("Montagne", TAILLE_CASE);
        cases[2][2] = new Case("Rivière", TAILLE_CASE);
    }
    private String getSymboleCase(Case laCase) {
        // Logique pour déterminer le symbole à afficher en fonction du contenu de la case
        switch (laCase.getContenu()) {
            case "Forêt":
                return "\uD83C\uDF32";  // Emoji représentant une partie de la forêt
            case "Montagne":
                return "\u26F0";  // Emoji représentant une montagne
            case "Rivière":
                return "\uD83C\uDF0A";  // Emoji représentant une rivière
            // Ajoutez d'autres cas selon votre logique
            default:
                return " ";  // Cas par défaut
        }
    }

    // Méthode pour afficher la carte
    public void afficherCarte() {
        for (int i = 0; i < cases.length; i++) {
            for (int j = 0; j < cases[i].length; j++) {
                System.out.print(getSymboleCase(cases[i][j]) + " ");
            }
            System.out.println();
        }
    }
}





