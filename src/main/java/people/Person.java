package people;

public class Person extends Human {

    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Person() {

    }

    public Person(int age) {
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(int age, String name, String surname) {
        super.age = age;
        this.name = name;
        this.surname = surname;
    }

    public String toString() {
        return getClass().getName() + "age: " + age + "name: " + name + "surname: " + surname;
    }
}
