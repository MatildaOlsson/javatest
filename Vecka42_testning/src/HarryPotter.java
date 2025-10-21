public class HarryPotter extends RPGCaracter{

    HarryPotter(int level, String name, int health){
        super(level, name , health);
    }

    @Override
    protected int calculateDamage() {
        return 0;
    }

    @Override
    protected void displayAttackAnimation(RPGCaracter target) {

    }

    @Override
    protected double takeDamage(int damage) {
        return 0;
    }


}
