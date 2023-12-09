class Orque extends Personnage {
    @Override
    public void miner() {
    }
    @Override
    public int getMiner() {
        return 2;
    }
    @Override
    public int getEnduranceModifier() {
        return 1;
    }
    @Override
    protected int getForceModifier() {

        // Bonus de force pour les orques
        return 3;
    }
}