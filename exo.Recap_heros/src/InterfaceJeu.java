import java.util.Random;
public interface InterfaceJeu {
    abstract class Personnage {
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

        public abstract void mourir();
    }
    class Heros extends Personnage {
        public int x;
        public int y;

        public Heros(String nom, String race) {
            super(nom, 0, 0);
            if (race.equals("humain")) {
                this.endurance += 1;
                this.force += 1;
            } else if (race.equals("nain")) {
                this.endurance += 2;
            }
        }
        @Override
        public void mourir() {
            System.out.println("Le héros " + this.nom + " est mort.");
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
                this.peutDepecer = true;}
        }
        @Override
        public void mourir() {
            System.out.println("Le monstre " + this.nom + " est mort.");
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
