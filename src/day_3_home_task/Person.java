package day_3_home_task;

public class Person extends Human{

    private String name;
    private String surname;

    public Person(){

    }

    public Person(int age, String name, String surname){
        super.age = age;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public void speak() {
        System.out.println("Person is speaking");
    }
}
