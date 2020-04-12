package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import people.Person;

public class PersonTest {
    @Before
    public void before() {
        System.out.println("Test is launched");
    }

    @After
    public void after() {
        System.out.println("Test is finished");
    }

    @Test
    public void getAgeTest() {
        Person person = new Person(34);
        Assert.assertEquals("Person age is not as expected!", person.getAge(), 34);
    }

    @Test
    public void getAgeFailedTest() {
        Person person = new Person(34);
        Assert.assertEquals("Person age is not as expected!", person.getAge(), 35);
    }

    @Test
    public void getNameTest() {
        Person person = new Person("Elena");
        Assert.assertEquals("Person name is not as expected", person.getName(), "Elena");
    }

    @Test
    public void getNameFailedTest() {
        Person person = new Person("Elena");
        Assert.assertEquals("Person name is not as expected", person.getName(), "Marina");
    }
}
