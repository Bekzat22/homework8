public abstract class Hero extends GameEntity
        implements HavingPower {
    private SuperAbility superAbility;


    public Hero(int health, int damage, SuperAbility superAbility) {
        super(health, damage);
        this.superAbility = superAbility;
    }
}
