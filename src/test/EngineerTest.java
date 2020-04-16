package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import worker.AutomationEngineer;
import worker.Engineer;
import worker.TestEngineer;

public class EngineerTest {

    private Engineer testEngineer = new TestEngineer();
    private Engineer automationEngineer = new AutomationEngineer();

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
        Assert.assertEquals("Amount of code is not expected", testEngineer.invent(), 600);
    }

    @Test
    public void getCodeFailedTest() {
        Assert.assertEquals("Amount of code is not expected", automationEngineer.invent(), 500);
    }

    @Test
    public void getRandomSkillTest() {
        Assert.assertTrue("Value of skill reached beyond", automationEngineer.getSkill() >= 1 &&
                automationEngineer.getSkill() < 11);
    }

    @Test
    public void setSkillByAutomation() {
        automationEngineer.setSkill(5);
        Assert.assertEquals("Value of skill is not correct", 5, automationEngineer.getSkill());
    }

    @Test
    public void verifyDefaultAnxietyByManual() {
        Assert.assertEquals("Value of anxiety is not expected", 3, testEngineer.getAnxiety());
    }

    @Test
    public void verifySetAnxietyByManual() {
        testEngineer.setAnxiety(8);
        Assert.assertEquals("Value of anxiety is not expected", 8, testEngineer.getAnxiety());
    }

    @Test
    public void speakTest() {
        Engineer engineer = new TestEngineer();
        Assert.assertEquals("Hi, it is TestEngineer speaking!", engineer.speak());
    }
}
