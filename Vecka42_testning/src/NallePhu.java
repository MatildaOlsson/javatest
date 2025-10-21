public class NallePhu extends RPGCaracter {
    private final int amountOfHoneyCans;

    private NallePhu(int level, String name, int health, int amountOfHoneyCans) {
        super(level,  name, health);
        this.amountOfHoneyCans = amountOfHoneyCans;
    }

    private static NallePhu instance;

    public static NallePhu getInstance() {
        return instance;
    }

    @Override
    protected int calculateDamage() {
        int damage = level * amountOfHoneyCans;
        System.out.println("Damage: " + damage);
        return damage;
    }


    @Override
    protected void displayAttackAnimation(RPGCaracter target) {
        System.out.println("Nalle Phu jonglerar med sina " +  amountOfHoneyCans + " honungburkar och kastar dem alla på sin fiende " + target);

    }

    @Override
    protected double takeDamage(int damage) {
        System.out.println("Health decreases with " +  damage);
        return health - damage;

    }
}
