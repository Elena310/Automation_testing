package people;

public interface Speakable {
    default String speak() {
        return String.format("Hi, it is %s speaking!", this.getClass().getSimpleName());
    }
}
