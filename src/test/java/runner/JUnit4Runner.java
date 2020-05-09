package runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests_splitengineers.EngineerTest;
import tests_splitengineers.TestingTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({EngineerTest.class, TestingTest.class})
public class JUnit4Runner {
}
