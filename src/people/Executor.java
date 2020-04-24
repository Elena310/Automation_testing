package people;

import entity.ATest;
import entity.AutomatedTest;
import entity.TestLevel;
import worker.Engineer;
import worker.TestEngineer;

public class Executor {
    public static void main(String[] args) {

        Engineer engineer = new TestEngineer();

        ATest test = new AutomatedTest(TestLevel.API, 3);
        System.out.println(engineer.executeTest(test));

    }

}

