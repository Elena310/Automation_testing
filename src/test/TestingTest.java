package test;

import entity.AutomatedTest;
import entity.ManualTest;
import entity.Result;
import entity.TestLevel;
import org.junit.Assert;
import org.junit.Test;
import worker.AutomationEngineer;
import worker.Engineer;
import worker.TestEngineer;

public class TestingTest {

    public Result apply(TestLevel testLevel, int instability, int complexity, int anxiety) {
        Engineer engineer = new AutomationEngineer();
        entity.Test test = new ManualTest(testLevel, instability);
        test.setComplexity(complexity);
        test.setEngineer(engineer);
        return test.apply(anxiety);
    }

    public Result apply1(TestLevel testLevel, int instability, int complexity, int anxiety) {
        Engineer engineer = new TestEngineer();
        entity.Test test = new ManualTest(testLevel, instability);
        test.setComplexity(complexity);
        test.setEngineer(engineer);
        return test.apply(anxiety);
    }

    public Result apply2(TestLevel testLevel, int instability, int complexity, int anxiety) {
        Engineer engineer = new TestEngineer();
        entity.Test test = new AutomatedTest(testLevel, instability);
        test.setComplexity(complexity);
        test.setEngineer(engineer);
        return test.apply(anxiety);
    }

    public Result apply3(TestLevel testLevel, int instability, int complexity, int anxiety) {
        Engineer engineer = new AutomationEngineer();
        entity.Test test = new AutomatedTest(testLevel, instability);
        test.setComplexity(complexity);
        test.setEngineer(engineer);
        return test.apply(anxiety);
    }

    @Test
    public void verifyExecuteManualTest1ByAutomationEngineer() {
        Assert.assertEquals(Result.PASSED, this.apply(TestLevel.UNIT, 1, 2, 3));
    }

    @Test
    public void verifyExecuteManualTest2ByAutomationEngineer() {
        Assert.assertEquals(Result.FAILED, this.apply(TestLevel.GUI, 10, 10, 3));
    }

    @Test
    public void verifyExecuteManualTest1ByTestEngineer() {
        Assert.assertEquals(Result.PASSED, this.apply1(TestLevel.API, 2, 1, 1));
    }

    @Test
    public void verifyExecuteManualTest2ByTestEngineer() {
        Assert.assertEquals(Result.FAILED, this.apply1(TestLevel.GUI, 10, 20, 1));
    }

    @Test
    public void verifyExecuteAutomatedTest1ByTestEngineer() {
        Assert.assertEquals(Result.PASSED, this.apply2(TestLevel.API, 2, 2, 3));
    }

    @Test
    public void verifyExecuteAutomatedTest2ByTestEngineer() {
        Assert.assertEquals(Result.FAILED, this.apply2(TestLevel.GUI, 20, 40, 3));
    }

    @Test
    public void verifyExecuteAutomatedTest1ByAutomationEngineer() {
        Assert.assertEquals(Result.PASSED, this.apply3(TestLevel.UNIT, 3, 2, 1));
    }

    @Test
    public void verifyExecuteAutomatedTest2ByAutomationEngineer() {
        Assert.assertEquals(Result.FAILED, this.apply3(TestLevel.GUI, 20, 40, 1));
    }
}
