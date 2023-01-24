import java.util.Random;
//        ● Magic должен увеличивать атаку каждого героя после каждого раунда на n-ное
//        количество

public class Magic extends Hero {
    public Magic(int health, int damage) {
        super(health, damage, SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
        Random random = new Random();
        int damageUp=random.nextInt(1,10);
        for (int i = 0; i < heroes.length; i++) {
            if(heroes[i] != this){
                heroes[i].setDamage(heroes[i].getDamage()+damageUp);
                System.out.println(this.getClass().getSimpleName()+"  "+"damage up "+damageUp );
            }


        }
    }
}