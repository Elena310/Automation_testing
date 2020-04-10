package people;

public interface Speakable {
    public default void speak() {
        System.out.println(String.format(" Hi, it is %s speaking!", this.getClass().getSimpleName()));
    }
}
