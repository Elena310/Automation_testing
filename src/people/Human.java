package people;

public abstract class Human implements Speakable {
    protected int age;

    public Human(int age) {
        this.age = age;
    }

    public Human() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
