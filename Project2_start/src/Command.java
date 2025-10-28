public abstract class Command {
    protected String name;
    // Lägga in arraylist då alla kommandon kommer använda denna?? :D

    public Command(String name) {
        this.name = name;

    }

    public abstract void execute();
}
