public abstract class RPGCaracter {
    protected int level;
    protected String name;
    protected int health;

    RPGCaracter(int level, String name, int health) {
        this.level = level;
        this.name = name;
        this.health = health;
    }

    @Override
    public String toString() {
        return name;
    }

    public final void performAttack(RPGCaracter target){
        prepareAttack();
        int damage = calculateDamage();
        displayAttackAnimation(target);
        target.takeDamage(damage);
        afterAttack();
    }

    protected abstract int calculateDamage();


    protected abstract void displayAttackAnimation(RPGCaracter target);

    protected abstract double takeDamage(int damage);

    protected void prepareAttack() {
        System.out.println(name + " prepares to attack!");
    }

    protected void afterAttack() {

    }




}
