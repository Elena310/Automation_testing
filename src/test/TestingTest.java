package test;

import entity.AutomatedTest;
import entity.ManualTest;
import entity.Result;
import org.junit.Assert;
import org.junit.Test;
import worker.AutomationEngineer;
import worker.Engineer;
import worker.TestEngineer;

public class TestingTest {
    @Test
    public void manualTestPassed() {
        Engineer engineer = new AutomationEngineer();
        entity.Test test = new ManualTest();
        test.setComplexity(2);
        test.setEngineer(engineer);
        test.setInstability(5);
        Assert.assertEquals(Result.PASSED, test.apply(2));

    }

    @Test
    public void automationTestPassed() {
        Engineer engineer = new TestEngineer();
        entity.Test test = new AutomatedTest();
        test.setComplexity(2);
        test.setEngineer(engineer);
        test.setInstability(5);
        Assert.assertEquals(Result.PASSED, test.apply(2));

    }

    @Test
    public void manualTest2Passed() {
        Engineer engineer = new TestEngineer();
        entity.Test test = new ManualTest();
        test.setComplexity(2);
        test.setEngineer(engineer);
        test.setInstability(5);
        Assert.assertEquals(Result.PASSED, test.apply(2));

    }

    @Test
    public void automationTest2Passed() {
        Engineer engineer = new AutomationEngineer();
        entity.Test test = new AutomatedTest();
        test.setComplexity(2);
        test.setEngineer(engineer);
        test.setInstability(5);
        Assert.assertEquals(Result.PASSED, test.apply(2));

    }

    @Test
    public void manualTestFailed() {
        Engineer engineer = new AutomationEngineer();
        entity.Test test = new ManualTest();
        test.setComplexity(5);
        test.setEngineer(engineer);
        test.setInstability(5);
        Assert.assertEquals(Result.FAILED, test.apply(2));

    }

    @Test
    public void manualTest2Failed() {
        Engineer engineer = new TestEngineer();
        entity.Test test = new ManualTest();
        test.setComplexity(5);
        test.setEngineer(engineer);
        test.setInstability(9);
        Assert.assertEquals(Result.FAILED, test.apply(2));

    }

    @Test
    public void automationTestFailed() {
        Engineer engineer = new TestEngineer();
        entity.Test test = new AutomatedTest();
        test.setComplexity(5);
        test.setEngineer(engineer);
        test.setInstability(5);
        Assert.assertEquals(Result.FAILED, test.apply(2));

    }

    @Test
    public void automationTest2Failed() {
        Engineer engineer = new AutomationEngineer();
        entity.Test test = new AutomatedTest();
        test.setComplexity(9);
        test.setEngineer(engineer);
        test.setInstability(5);
        Assert.assertEquals(Result.FAILED, test.apply(2));

    }
}
