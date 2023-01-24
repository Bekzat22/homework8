//        ● Berserk должен получать от босса урон, и потом наносить ему свой урон + часть
//        урона полученного от босса

public class Berserk extends Hero{
    public Berserk(int health, int damage) {
        super(health, damage,SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
        int revert = boss.getDamage()/5;
            boss.setHealth(boss.getHealth() -  revert);

            System.out.println("berserk returns " +revert);




    }
}
