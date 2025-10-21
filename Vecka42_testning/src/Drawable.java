public interface Drawable {
    void draw();
    void move(int x, int y);

    default void hightlight() {
        System.out.println("Highlightning object");
    }
}
