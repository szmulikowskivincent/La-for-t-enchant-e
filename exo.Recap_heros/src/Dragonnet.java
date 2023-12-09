class Dragonnet extends Personnage {
    @Override
    public void miner() {

    }
    @Override
    public int getMiner() {
        return 0;
    }
    @Override
    public int getEnduranceModifier() {

        // Bonus d'endurance pour les dragonnets
        return 1;
    }
    @Override
    protected int getForceModifier() {

        // Bonus de force pour les dragonnets
        return 1;
    }
}



