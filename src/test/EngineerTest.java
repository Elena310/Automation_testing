package test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import worker.AutomationEngineer;
import worker.Engineer;
import worker.TestEngineer;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class EngineerTest {

    private Engineer en;

    public EngineerTest(Engineer en) {
        this.en = en;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers() {
        return Arrays.asList(new Object[][]{
                {new TestEngineer()},
                {new AutomationEngineer()}
        });
    }

    @Test
    public void getRandomSkillTest() {
        Assert.assertTrue("Value of skill reached beyond", en.getSkill() >= 1 &&
                en.getSkill() < 11);
    }

    @Test
    public void setSkillByAutomation() {
        en.setSkill(5);
        Assert.assertEquals("Value of skill is not correct", 5, en.getSkill());
    }

    @Test
    public void verifyDefaultAnxietyByManual() {
        Assert.assertEquals("Value of anxiety is not expected", 3, en.getAnxiety());
    }

    @Test
    public void verifySetAnxietyByManual() {
        en.setAnxiety(3);
        Assert.assertEquals("Value of anxiety is not expected", 3, en.getAnxiety());
    }
}
