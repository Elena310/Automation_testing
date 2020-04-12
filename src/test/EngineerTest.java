package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import worker.AutomationEngineer;
import worker.Engineer;
import worker.TestEngineer;

import java.util.Random;

public class EngineerTest {
    @Before
    public void beforeClass() {
        System.out.println("Test is launched");
    }

    @After
    public void afterClass() {
        System.out.println("Test is finished");
    }

    @Test
    public void getCodeTest() {
        Engineer engineer = new TestEngineer();
        Assert.assertEquals("Amount of code is not expected", engineer.invent(), 600);
    }

    @Test
    public void getCodeFailedTest() {
        Engineer engineer = new AutomationEngineer();
        Assert.assertEquals("Amount of code is not expected", engineer.invent(), 500);
    }

    @Test
    public void getSkillTest() {
        Engineer engineer = new TestEngineer();
        Assert.assertEquals("Value of skill reached beyond", engineer.getSkill(),
                new Random().nextInt(11));
    }

    @Test
    public void getAnxietyTest() {
        Engineer engineer = new AutomationEngineer();
        Assert.assertEquals("Value of anxiety is not expected", engineer.getAnxiety(), 3);
    }

    @Test
    public void getAnxietyFailTest() {
        Engineer engineer = new TestEngineer();
        Assert.assertEquals("Value of anxiety is not expected", engineer.getAnxiety(), 5);
    }
}
