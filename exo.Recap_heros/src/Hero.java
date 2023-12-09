class Heros {
    private String nom; // Nom du joueur
    private String race; // Race du joueur
    private int x; // Coordonnée x du joueur
    private int y; // Coordonnée y du joueur

    // Constructeur avec initialisation des coordonnées
    public Heros(String nom, String race, int x, int y) {
        this.nom = nom;
        this.race = race;
        this.x = x;
        this.y = y;
    }

    // Méthode pour afficher les informations du héros
    public void afficherInfos() {
        System.out.println("Nom: " + nom);
        System.out.println("Race: " + race);
        System.out.println("Coordonnées (x, y): (" + x + ", " + y + ")");
    }

    // Méthode pour déplacer le héros
    public void deplacer(int newX, int newY) {
        x = newX;
        y = newY;
        System.out.println("Le héros a été déplacé aux coordonnées (x, y): (" + x + ", " + y + ")");
    }

    // Autres méthodes et membres de la classe...

    // Exemple d'une méthode additionnelle
    public void attaquer() {
        System.out.println("Le héros attaque !");
        // Logique d'attaque...
    }

    // Exemple d'une autre méthode additionnelle
    public void utiliserPotion() {
        System.out.println("Le héros utilise une potion !");
        // Logique d'utilisation de potion...
    }

    // Getters pour le nom et la race
    public String getNom() {
        return nom;
    }

    public String getRace() {
        return race;
    }

    // Getters pour les coordonnées x et y
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

