public class UnsafeBox {
    private Object content;

    public void store(Object item) {
        this.content = item;
    }

    public Object retrieve(){
        return content;
    }
}
