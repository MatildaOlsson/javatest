public class SafeBox <T> {
    private T content;

    public void store(T item){
        this.content = item;
    }

    public T retrieve() {
        return content;
    }
}
