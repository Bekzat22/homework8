import java.util.Random;

public class RPG_Game {
    static int roundCounter=0;
    public  static Random random=new Random();

    public static void start() {

        Boss boss = new Boss(1500, 50);
        Warrior warrior = new Warrior(240, 25);
        Medic doc = new Medic(200, 5, 15);
        Magic magic = new Magic(120, 20);
        Medic assistant = new Medic(180, 15, 5);
        Berserk berserk = new Berserk(300,10);
        Hero[] heroes = {warrior, magic, doc, assistant,berserk};
        printStatistics(heroes, boss);

        while (!isGameFinished(heroes, boss)) {
            round(heroes, boss);
            roundCounter++;
        }
    }

    private static void round(Hero[] heroes, Boss boss) {
        bossHits(heroes, boss);
        ApplyAbility(heroes, boss);
        heroesHit(heroes, boss);
        printStatistics(heroes, boss);
    }

    private static void bossHits(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].setHealth(
                        heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

   


    private static void ApplyAbility(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].applySuperPower(heroes, boss);
            }
        }
    }

    private static void heroesHit(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }
    }

    private static boolean isGameFinished(Hero[] heroes, Boss boss) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void printStatistics(Hero[] heroes, Boss boss) {
        System.out.println("______________");
        System.out.println("Round: "+roundCounter);
        System.out.println("Boss health: " + boss.getHealth() +
                ", damage: " + boss.getDamage());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() + " health: "
                    + heroes[i].getHealth() +
                    ", damage: " + heroes[i].getDamage());
        }
        System.out.println("____________");
    }
}
