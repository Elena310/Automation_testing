package test;

public class Code {
    private int numberOfDay;
    private int numberOfLinesInADay = 100;

    public Code() {

    }

    public Code(int numberOfDay) {
        this.numberOfDay = numberOfDay;

    }

    public int develop() {
        return numberOfLinesInADay * numberOfDay;

    }
}
