package entity;

import worker.AutomationEngineer;
import worker.Engineer;
import worker.TestEngineer;

interface Function<Engineer, Result> {
    Result apply(int anxiety);
}

public abstract class Test implements Function<Engineer, Result> {
    int complexity;
    int instability;
    Result result;
    Engineer engineer;

    public Test() {

    }

    public Test(int complexity) {
        this.complexity = complexity;

    }

    public Test(TestLevel testLevel) {
        this.complexity = testLevel.getCOMPLEXITY();

    }

    public Test(TestLevel testLevel, int instability) {
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

    public Engineer getEngineer() {
        return engineer;
    }

    public void setEngineer(Engineer engineer) {
        this.engineer = engineer;
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

    @Override
    public Result apply(int anxiety) {
        if ((this.getClass().getCanonicalName() == ManualTest.class.getCanonicalName()) &&
                (engineer.getClass().getCanonicalName() == AutomationEngineer.class.getCanonicalName())) {
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

