package entity;

import worker.AutomationEngineer;
import worker.Engineer;
import worker.TestEngineer;

interface Function<Engineer, Result> {
    Result apply(Engineer engineer);
}

public abstract class ATest implements Function<Engineer, Result> {
    int complexity;
    int instability;
    Result result;

    public ATest() {

    }

    public ATest(TestLevel testLevel, int instability) {
        this.complexity = testLevel.getCOMPLEXITY();
        if (instability == 0) {
            this.instability = 1;
        } else if (instability > 10) {
            this.instability = 10;
        } else {
            this.instability = instability;
        }
    }

    public int getInstability() {
        return instability;
    }

    public void setInstability(int instability) {
        this.instability = instability;
    }

    public int getComplexity() {
        return complexity;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public Result getResult() {
        return result;
    }


    public Result apply(Engineer engineer) {
        int anxiety = 3;
        if ((this.getClass().getCanonicalName() == ManualTest.class.getCanonicalName()) &&
                engineer.getClass().getCanonicalName() == AutomationEngineer.class.getCanonicalName()) {
            engineer.setAnxiety(anxiety);
        } else if ((this.getClass().getCanonicalName() == AutomatedTest.class.getCanonicalName()) &&
                (engineer.getClass().getCanonicalName() == TestEngineer.class.getCanonicalName())) {
            engineer.setAnxiety(anxiety);
        } else {
            engineer.setAnxiety(1);
        }
        if ((anxiety * complexity * instability) / engineer.getSkill() > 30) {
            result = Result.FAILED;
            return Result.FAILED;
        } else {
            result = Result.PASSED;
            return Result.PASSED;
        }


    }
}

