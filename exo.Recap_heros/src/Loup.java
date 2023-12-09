class Loup extends Personnage {
    @Override
    protected int getForceModifier() {
        return 1;
    }
    @Override
    public void miner() {
    }
    @Override
    public int getMiner() {
        return 0;
    }
    @Override
    public int getEnduranceModifier() {
        return 1;
    }
}
