package tests_splitengineers;

import entity.ATest;
import entity.AutomatedTest;
import entity.ManualTest;
import entity.TestLevel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class InstabilityTest {
    private ATest test;
    private int expected;

    public InstabilityTest(ATest test, int expected) {
        this.test = test;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers() {
        return Arrays.asList(new Object[][]{
                {new ManualTest(TestLevel.UNIT, 0), 1},
                {new ManualTest(TestLevel.API, 1), 10},
                {new AutomatedTest(TestLevel.GUI, 10), 1},
                {new AutomatedTest(TestLevel.UNIT, 11), 10}
        });
    }

    @Test
    public void verifyInstability() {
        Assert.assertEquals("Value of instability is not correct!", expected, test.getInstability());
    }


}
