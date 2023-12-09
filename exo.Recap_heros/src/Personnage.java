import java.util.Random;
abstract class Personnage {
    String nom;
    int x;  // Coordonnée horizontale
    int y;  // Coordonnée verticale
    private int endurance;
    private int force;
    private int pv;

    // Constructeur avec paramètres
    public Personnage(String nom, int x, int y) {
        this.nom = nom;
        this.x = x;
        this.y = y;
        this.endurance = lanceQuatreDes() + lanceQuatreDes() + lanceQuatreDes();
        this.force = lanceQuatreDes() + lanceQuatreDes() + lanceQuatreDes();
        this.pv = calculerPV();
    }

    // Constructeur par défaut
    public Personnage() {
        this.endurance = lanceQuatreDes() + lanceQuatreDes() + lanceQuatreDes();
        this.force = lanceQuatreDes() + lanceQuatreDes() + lanceQuatreDes();
        this.pv = calculerPV();
    }

    // Méthodes getters et setters
    public int getEndurance() {
        return endurance;
    }
    public int getForce() {
        return force;
    }
    public int getPv() {
        return pv;
    }
    public void setPv(int pv) {
        this.pv = pv;
    }

    // Méthode de frappe
    public void frappe(Personnage cible) {
        int degats = lanceDeQuatreFaces() + getForceModifier();
        cible.setPv(cible.getPv() - degats);
        System.out.println("Frappe réussie ! " + cible.getClass().getSimpleName() + " perd " + degats + " PV.");
    }

    // Méthode abstraite pour miner
    public abstract void miner();

    // Méthode abstraite pour obtenir la valeur de miner
    public abstract int getMiner();

    // Méthode abstraite pour obtenir le modificateur d'endurance
    public abstract int getEnduranceModifier();

    // Méthode abstraite pour obtenir le modificateur de force
    protected abstract int getForceModifier();

    // Méthode privée pour calculer les points de vie
    private int calculerPV() {
        return getEndurance() + getEnduranceModifier();
    }

    // Méthode privée pour lancer quatre dés
    private int lanceQuatreDes() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }

    // Méthode privée pour lancer un dé à quatre faces
    private int lanceDeQuatreFaces() {
        Random rand = new Random();
        return rand.nextInt(4) + 1;
    }
}


