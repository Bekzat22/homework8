import java.util.Random;

public class Warrior extends Hero {
    public Warrior(int health, int damage) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperPower(Hero[] hero, Boss boss) {
        if (boss.getHealth() > 0) {
            Random random = new Random();
            int rand = random.nextInt(4) + 2;
            boss.setHealth(boss.getHealth() - this.getDamage() * rand);
            System.out.println("Warrior attack " + this.getDamage() * rand);

        }
    }
}
