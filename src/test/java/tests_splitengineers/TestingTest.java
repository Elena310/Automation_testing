package tests_splitengineers;

import entity.*;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import worker.AutomationEngineer;
import worker.Engineer;
import worker.TestEngineer;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestingTest {

    private Engineer en;
    private ATest test;
    private int skill;
    private Result expected;

    public TestingTest(Engineer en, int skill, ATest test, Result expected) {
        this.en = en;
        this.test = test;
        this.skill = skill;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers() {
        return Arrays.asList(new Object[][]{
                {new TestEngineer(), 1, new ManualTest(TestLevel.UNIT, 10), Result.PASSED},
                {new TestEngineer(), 10, new ManualTest(TestLevel.API, 0), Result.PASSED},
                {new TestEngineer(), 1, new ManualTest(TestLevel.UNIT, 11), Result.PASSED},
                {new TestEngineer(), 10, new ManualTest(TestLevel.GUI, 1), Result.PASSED},
                {new TestEngineer(), 1, new AutomatedTest(TestLevel.GUI, 0), Result.PASSED},
                {new TestEngineer(), 10, new AutomatedTest(TestLevel.API, 11), Result.PASSED},
                {new TestEngineer(), 1, new AutomatedTest(TestLevel.UNIT, 1), Result.PASSED},
                {new TestEngineer(), 10, new AutomatedTest(TestLevel.UNIT, 1), Result.PASSED},
                {new AutomationEngineer(), 10, new AutomatedTest(TestLevel.API, 0), Result.PASSED},
                {new AutomationEngineer(), 1, new AutomatedTest(TestLevel.GUI, 10), Result.FAILED},
                {new AutomationEngineer(), 10, new AutomatedTest(TestLevel.UNIT, 1), Result.PASSED},
                {new AutomationEngineer(), 10, new AutomatedTest(TestLevel.UNIT, 11), Result.PASSED},
                {new AutomationEngineer(), 10, new ManualTest(TestLevel.GUI, 11), Result.PASSED},
                {new AutomationEngineer(), 1, new ManualTest(TestLevel.API, 1), Result.PASSED},
                {new AutomationEngineer(), 10, new ManualTest(TestLevel.UNIT, 0), Result.PASSED},
                {new AutomationEngineer(), 10, new ManualTest(TestLevel.API, 10), Result.PASSED}
        });
    }

    @Test
    public void verifyExecuteTest() {
        en.setSkill(skill);
        Assert.assertEquals("Engineer is not correct!", expected, en.executeTest(test));
    }
}
