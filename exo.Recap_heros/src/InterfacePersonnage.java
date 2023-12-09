import java.util.Random;

public interface InterfacePersonnage {
    void frapper(Personnage cible);
    void seReposer();

    // Ajout de la méthode miner() dans l'interface
    interface Nain {
        // Implémentation des méthodes nécessaires
        void frapper(Personnage cible);
        void seReposer();
        void miner();
    }

    // Interface pour les personnages
    interface Interfacepersonnage {
        void frapper(Personnage cible);
        void seReposer();
    }
    class Personnage implements InterfacePersonnage {
        String nom;
        int endurance;
        int force;
        int pv;
        Richesse richesse;
        public Personnage(String nom, int endurance, int force) {
            this.nom = nom;
            this.endurance = endurance;
            this.force = force;
            this.pv = calculerPV();
            this.richesse = new Richesse(0, 0);
        }
        public int calculerPV() {
            int modificateurEndurance = this.endurance / 2;
            return this.endurance + modificateurEndurance;
        }
        public void frapper(Personnage cible) {
            Random random = new Random();
            int degats = random.nextInt(4) + this.force / 2 + 1;
            cible.pv -= degats;
            System.out.println(this.nom + " frappe " + cible.nom + " et lui inflige " + degats + " points de dégâts.");
        }
        public void seReposer() {
            this.pv = calculerPV();
            System.out.println(this.nom + " se repose et restaure ses points de vie à " + this.pv + ".");
        }
    }
    class Heros extends Personnage {
        public Heros(String nom, String race) {
            super(nom, 0, 0);
            if (race.equals("humain")) {
                this.endurance += 1;
                this.force += 1;
            } else if (race.equals("nain")) {
                this.endurance += 2;
            }
        }
    }
    class Monstre extends Personnage {
        boolean peutDepecer;
        public Monstre(String nom, String race) {
            super(nom, 0, 0);
            if (race.equals("loup")) {
                this.peutDepecer = true;
            } else if (race.equals("orque")) {
                this.force += 1;
                this.richesse.or = new Random().nextInt(10) + 1;
            } else if (race.equals("dragonnet")) {
                this.endurance += 1;
                this.richesse.or = new Random().nextInt(5) + 1;
                this.peutDepecer = true;
            }
        }
    }
    class Richesse {
        int or;
        int cuir;
        public Richesse(int or, int cuir) {
            this.or = or;
            this.cuir = cuir;
        }
    }
}