package worker;

import entity.*;
import people.Person;

import java.util.Random;

public abstract class Engineer extends Person implements InventableCode, Testable {
    protected int skill = new Random().nextInt(10) + 1;
    protected int anxiety = 3;

    public int getAnxiety() {
        return anxiety;
    }

    public void setAnxiety(int anxiety) {
        this.anxiety = anxiety;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int invent() {
        Code code = new Code(6);
        code.develop();
        return code.develop();
    }


    public Result executeTest(ATest test) {
        return test.apply(this);
    }
}
