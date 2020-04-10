package people;

import test.ManualTest;
import test.Test;
import worker.Engineer;
import worker.TestEngineer;

public class Executor {
    public static void main(String[] args) {

        Engineer engineer = new TestEngineer();

        Test test = new ManualTest();

        test.setComplexity(2);
        test.setEngineer(engineer);
        test.setInstability(5);

        System.out.println(test.apply(5));
        engineer.invent();
        System.out.println(engineer.invent());


    }

}

