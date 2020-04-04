package day_3_home_task;

public class Manual extends Engineer implements AbleToRunTests {
    @Override
    public void run() {
        System.out.println("Manual runs tests");
    }
}
