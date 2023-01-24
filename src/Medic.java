
    public class Medic extends Hero {
        private int healPoints;

        public Medic(int health, int damage, int healPoints) {
            super(health, damage, SuperAbility.HEAL);
            this.healPoints = healPoints;
        }

        public int getHealPoints() {
            return healPoints;
        }

        public void setHealPoints(int healPoints) {
            this.healPoints = healPoints;
        }

        @Override
        public void applySuperPower(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && heroes[i].getHealth()<100&& heroes[i] != this) {
            heroes[i].setHealth(heroes[i].getHealth() + this.healPoints);
                System.out.println(this.getClass().getSimpleName()+
                        " "+"health points "+this.healPoints+" "+heroes[i].getClass().getSimpleName());
            }
        }
        }
    }

