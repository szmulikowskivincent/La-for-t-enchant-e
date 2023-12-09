class Humain extends Personnage {
    @Override
    public void miner() {
    }
    @Override
    public int getMiner() {
        return 0;
    }
    @Override
    public int getEnduranceModifier() {

        // Bonus d'endurance pour les humains
        return 1;
    }
    @Override
    public int getForceModifier() {

        // Bonus de force pour les humains
        return 5;
    }
    public void attaquer(Loup loup) {
    }
    public void seReposer() {
    }
}
