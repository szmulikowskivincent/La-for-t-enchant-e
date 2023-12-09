class Nain extends Personnage {
    @Override
    public int getMiner() {
        System.out.println("Le nain commence à miner !");

        // Ajoutez ici le code spécifique à l'action de miner du Nain
        return 4;
    }
    @Override
    public int getEnduranceModifier() {

        // Bonus d'endurance pour les nains
        return 2;
    }
    @Override
    protected int getForceModifier() {
        return 0;
    }
    public void seReposer() {
    }
    public void attaquer(Dragonnet dragonnet) {
    }
    public void miner() {
    }
}

